package com.shop.api.dao.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoticeNum {
	private int nb_num;

	public NoticeNum(int nb_num) {
		super();
		this.nb_num = nb_num;
	}
}
