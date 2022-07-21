package com.shop.api.controller.dto;

import com.shop.api.dao.dto.Member;
import com.shop.api.service.dto.MemberListDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class MemberSelectDto {
	
	@Getter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	public static class MemberSelectRequest {
		private String mi_id;
		
		public MemberListDto toDto() {
			return new MemberListDto(this.mi_id);
		}
	}
	
	@Getter
	@AllArgsConstructor
	public static class MemberSelectResponse {
		private MemberSelectData member;
	}
	
	@Getter
	@AllArgsConstructor
	public static class MemberSelectData {
		private String mi_id;
		private String mi_pw;
		private String mi_name;
		private String mi_email;
		private String mi_mobile;
		private String mi_detailaddress;
		private String mi_tell;
		private String mi_postcode;
		private String mi_address;
		private String mi_createdat;
		
		public static MemberSelectData create(Member member) {
			return new MemberSelectData(
					member.getMi_id(), member.getMi_pw(), member.getMi_name(), member.getMi_email(), 
					member.getMi_mobile(), member.getMi_detailaddress(), member.getMi_tell(), member.getMi_postcode(), 
					member.getMi_address(), member.getMi_createdat());
		}
	}
}
