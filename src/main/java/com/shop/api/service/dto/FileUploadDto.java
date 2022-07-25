package com.shop.api.service.dto;

import com.shop.api.dao.dto.Attach;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FileUploadDto {
	private String board_type;
	private int board_id;
	private String file_name;
	private String saved_file_name;
	private long file_size;
	
	public Attach toEntity() {
		return new Attach(
				this.board_type, this.board_id, 0, 
				this.file_name, this.saved_file_name, this.file_size);
	}
}
