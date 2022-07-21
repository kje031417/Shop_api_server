package com.shop.api.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.api.dao.dto.MemberId;
import com.shop.api.dao.dto.Member;

import com.shop.api.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Repository
@Transactional
@RequiredArgsConstructor
public class DefaultMemberDAO implements MemberDAO {
	
	private final SqlSession sqlSession;
	
	@Override
	public int joinMember(Member member) {
		return sqlSession.getMapper(MemberMapper.class).joinMember(member);
	}
	
	@Override
	public int modifyMember(Member member) {
		return sqlSession.getMapper(MemberMapper.class).modifyMember(member);
	}
	
	@Override
	public int withdrawMember(MemberId memberId) {
		return sqlSession.getMapper(MemberMapper.class).withdrawMember(memberId);
	}
	
	@Override
	public Member selectMember(MemberId memberId) {
		return sqlSession.getMapper(MemberMapper.class).selectMember(memberId);
	}
}
