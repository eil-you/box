package com.forus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.forus.domain.UserInfoVO;
import com.forus.mapper.UserMapper;
import com.mysql.cj.Session;

import lombok.RequiredArgsConstructor;



@Controller
public class UserController {
	
	
	
	
	
		
		
	@Autowired // self service
	UserMapper mapper;
	
	


	@RequestMapping("/Login.do")
	public String userLogin(UserInfoVO vo, HttpSession session) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		UserInfoVO result = mapper.login(vo);
		System.out.println(result);
		
		// 암호키를 복호화 함 
		encoder.matches(vo.getUser_pw(), result.getUser_pw());
		
		if(encoder.matches(vo.getUser_pw(), result.getUser_pw())) {
			session.setAttribute("user", result);
			return "redirect:/index.do";
		}else {
			return "login";
		}
	
	}
	
	@RequestMapping("/Join.do")
	public String userJoin(UserInfoVO vo) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String securePassword = encoder.encode(vo.getUser_pw());
		vo.setUser_pw(securePassword);
		mapper.join(vo);
		
		return "login";
	}
	
	// 중복 아이디 확인
	@ResponseBody
	@RequestMapping("/CheckId.do")
	public String checkId(String user_id) {
		String result = mapper.checkId(user_id);
		
		return result;
	}
	
	
	
	
	
	
}

