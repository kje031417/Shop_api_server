package com.shop.api.controller.dto;

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
		
		public static NoticeAssignData create(Notice notice) {
			return new NoticeAssignData(notice.getNb_num(), notice.getNb_id(), 
					notice.getNb_subject(), notice.getNb_content(), notice.getNb_createdat());
		}
	}
}
