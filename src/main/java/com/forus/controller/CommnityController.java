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
import com.forus.domain.commentVO;
import com.forus.domain.gCategoryVO;
import com.forus.domain.goodsListVO;
import com.forus.mapper.CommunityMapper;
import com.forus.mapper.ViewMapper;

@Controller
public class CommnityController {
	
	@Autowired
	CommunityMapper mapper;

	
	@Autowired
	ViewMapper vMapper;
	
	// 게시글 list 
	@RequestMapping("/postList.do")
	public String postList(HttpSession session, Model model) {
		
		
		// 데이터 user_addr  값 가져오기
		String user_addr = (String) session.getAttribute("user_addr");
		if(user_addr!= null) {
		
		//회원 주소에 맞는 아파트에서 상품 리스트 불러오기
		List<CommunityVO> result = mapper.postList(user_addr);
		System.out.println("postList"+result);
		
		// 게시글 카테고리 뿌려주기
		model.addAttribute("boardList", result);
		return "board";
		}else {
			return "notPage";
		}
	}
	
	@RequestMapping("/myBoardList.do")
	public String mypostList(HttpSession session, Model model) {
		
		
		System.out.println("호롤롤로");
		// 데이터 user_addr  값 가져오기
		String user_addr = (String) session.getAttribute("user_addr");
		if(user_addr!=null) {
		
		//회원 주소에 맞는 아파트에서 게시글 리스트 불러오기
		List<CommunityVO> result = mapper.postList(user_addr);
		System.out.println("postList"+result);
		
		model.addAttribute("boardList", result);
		
		return "myBoardList";
		}else {
			return "notPage";
		}
	}
	
	
	
	// 게시글 등록
	@RequestMapping("/boardInsert.do")
	private String boardInsert(@RequestParam("img2")MultipartFile file, HttpSession session, CommunityVO vo) {
		
		if(session.getAttribute("user_id")!= null){
			// 아이디 가져오기
			String user_id = (String)session.getAttribute("user_id");
			String user_addr = (String)session.getAttribute("user_addr");
		
			System.out.println("article_category"+vo.getArticle_category());
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
			
		
			
			
			// V_machine_seq 알아오기
			int machine_seq =mapper.machine_seqSelect(user_addr);
			System.out.println("자판기 번호" + machine_seq);
			vo.setV_machine_seq(machine_seq);
			vo.setUser_id(user_id);
			System.out.println("user_id 넣은 후 vo : " +vo);
			
			System.out.println("vo 값 가져오기 " + vo);
			
			// 게시글 등록 mapper
			mapper.articleInsert(vo);
			
			// 게시글 좋아요  값 insert 해주기
			// 1) article_seq 번호 가져오기 
			int article_seq = mapper.art_seqSelect(vo);
			System.out.println("article_seq : " + article_seq);
			
			// 2) 게시글 좋아요 값 insert 해주기
			commentVO cVO = new commentVO();
			cVO.setArticle_seq(article_seq);
			cVO.setUser_id(user_id);
			cVO.setC_like(0);
			System.out.println("게시글 좋아요 하기 위한 cVO : " +cVO);
			int row = mapper.likeInsert(cVO);
			System.out.println("게시글 좋아요 기본 값 결과 출력 : "  + row );
			
			
		}
		return "redirect:/postList.do";
	}
	
	
}
