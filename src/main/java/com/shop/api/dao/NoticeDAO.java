package com.shop.api.dao;

import com.shop.api.dao.dto.Notice;
import com.shop.api.dao.dto.NoticeNum;

public interface NoticeDAO {
	int saveNoticE(Notice notice);
	Notice selectNotice(NoticeNum noticeNum);
	int deleteNotice(NoticeNum noticeNum);
}
