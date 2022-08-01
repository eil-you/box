package com.forus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ViewController {

	@RequestMapping("/")
	public String main() {
		return "main";
	}
	@RequestMapping("/viewLogin.do")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/viewJoin.do")
	public String viewjoin() {
		return "join";
	}
}