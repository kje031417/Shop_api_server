package com.shop.api.mapper;

import com.shop.api.dao.dto.Attach;
import com.shop.api.dao.dto.NoticeNum;

public interface FileMapper {
	int insertFile(Attach attach);
	Attach selectFile(NoticeNum noticeNum);
	int editFile(Attach attach);
	int deleteFile(NoticeNum noticeNum);
}
