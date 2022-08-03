package com.forus.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.hql.internal.ast.tree.SessionFactoryAwareNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

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
		System.out.println(session.getAttribute("user_addr"));
		
	}
	
	
	// 상품 한개 상세 정보 불러오기
	@RequestMapping("/goodsInfo.do")
	public String goodsInfo(int g_seq, String apt_name, HttpServletRequest request) {
		goodsVO result =mapper.goodsInfo(g_seq);
		System.out.println(result);
		request.setAttribute("goodsInfo", result);
		request.setAttribute("apt_name", apt_name);
		
		return "goodsInfo";
	}
	
	
	// 상품 등록
	@RequestMapping("goodsInsert.do")
	public String goodsInsert(@RequestParam("g_img") MultipartFile file, HttpSession session, goodsVO vo) {

		String path = session.getServletContext().getRealPath("/file");

		System.out.println("경로 : " + path);
		vo.setG_img(path);
		

		// 이미지 저장하기
        String uuid = UUID.randomUUID().toString();
        // file upload to system
        File converFile = new File(path, uuid + file.getOriginalFilename());
        try {
			file.transferTo(converFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

        String msg = file.getOriginalFilename() + " is saved in server db";
        System.out.println(msg);
		
		return "index";

	}


	
	
	
}
