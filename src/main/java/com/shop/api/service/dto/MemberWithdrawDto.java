package com.shop.api.service.dto;

import com.shop.api.dao.dto.MemberId;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberWithdrawDto {
	private String mi_id;
	
	public MemberId toEntity() {
		return new MemberId(this.mi_id);
	}
}
