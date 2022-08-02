package com.forus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class GoodsVO {
	private int g_seq;
	private int gc_seq;
	private String g_name;
	private String g_info;
	private String g_img;
	private int g_price;
	private String seller_id;
	

}
