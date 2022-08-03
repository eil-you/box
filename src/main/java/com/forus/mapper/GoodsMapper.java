package com.forus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.forus.domain.goodsListVO;
import com.forus.domain.goodsVO;

@Mapper
public interface GoodsMapper {

	
	// goodsList
	public List<goodsListVO> goodsList(String user_add);

	
	// 아파트 이름 가져오기
	public String selectAptName(String user_add);
	
	
	// goodsInfo
	public goodsVO goodsInfo(int g_seq);
	
	
	
}
