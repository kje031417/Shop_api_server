package com.shop.api.controller.dto;

import com.shop.api.service.dto.NoticeRemoveDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class NoticeDeleteDto {
	
	@Getter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	public static class NoticeDeleteRequest {
		private int nb_num;
		
		public NoticeRemoveDto toDto() {
			return new NoticeRemoveDto(this.nb_num);
		}
	}
	
}
