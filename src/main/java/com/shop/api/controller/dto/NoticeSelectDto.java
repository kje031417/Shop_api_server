package com.shop.api.controller.dto;

import com.shop.api.dao.dto.Notice;
import com.shop.api.service.dto.NoticeListDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class NoticeSelectDto {
	
	@Getter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	public static class NoticeSelectRequest {
		private int nb_num;
		
		public NoticeListDto toDto() {
			return new NoticeListDto(this.nb_num);
		}
	}
	
	@Getter
	@AllArgsConstructor
	public static class NoticeSelectResponse {
		private NoticeSelectData notice;
	}
	
	@Getter
	@AllArgsConstructor
	public static class NoticeSelectData {
		private int nb_num;
		private String nb_id;
		private String nb_subject;
		private String nb_content;
		private String nb_createdat;
		
		public static NoticeSelectData create(Notice notice) {
			return new NoticeSelectData(notice.getNb_num(), notice.getNb_id(), 
					notice.getNb_subject(), notice.getNb_content(), notice.getNb_createdat());
		}
	}
}
