package com.forus.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.forus.domain.chatRoomVO;

@Mapper
public interface ChatMapper {
	
	// 채팅방 데이터 삽입
	public int addChatRoom(String user_id, int g_seq);
	
	// 채팅방 정보 가져오기
	public chatRoomVO cr_seqSelect(String user_id, int g_seq);
	

}
