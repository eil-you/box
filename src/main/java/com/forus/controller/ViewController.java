package com.forus.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.forus.domain.goodsVO;
import com.forus.domain.gCategoryVO;
import com.forus.mapper.ViewMapper;

@Controller
public class ViewController {
	
	@Autowired
	ViewMapper mapper;
	
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

	// 상품등록 click -> 카테고리 데이터 가져오기
	@RequestMapping("/viewGoodsForm.do")
	public String viewGoodsForm(Model model) {
		System.out.println("상품 등록 리스트 불러오기");
		List<gCategoryVO> result=mapper.goodsCategory();
		System.out.println("결과 "+result);
		model.addAttribute("categoryList", result);
		
		return "goodsForm";

	}
	
	@RequestMapping("viewGoodsContent.do")
	public void viewGoodsContent(int g_seq) {
		
		System.out.println(g_seq);
		
	}

	@RequestMapping("viewMypage.do")
	public String viewMypage(Model model,HttpServletRequest request) {
		
		return "mypage";
		
	}
	
	@RequestMapping("viewBuyPage.do")
	public String viewBuyPage(){
		
		return "buyPage";
	}
	
}
