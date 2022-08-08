package com.forus.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.hql.internal.ast.tree.SessionFactoryAwareNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.forus.domain.gCategoryVO;
import com.forus.domain.gLocationVO;
import com.forus.domain.g_locationVO;
import com.forus.domain.goodsListVO;
import com.forus.domain.goodsPuchaseVO;
import com.forus.domain.goodsVO;
import com.forus.domain.userInfoVO;
import com.forus.domain.wishListVO;
import com.forus.mapper.GoodsMapper;
import com.forus.mapper.UserMapper;
import com.forus.mapper.ViewMapper;

@Controller
public class GoodsController {
	
	
	
	@Autowired
	GoodsMapper mapper;
	
	@Autowired
	ViewMapper vMapper;
	
	@Autowired
	UserMapper uMapper;
	
	// 상품 리스트 불러오기
	@RequestMapping("/index.do")
	public void index(Model model ,HttpServletRequest request, HttpSession session) {
		
		// 데이터 호출하기
		String user_addr = request.getParameter("user_addr");
		String user_id = request.getParameter("user_id");
		
		
		//회원 주소에 맞는 아파트에서 상품 리스트 불러오기
		List<goodsListVO> result = mapper.goodsList(user_addr);
		System.out.println("list"+result);
		
		// 회원 주소 아파트 이름 가져오기
		String apt_name = mapper.selectAptName(user_addr);
		System.out.println("apt_name"+apt_name);
		
		List<gCategoryVO> category=vMapper.goodsCategory();
		System.out.println("결과 "+category);
		model.addAttribute("categoryList", category);
		
		
		
		
		// 제품 리스트 보내기
		model.addAttribute("GoodsList", result);
		
		// 아파트 보내주기
		model.addAttribute("apt_name",apt_name);
		session.setAttribute("user_addr", user_addr);
		session.setAttribute("user_id", user_id);
		System.out.println(session.getAttribute("user_addr"));
		
	}
	
	
	// 상품 한개 상세 정보 불러오기
	@RequestMapping("/goodsInfo.do")
	public void goodsInfo(int g_seq, String apt_name, HttpServletRequest request) {
		goodsVO result =mapper.goodsInfo(g_seq);
		result.setSeller_nick(mapper.seller_nickSelect(result.getSeller_id()));
		System.out.println(result);
		request.setAttribute("goodsInfo", result);
		request.setAttribute("apt_name", apt_name);
	}
	
	
	// 상품 등록
	@RequestMapping("goodsInsert.do")
	public String goodsInsert(@RequestParam("g_imgg") MultipartFile file, HttpSession session, goodsVO vo, Model model) {


		String path = session.getServletContext().getRealPath("/file");

		System.out.println("경로 : " + path);
		System.out.println("goodsvo 확인 "+ vo);
		
		
		
		// 이미지 저장하기
        String uuid = UUID.randomUUID().toString();
        // file upload to system
        File converFile = new File(path, uuid + file.getOriginalFilename());
        try {
			file.transferTo(converFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
        // 상품 등록 전에 비어있는 loc_seq 번호 중 한개 가져오기 
        int loc_seq = mapper.loc_seqSelect(vo.getUser_addr());
        System.out.println(loc_seq);
        // 상품 등록
        String msg = file.getOriginalFilename() + " is saved in server db";
        String g_img = uuid + file.getOriginalFilename();
        vo.setG_img(g_img);
        vo.setLoc_seq(loc_seq);
   
        mapper.goodsInsert(vo);
        
        
        
        
        // 상품 등록 후  wishlist에 기본 값 넣어주기
        // 1) g_seq 번호 필요
        
        int g_seq = mapper.g_seqSelect(vo);
        
        wishListVO wishVO = new wishListVO(g_seq, vo.getSeller_id(),0);
        mapper.wishDefault(wishVO);
        
        
		
		// 랜덤 자판기 비밀번호 생성 
		Random rd = new Random();
		int pw = 0;
		int a = 1;
		
		for(int i = 1; i<=4 ; i++) {
			pw= rd.nextInt(9)*a;
			a *= 10;
		}
		
		gLocationVO gvo = new gLocationVO();
		gvo.setV_machine_pw(pw);
		gvo.setLoc_seq(loc_seq);
		
		// update로 자판기 비밀번호 변경
		mapper.machinePwUpdate(gvo);
	
		
		// 상품 이름, 아파트 이름, 자판기 번호, 자판기 칸 비밀 번호 뿌려주기
		g_locationVO gVO= mapper.gLocationSelect(g_seq);
		gVO.setStatus("제품 판매");
		
    	model.addAttribute("goodsResult", gVO);
		
    	return "goodsResult";
		

	}

	// 상품 구입 
	@RequestMapping("goodsPurchase.do")
	public String goodsPurchase(goodsPuchaseVO vo, int user_point, Model model) {
		
		
		mapper.goodsCosumerUpdate(vo);
		
		userInfoVO infoVO = new userInfoVO();
		infoVO.setUser_id(vo.getConsumer_id());
		infoVO.setUser_point(user_point);
		
		if (user_point >0){
			uMapper.PointUpdate(infoVO);
		}
		
		
		g_locationVO gVO = mapper.gLocationSelect(vo.getG_seq());
		gVO.setStatus("제품 구매");
		
		model.addAttribute("goodsResult", gVO);
		
		return "goodsResult";
	}
	
	
	// 제품 판매중인 내역 
	@RequestMapping("goodsSaleList.do")
	public String goodsSaleList(String user_id, Model model) {
		List<goodsListVO> list =mapper.goodsSaleList(user_id);
		model.addAttribute("GoodsList", list); 
		return "proList";
	}
	

	// 제품 구매 내역
	@RequestMapping("goodsBuyList.do")
	public String goodsPurchaseList(String user_id, Model model){
		List<goodsListVO> list = mapper.goodsPurchaseList(user_id);
		model.addAttribute("GoodsList", list); 
		return "buyList";
	}
	
	// 상품 삭제 
	@RequestMapping("goodsDelete.do")
	public void goodsDelete(int g_seq) {
		int row = 0;
		row = mapper.goodsDelete(g_seq);
		
		//삭제후 리스트 보여주
	}
	

	
	
	
	
}
