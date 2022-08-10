package com.forus.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.forus.domain.gCategoryVO;
import com.forus.domain.wishListVO;

@Mapper
public interface ViewMapper {
	

	public List<gCategoryVO> goodsCategory();
	
	
	public int wishUpdate(wishListVO vo);
	
	
	public int wishCheck(wishListVO vo);	
	
	
	
}
