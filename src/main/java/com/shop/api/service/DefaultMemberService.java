package com.shop.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.api.dao.MemberDAO;
import com.shop.api.dao.dto.Member;
import com.shop.api.service.dto.MemberWithdrawDto;
import com.shop.api.service.dto.MemberListDto;
import com.shop.api.service.dto.MemberSaveDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultMemberService implements MemberService {

	private final MemberDAO memberDAO;
	
	public Member saveMember(MemberSaveDto memberSaveDto) {
		memberDAO.saveMember(memberSaveDto.toEntity());
		MemberListDto memberListDto = new MemberListDto(memberSaveDto.getMi_id());
		
		return memberDAO.selectMember(memberListDto.toEntity());
	};

	@Override
	public Member selectMember(MemberListDto memberListDto) {
		return memberDAO.selectMember(memberListDto.toEntity());
	}
	
	@Override
	public String withdrawMember(MemberWithdrawDto memberWithdrawDto) {
		int result = memberDAO.withdrawMember(memberWithdrawDto.toEntity());
		
		if(result > 0) {
			return "삭제 성공";
		} else {
			return "삭제 실패";
		}
	}
}
