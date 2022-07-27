package com.shop.api.controller.dto;

import com.shop.api.dao.dto.Attach;
import com.shop.api.dao.dto.Notice;
import com.shop.api.service.dto.NoticeSaveDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class NoticeAssignDto {
	
	@Getter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	public static class NoticeAssignRequest {
		private String nb_id;
		private int nb_num;
		private String nb_subject;
		private String nb_content;
		
		public NoticeSaveDto toDto() {
			return new NoticeSaveDto(this.nb_id, this.nb_num, this.nb_subject, this.nb_content);
		}
	}
	
	@Getter
	@AllArgsConstructor
	public static class NoticeAssignResponse {
		private NoticeAssignData notice;
	}
	
	@Getter
	@AllArgsConstructor
	public static class NoticeAssignData {
		private int nb_num;
		private String nb_id;
		private String nb_subject;
		private String nb_content;
		private String nb_createdat;
		private String board_type;
		private int board_id;
		private int file_num;
		private String file_name;
		private String saved_file_name;
		private long file_size;
		
		public static NoticeAssignData create(Notice notice, Attach attach) {
			return new NoticeAssignData(notice.getNb_num(), notice.getNb_id(), 
					notice.getNb_subject(), notice.getNb_content(), notice.getNb_createdat(),
					attach.getBoard_type(), attach.getBoard_id(), attach.getFile_num(),
					attach.getFile_name(), attach.getSaved_file_name(), attach.getFile_size());
		}
	}
}
