package com.shop.api.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultFileDAO implements FileDAO {
	
	private SqlSession sqlSession;
	
	@Override
	public int insertFile() {
		// TODO Auto-generated method stub
		return 0;
	}
}
