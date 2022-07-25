package com.shop.api.service.dto;

import com.shop.api.dao.dto.Notice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NoticeSaveDto {
	private String nb_id;
	private int nb_num;
	private String nb_subject;
	private String nb_content;
	
	public Notice toEntity() {
		return new Notice(this.nb_num, this.nb_id, this.nb_subject, this.nb_content, null);
	}
}
