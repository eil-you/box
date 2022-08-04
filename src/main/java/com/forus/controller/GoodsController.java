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

import com.forus.domain.gLocationVO;
import com.forus.domain.goodsListVO;
import com.forus.domain.goodsVO;
import com.forus.domain.userInfoVO;
import com.forus.mapper.GoodsMapper;

@Controller
public class GoodsController {
	
	
	
	@Autowired
	GoodsMapper mapper;
	
	
	// 상품 리스트 불러오기
	@RequestMapping("/index.do")
	public void index(Model model ,HttpServletRequest request, HttpSession session) {
		// 회원 주소에 맞는 아파트에서 상품 리스트 불러오기
		String user_addr = request.getParameter("user_addr");
		System.out.println(user_addr);
		String user_id = request.getParameter("user_id");
		System.out.println(user_id);
		List<goodsListVO> result = mapper.goodsList(user_addr);
		System.out.println("list"+result);
		// 회원 주소 아파트 이름 가져오기
		String apt_name = mapper.selectAptName(user_addr);
		System.out.println("apt_name"+apt_name);
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
	public String goodsInfo(int g_seq, String apt_name, HttpServletRequest request) {
		goodsVO result =mapper.goodsInfo(g_seq);
		result.setSeller_nick(mapper.seller_nickSelect(result.getSeller_id()));
		System.out.println(result);
		request.setAttribute("goodsInfo", result);
		request.setAttribute("apt_name", apt_name);
		
		
		return "goodsInfo";
	}
	
	
	// 상품 등록
	@RequestMapping("goodsInsert.do")
	public ModelAndView goodsInsert(@RequestParam("g_imgg") MultipartFile file, HttpSession session, goodsVO vo, ModelMap model) {


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
        // 상품 등록 전에 비어있는 g_seq 번호 중 한개 가져오기 
        int loc_seq = mapper.loc_seqSelect(vo.getUser_addr());
        System.out.println(loc_seq);
        // 상품 등록
        String msg = file.getOriginalFilename() + " is saved in server db";
       
        String g_img = path+"\\"+uuid + file.getOriginalFilename();
        vo.setG_img(g_img);
        vo.setLoc_seq(loc_seq);
   
        mapper.goodsInsert(vo);
        

		
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
	
		
    	model.addAttribute("user_addr", vo.getUser_addr());
		model.addAttribute("user_id",vo.getSeller_id() );
		
		return new ModelAndView("redirect:/index.do", model);

	}


	
	
	
}
