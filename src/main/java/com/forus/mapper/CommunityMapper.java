package com.forus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.forus.domain.CommunityVO;

@Mapper
public interface CommunityMapper {
	
	
	// postList
	public List<CommunityVO> postList(String user_addr);
	
	// articleInsert
	public int articleInsert(CommunityVO vo);
	

	// v_machine_seq 번호 알아오기
	public int machine_seqSelect(String user_addr);

	}
