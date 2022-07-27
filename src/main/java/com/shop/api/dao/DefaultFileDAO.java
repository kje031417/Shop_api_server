package com.shop.api.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.api.dao.dto.Attach;
import com.shop.api.dao.dto.NoticeNum;
import com.shop.api.mapper.FileMapper;

import lombok.RequiredArgsConstructor;

@Repository
@Transactional
@RequiredArgsConstructor
public class DefaultFileDAO implements FileDAO {
	
	private final SqlSession sqlSession;
	
	@Override
	public int insertFile(Attach attach) {
		return sqlSession.getMapper(FileMapper.class).insertFile(attach);
	}
	
	@Override
	public Attach selectFile(NoticeNum noticeNum) {
		return sqlSession.getMapper(FileMapper.class).selectFile(noticeNum);
	}
	
	@Override
	public int editFile(Attach attach) {
		return sqlSession.getMapper(FileMapper.class).editFile(attach);
	}
	
	@Override
	public int deleteFile(NoticeNum noticeNum) {
		return sqlSession.getMapper(FileMapper.class).deleteFile(noticeNum);
	}
}
