package com.forus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
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
	public void index(UserInfoVO vo, HttpServletRequest request) {		
		// 회원 주소에 맞는 아파트에서 상품 리스트 불러오기
		List<GoodsListVO> result = mapper.goodsList(vo.getUser_addr());
		// 회원 주소 아파트 이름 가져오기
		String apt_name = mapper.selectAptName(vo.getUser_addr());
		// 제품 리스트 보내기
		request.setAttribute("GoodsList", result);
		// 아파트 보내주기
		request.setAttribute("apt_name",apt_name);

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


	
	
	
	
	
}
