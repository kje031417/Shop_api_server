package com.shop.api.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.shop.api.controller.dto.NoticeAssignDto.NoticeAssignData;
import com.shop.api.dao.dto.Notice;
import com.shop.api.service.dto.NoticeListDto;
import com.shop.api.service.dto.NoticeRemoveDto;
import com.shop.api.service.dto.NoticeSaveDto;

public interface NoticeService {
	NoticeAssignData saveNotice(NoticeSaveDto noticeSaveDto, MultipartHttpServletRequest mr);
	Notice selectNotice(NoticeListDto noticeListDto);
	String deleteNotice(NoticeRemoveDto noticeRemoveDto, HttpServletRequest httpServletRequest);
}
