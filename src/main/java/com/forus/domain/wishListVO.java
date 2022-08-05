package com.forus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class wishListVO {
	
	private int g_seq;
	private String user_id;
	private int wish_yn;
	
}
