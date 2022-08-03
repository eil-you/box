package com.forus.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.forus.domain.GoodsVO;

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

	@RequestMapping("/viewGoodsForm.do")
	public String viewGoodsForm() {

		return "goodsForm";

	}

	@RequestMapping("goodsInsert.do")
	public String goodsInsert(@RequestParam("g_img") MultipartFile file, HttpSession session, GoodsVO vo) {

		String path = session.getServletContext().getRealPath("/file");

		System.out.println("경로 : " + path);

		// int maxSize = 10 * 1024 * 1024;
		// String encoding = "UTF-8";

		//DefaultFileRenamePolicy rename = new DefaultFileRenamePolicy();
		//MultipartRequest multi = new MultipartRequest(request, path, maxSize, encoding, rename);
		
		// 이미지 저장하기
        String uuid = UUID.randomUUID().toString();
        // file upload to system
        File converFile = new File(path, uuid + file.getOriginalFilename());
        try {
			file.transferTo(converFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

        String msg = file.getOriginalFilename() + " is saved in server db";
        System.out.println(msg);
		
		return "index";

	}

}
