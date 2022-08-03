package com.forus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class goodsListVO {
	private int g_seq;
	private String g_name;
	private String g_img;
	private int g_price;
}
