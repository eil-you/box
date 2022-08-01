package com.forus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.forus.domain.UserInfoVO;

@Mapper
public interface UserInfoMapper {

	
		
		
	
	// login
	public UserInfoVO login(UserInfoVO vo);
	
		
		
		
}
