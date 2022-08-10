package com.forus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunityVO {
	private int article_seq;
	private String article_content;
	private String article_date;
	private String article_file;
	private String user_id;
	private String c_category_seq;
	private int v_machine_seq;
	private int c_like;
	
}
