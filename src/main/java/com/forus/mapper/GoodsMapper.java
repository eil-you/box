package com.forus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.forus.domain.gLocationVO;
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
	
	// goodsInsert
	public void goodsInsert(goodsVO vo);
	
	
	// g_seq 불러오기
	public int loc_seqSelect(String user_addr);
		
	

	// v_machine_pw 비밀번호 update
	public int machinePwUpdate(gLocationVO gvo);
	
	
	
	// 물건 파는 사람의 nickname 불러오기
	public String seller_nickSelect(String seller_id); 
	
}	
	

