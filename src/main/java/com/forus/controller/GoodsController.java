package com.forus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.hql.internal.ast.tree.SessionFactoryAwareNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forus.domain.GoodsListVO;
import com.forus.domain.GoodsVO;
import com.forus.domain.UserInfoVO;
import com.forus.mapper.GoodsMapper;

@Controller
public class GoodsController {
	
	
	@Autowired
	GoodsMapper mapper;
	
	// 상품 리스트 불러오기
	@RequestMapping("/index.do")
	public void index(Model model ,HttpServletRequest request) {
		// 회원 주소에 맞는 아파트에서 상품 리스트 불러오기
		String user_addr = request.getParameter("user_addr");
		System.out.println(user_addr);
		String user_id = request.getParameter("user_id");
		System.out.println(user_id);
		List<GoodsListVO> result = mapper.goodsList(user_addr);
		System.out.println("list"+result);
		// 회원 주소 아파트 이름 가져오기
		String apt_name = mapper.selectAptName(user_addr);
		System.out.println("apt_name"+apt_name);
		// 제품 리스트 보내기
		model.addAttribute("GoodsList", result);
		// 아파트 보내주기
		model.addAttribute("apt_name",apt_name);
		
	}
	
	
	// 상품 한개 상세 정보 불러오기
	@RequestMapping("/goodsInfo.do")
	public String goodsInfo(int g_seq, String apt_name, HttpServletRequest request) {
		GoodsVO result =mapper.goodsInfo(g_seq);
		System.out.println(result);
		request.setAttribute("goodsInfo", result);
		request.setAttribute("apt_name", apt_name);
		
		return "goodsInfo";
	}
	
	// 상품 등록
	@RequestMapping("gInsert.do")
	public String gInsert(){
		
		
		
		
		return "redirect:/index.do";
	}


	
	
	
}
