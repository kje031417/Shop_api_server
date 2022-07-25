package com.shop.api.service;

import com.shop.api.dao.dto.Notice;
import com.shop.api.service.dto.NoticeListDto;
import com.shop.api.service.dto.NoticeRemoveDto;
import com.shop.api.service.dto.NoticeSaveDto;

public interface NoticeService {
	Notice saveNotice(NoticeSaveDto noticeSaveDto);
	Notice selectNotice(NoticeListDto noticeListDto);
	String deleteNotice(NoticeRemoveDto noticeRemoveDto);
}
