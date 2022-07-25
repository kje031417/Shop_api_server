package com.shop.api.dao.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class Notice {
	private int nb_num;
	private String nb_id;
	private String nb_subject;
	private String nb_content;
	private String nb_createdat;
	
	public Notice(int nb_num, String nb_id, String nb_subject, String nb_content, String nb_createdat) {
		super();
		this.nb_num = nb_num;
		this.nb_id = nb_id;
		this.nb_subject = nb_subject;
		this.nb_content = nb_content;
		this.nb_createdat = nb_createdat;
	}

}
