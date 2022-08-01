package com.forus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forus.domain.UserInfoVO;
import com.forus.mapper.UserMapper;
import com.mysql.cj.Session;

import lombok.RequiredArgsConstructor;



@Controller
public class UserController {
	
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
		
		
	@Autowired // self service
	UserMapper mapper;
	
	
	
	@RequestMapping("/viewLogin.do")
	public String login() {
		return "login";
	}

	@RequestMapping("/Login.do")
	public String userLogin(UserInfoVO vo, HttpSession session) {
		System.out.println(vo);
		UserInfoVO result = mapper.login(vo);
		System.out.println(result);
		
		
		
		if(result==null) {
			return "login";
		}else {
			session.setAttribute("user", result);
			return "redirect:/index.do";
		}
	}
	
	
	
	
	
	
	
}

