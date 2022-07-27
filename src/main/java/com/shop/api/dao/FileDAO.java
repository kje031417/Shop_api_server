package com.shop.api.dao;

import com.shop.api.dao.dto.Attach;
import com.shop.api.dao.dto.NoticeNum;

public interface FileDAO {
	int insertFile(Attach attach);
	Attach selectFile(NoticeNum noticeNum);
	int editFile(Attach attach);
	int deleteFile(NoticeNum noticeNum);
}
