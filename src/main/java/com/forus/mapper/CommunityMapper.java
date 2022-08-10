package com.forus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.forus.domain.CommunityVO;
import com.forus.domain.commentVO;

@Mapper
public interface CommunityMapper {
	
	
	// postList
	public List<CommunityVO> postList(String user_addr);
	
	// articleInsert
	public int articleInsert(CommunityVO vo);
	

	// v_machine_seq 번호 알아오기
	public int machine_seqSelect(String user_addr);
	
	
	// article_seq 알아오기
	public int art_seqSelect(CommunityVO vo);
	
	
	// 게시글 좋아요 값 insert
	public int likeInsert(commentVO vo);
	
	}
