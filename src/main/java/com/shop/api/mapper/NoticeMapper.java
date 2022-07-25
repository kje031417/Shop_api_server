package com.shop.api.mapper;

import com.shop.api.dao.dto.Notice;
import com.shop.api.dao.dto.NoticeNum;

public interface NoticeMapper {
	int saveNotice(Notice notice);
	Notice selectNotice(NoticeNum noticeNum);
	int deleteNotice(NoticeNum noticeNum);
}
