package com.shop.api.controller.dto;

import com.shop.api.dao.dto.Attach;
import com.shop.api.service.dto.FileUploadDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class FileInsertDto {
	
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	@ToString
	public static class FileInsertRequest {
		private String board_type;
		private int board_id;
		private String file_name;
		private String saved_file_name;
		private long file_size;
		
		public FileUploadDto toDto() {
			return new FileUploadDto(
					this.board_type, this.board_id, this.file_name, 
					this.saved_file_name, this.file_size);
		}
	}
	
	@Getter
	@AllArgsConstructor
	public static class FileInsertResponse {
		private FileInsertData file;
	}
	
	@Getter
	@AllArgsConstructor
	public static class FileInsertData {
		private String board_type;
		private int board_id;
		private int file_num;
		private String file_name;
		private String saved_file_name;
		private long file_size;
		
		public static FileInsertData create(Attach attach) {
			return new FileInsertData(
					attach.getBoard_type(), attach.getBoard_id(), attach.getFile_num(),
					attach.getFile_name(), attach.getSaved_file_name(), attach.getFile_size());
		}
	}
}
