package com.forus.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.forus.domain.CommunityVO;
import com.forus.domain.gCategoryVO;
import com.forus.domain.goodsListVO;
import com.forus.mapper.CommunityMapper;

@Controller
public class CommnityController {
	
	@Autowired
	CommunityMapper mapper;

	// 게시글 list 
	@RequestMapping("postList.do")
	public List<CommunityVO> postList(HttpServletRequest request, Model model) {
		
		
		// 데이터 호출하기
		String user_addr = request.getParameter("user_addr");
		String user_id = request.getParameter("user_id");
		
		
		//회원 주소에 맞는 아파트에서 상품 리스트 불러오기
		List<CommunityVO> result = mapper.postList(user_addr);
		System.out.println("postList"+result);
		
		return result;
	}
	
	
	// 게시글 등록
	@RequestMapping("/boardInsert.do")
	private String boardInsert(@RequestParam("img2")MultipartFile file, HttpSession session, CommunityVO vo) {
		
		if(session.getAttribute("user_id")!= null){
			// 아이디 가져오기
			String user_id = (String)session.getAttribute("user_id");
			String user_addr = (String)session.getAttribute("user_addr");
		
			
			System.out.println("파일 가져오기 " + file.getOriginalFilename());
			System.out.println(file.getOriginalFilename().length());
			if (!file.getOriginalFilename().equals("")) {
				System.out.println("들어옴");
				// 주소 알기
				String path = session.getServletContext().getRealPath("/file");
				
				// 이미지 저장하기
				String uuid = UUID.randomUUID().toString();
				// file upload to system
				File converFile = new File(path, uuid + file.getOriginalFilename());
				try {
					file.transferTo(converFile);
				} catch (IllegalStateException |IOException e) {
					e.printStackTrace();
				} 
				
				String cFile = uuid + file.getOriginalFilename();
				vo.setArticle_file(cFile);
				}
			
			vo.setUser_id(user_id);
		
			
			
			// V_machine_seq 알아오기
			int machine_seq =mapper.machine_seqSelect(user_addr);
			System.out.println("자판기 번호" + machine_seq);
			vo.setV_machine_seq(machine_seq);
			
			
			System.out.println("vo 값 가져오기 " + vo);
			
			// 게시글 등록 mapper
			mapper.articleInsert(vo);
			
		}
		return "board";
	}
	
	
}
