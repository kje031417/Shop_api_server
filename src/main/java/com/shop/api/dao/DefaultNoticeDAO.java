package com.shop.api.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.api.dao.dto.Notice;
import com.shop.api.dao.dto.NoticeNum;
import com.shop.api.mapper.NoticeMapper;

import lombok.RequiredArgsConstructor;

@Repository
@Transactional
@RequiredArgsConstructor
public class DefaultNoticeDAO implements NoticeDAO {
	
	private final SqlSession sqlSession;
	
	@Override
	public int saveNotice(Notice notice) {
		return sqlSession.getMapper(NoticeMapper.class).saveNotice(notice);
	}

	@Override
	public Notice selectNotice(NoticeNum noticeNum) {
		return sqlSession.getMapper(NoticeMapper.class).selectNotice(noticeNum);
	}
	
	@Override
	public int deleteNotice(NoticeNum noticeNum) {
		return sqlSession.getMapper(NoticeMapper.class).deleteNotice(noticeNum);
	}
}
