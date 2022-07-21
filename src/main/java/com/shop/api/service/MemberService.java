package com.shop.api.service;

import com.shop.api.dao.dto.Member;
import com.shop.api.service.dto.MemberWithdrawDto;
import com.shop.api.service.dto.MemberListDto;
import com.shop.api.service.dto.MemberSaveDto;

public interface MemberService {
	Member saveMember(MemberSaveDto memberSaveDto);
	Member selectMember(MemberListDto memberListDto);
	String withdrawMember(MemberWithdrawDto memberWithdrawDto);
}
