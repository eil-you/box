package com.forus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.forus.domain.userInfoVO;
import com.forus.mapper.UserMapper;
import com.mysql.cj.Session;

import lombok.RequiredArgsConstructor;



@Controller
public class UserController {
		
	@Autowired // self service
	UserMapper mapper;
	
	


	@RequestMapping("/Login.do")
	public ModelAndView userLogin(userInfoVO vo, ModelMap model) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if (mapper.login(vo) != null) {
		userInfoVO result = mapper.login(vo);
		
		// 암호키를 복호화 함 
		encoder.matches(vo.getUser_pw(), result.getUser_pw());
		
			if(encoder.matches(vo.getUser_pw(), result.getUser_pw())) {
				model.addAttribute("user",result);
				return new ModelAndView("redirect:/index.do", model);
			}
		}else {
			return new ModelAndView("redirect:/viewLogin.do");
		}
		return new ModelAndView("redirect:/viewLogin.do");
	}
	
	@RequestMapping("/Join.do")
	public String userJoin(userInfoVO vo) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String securePassword = encoder.encode(vo.getUser_pw());
		vo.setUser_pw(securePassword);
		mapper.join(vo);
		
		return "login";
	}
	

	
	
	
	
	
}

