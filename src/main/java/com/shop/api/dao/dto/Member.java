package com.shop.api.dao.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
	private String mi_id;
	private String mi_pw;
	private String mi_name;
	private String mi_email;
	private String mi_mobile;
	private String mi_tell;
	private String mi_postcode;
	private String mi_address;
	private String mi_detailaddress;
	private String mi_createdat;
		
	public Member(String mi_id, String mi_pw, String mi_name, String mi_email, String mi_mobile, String mi_tell,
			String mi_postcode, String mi_address, String mi_detailaddress, String mi_createdat) {
		super();
		this.mi_id = mi_id;
		this.mi_pw = mi_pw;
		this.mi_name = mi_name;
		this.mi_email = mi_email;
		this.mi_mobile = mi_mobile;
		this.mi_tell = mi_tell;
		this.mi_postcode = mi_postcode;
		this.mi_address = mi_address;
		this.mi_detailaddress = mi_detailaddress;
		this.mi_createdat = mi_createdat;
	}
}
