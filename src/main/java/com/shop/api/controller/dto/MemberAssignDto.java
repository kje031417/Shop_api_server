package com.shop.api.controller.dto;

import com.shop.api.dao.dto.Member;
import com.shop.api.service.dto.MemberSaveDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class MemberAssignDto {
	
	@Getter
	@ToString
	@NoArgsConstructor
	@AllArgsConstructor
	public static class MemberAssignRequest {
		private String mi_id;
		private String mi_pw;
		private String mi_name;
		private String mi_email;
		private String mi_mobile;
		private String mi_tell;
		private String mi_postcode;
		private String mi_address;
		private String mi_detailaddress;
		
		public MemberSaveDto toDto() {
			return new MemberSaveDto(this.mi_id, this.mi_pw, this.mi_name, 
					this.mi_email, this.mi_mobile, this.mi_tell, 
					this.mi_postcode, this.mi_address, this.mi_detailaddress);
		}
	}
	
	@Getter
	@AllArgsConstructor
	public static class MemberAssignResponse {
		private MemberAssignData member;
	}
	
	@Getter
	@AllArgsConstructor
	public static class MemberAssignData {
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
		
		public static MemberAssignData create(Member member) {
			return new MemberAssignData(
					member.getMi_id(), member.getMi_pw(), member.getMi_name(), member.getMi_email(), 
					member.getMi_mobile(), member.getMi_detailaddress(), member.getMi_tell(), member.getMi_postcode(), 
					member.getMi_address(), member.getMi_createdat()
				);
		}
	}
}
