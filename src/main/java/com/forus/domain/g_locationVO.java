package com.forus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class g_locationVO {
	private String g_name;
	private String apt_name;
	private int v_machine_space_no;
	private int v_machine_pw;
	private String status;
}
