package com.forus.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class g_locationVO {
	@NonNull
	private String g_name;
	@NonNull
	private String apt_name;
	@NonNull
	private int v_machine_space_no;
	@NonNull
	private int v_machine_pw;
	private String status;
}
