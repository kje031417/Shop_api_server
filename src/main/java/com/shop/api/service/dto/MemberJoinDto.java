package com.shop.api.service.dto;

import com.shop.api.dao.dto.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberJoinDto {
	private String mi_id;
	private String mi_pw;
	private String mi_name;
	private String mi_email;
	private String mi_mobile;
	private String mi_tell;
	private String mi_postcode;
	private String mi_address;
	private String mi_detailaddress;
	
	public Member toEntity() {
		return new Member(this.mi_id, this.mi_pw, this.mi_name, this.mi_email, this.mi_mobile, this.mi_tell, this.mi_postcode, this.mi_address, this.mi_detailaddress, this.mi_address);
	}
}
