package com.shop.api.controller.dto;

import com.shop.api.service.dto.MemberWithdrawDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class MemberDeleteDto {
	
	@Getter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	public static class MemberDeleteRequest {
		private String mi_id;
		
		public MemberWithdrawDto toDto() {
			return new MemberWithdrawDto(this.mi_id);
		}
	}
}
