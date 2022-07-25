package com.shop.api.service.dto;

import com.shop.api.dao.dto.NoticeNum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NoticeRemoveDto {
	private int nb_num;
	
	public NoticeNum toEntity() {
		return new NoticeNum(this.nb_num);
	}
}
