package com.forus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.forus.domain.gCategoryVO;

@Mapper
public interface ViewMapper {
	public List<gCategoryVO> goodsCategory();
}
