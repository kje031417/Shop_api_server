package com.shop.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.api.dao.MemberDAO;
import com.shop.api.dao.dto.Member;
import com.shop.api.service.dto.MemberWithdrawDto;
import com.shop.api.service.dto.MemberJoinDto;
import com.shop.api.service.dto.MemberListDto;
import com.shop.api.service.dto.MemberModifyDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultMemberService implements MemberService {

	private final MemberDAO memberDAO;
	
	@Override
	public Member joinMember(MemberJoinDto memberJoinDto) {
		Member member = memberJoinDto.toEntity();
		memberDAO.joinMember(member);
		return member;
	}
	
	@Override
	public Member modifyMember(MemberModifyDto memberModifyDto) {
		Member member = memberModifyDto.toEntity();
		memberDAO.modifyMember(member);
		return member;
	}
	
	@Override
	public String withdrawMember(MemberWithdrawDto memberWithdrawDto) {
		memberDAO.withdrawMember(memberWithdrawDto.toEntity());
		return "삭제 성공";
	}
	
	@Override
	public Member selectMember(MemberListDto memberListDto) {
		return memberDAO.selectMember(memberListDto.toEntity());
	}
}
