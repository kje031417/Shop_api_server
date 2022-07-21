package com.shop.api.dao.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberId {
	private String mi_id;

	public MemberId(String mi_id) {
		super();
		this.mi_id = mi_id;
	}
}
