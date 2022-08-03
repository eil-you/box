package com.forus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.forus.mapper.UserMapper;

@RestController
public class restController {

	@Autowired // self service
	UserMapper mapper;

	// 아이디 중복 확인 
	@RequestMapping("/CheckId.do")
	public @ResponseBody String checkId(String user_id) {
		String result = mapper.checkId(user_id);
		
		System.out.println(result);

		return result;
	}
	
	
	// 상품 카테고리 
	
	


}
