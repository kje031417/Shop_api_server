package com.shop.api.dao.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class Attach {
	private String board_type;
	private int board_id;
	private int file_num;
	private String file_name;
	private String saved_file_name;
	private long file_size;
	
	public Attach(String board_type, int board_id, int file_num, String file_name, String saved_file_name,
			long file_size) {
		super();
		this.board_type = board_type;
		this.board_id = board_id;
		this.file_num = file_num;
		this.file_name = file_name;
		this.saved_file_name = saved_file_name;
		this.file_size = file_size;
	}
}
