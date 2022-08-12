//package com.forus.controller;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.forus.domain.Room;
//import com.forus.domain.goodsVO;
//import com.forus.mapper.GoodsMapper;
//
//@Controller
//public class chatController {
//	
//	List<Room> roomList = new ArrayList<Room>();
//	static int roomNumber = 0;
//	
//	@Autowired
//	GoodsMapper gMapper;
//	
//	
//	@RequestMapping("/chat")
//	public ModelAndView chat() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("chat");
//		return mv;
//	}
//	
//	/**
//	 * 방 페이지
//	 * @return
//	 */
//	@RequestMapping("/room")
//	public ModelAndView room() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("room");
//		return mv;
//	}
//	
//	/**
//	 * 방 생성하기
//	 * @param params
//	 * @return
//	 */
//	// g_seq 번호 가져오기
//	@RequestMapping("/createRoom")
//	public @ResponseBody List<Room> createRoom(@RequestParam HashMap<Object, Object> params, HttpSession session){
//		//String roomName = (String) params.get("roomName");
//		String user_id = (String)session.getAttribute("user_id");
//		int g_seq = (int) params.get("g_seq");
//		// g_seq 값으로 제품 이미지/ 아이디 가져오기(파는 사람 user_nick 가져오기)/ 제품 이름가져오기
//		//goodsVO gVO =gMapper.goodsRoom(g_seq);
//		//String g_name = gVO.getG_name();
//		
//		
//		//if(roomName != null && !roomName.trim().equals("")) {
//		if(g_seq > 0) {
//			Room room = new Room();
//			room.setRoomNumber(++roomNumber);
//			room.setRoomName(roomName);
//			roomList.add(room);
//		}
//		return roomList;
//	}
//	
//	/**
//	 * 방 정보가져오기 
//	 * @param params
//	 * @return
//	 */
//	@RequestMapping("/getRoom")
//	public @ResponseBody List<Room> getRoom(@RequestParam HashMap<Object, Object> params){
//		return roomList;
//	}
//	
//	/**
//	 * 채팅방
//	 * @return
//	 */
//	@RequestMapping("/moveChating")
//	public ModelAndView chating(@RequestParam HashMap<Object, Object> params) {
//		ModelAndView mv = new ModelAndView();
//		int roomNumber = Integer.parseInt((String) params.get("roomNumber"));
//		
//		List<Room> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
//		if(new_list != null && new_list.size() > 0) {
//			mv.addObject("roomName", params.get("roomName"));
//			mv.addObject("roomNumber", params.get("roomNumber"));
//			mv.setViewName("chat");
//		}else {
//			mv.setViewName("room");
//		}
//		return mv;
//	}
//}