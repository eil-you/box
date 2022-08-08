package com.forus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommunityVO {
	private int article_seq;
	private String article_title;
	private String article_content;
	private String article_date;
	private String article_file;
	private String user_nick;
	private String c_category_name;
	private String apt_name;
}
