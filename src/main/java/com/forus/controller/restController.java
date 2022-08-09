package com.forus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.forus.domain.goodsListVO;
import com.forus.mapper.GoodsMapper;
import com.forus.mapper.UserMapper;

@RestController
public class restController {

	@Autowired // self service
	UserMapper mapper;
	
	@Autowired
	GoodsMapper gmapper;

	// 아이디 중복 확인 
	@RequestMapping("/CheckId.do")
	public @ResponseBody String checkId(String user_id) {
		String result = mapper.checkId(user_id);
		
		System.out.println(result);

		return result;
	}
	
	// 제품 판매 완료 내역
	@RequestMapping("goodsFinishList.do")
	public List<goodsListVO> goodsFinishList(String user_id, Model model){
		List<goodsListVO> list =gmapper.goodsFinishList(user_id);
		model.addAttribute("GoodsList", list); 
		return list;
	}
	
	// 제품 판매중 내역
	@RequestMapping("goodsSale.do")
	public List<goodsListVO> goodsSaleList(String user_id, Model model) {
		List<goodsListVO> list =gmapper.goodsSaleList(user_id);
		model.addAttribute("GoodsList", list); 
		return list;
	}
	
	
	
	// 상품 카테고리 
	
	


}
