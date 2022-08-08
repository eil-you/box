package com.forus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forus.domain.CommunityVO;
import com.forus.domain.gCategoryVO;
import com.forus.domain.goodsListVO;
import com.forus.mapper.CommunityMapper;

@Controller
public class CommnityController {
	
	@Autowired
	CommunityMapper mapper;

	@RequestMapping("postList,do")
	public List<CommunityVO> postList(HttpServletRequest request, Model model) {
		
		
		// 데이터 호출하기
		String user_addr = request.getParameter("user_addr");
		String user_id = request.getParameter("user_id");
		
		
		//회원 주소에 맞는 아파트에서 상품 리스트 불러오기
		List<CommunityVO> result = mapper.postList(user_addr);
		System.out.println("postList"+result);
		
		return result;
	}
	
	
	
	
}
