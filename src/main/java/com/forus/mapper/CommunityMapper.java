package com.forus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.forus.domain.CommunityVO;

@Mapper
public interface CommunityMapper {
	
	
	// postList
	public List<CommunityVO> postList(String user_addr);
	
	
	


	}
