package com.forus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.forus.domain.GoodsListVO;

@Mapper
public interface GoodsMapper {

	
	// goodsList
	public List<GoodsListVO> goodsList(String user_add);

	
	// 아파트 이름 가져오기
	public String selectAptName(String user_add);
	
	
	
	
	
}
