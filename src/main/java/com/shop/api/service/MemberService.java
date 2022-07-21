package com.shop.api.service;

import com.shop.api.dao.dto.Member;
import com.shop.api.service.dto.MemberWithdrawDto;
import com.shop.api.service.dto.MemberJoinDto;
import com.shop.api.service.dto.MemberListDto;
import com.shop.api.service.dto.MemberModifyDto;

public interface MemberService {
	Member joinMember(MemberJoinDto memberJoinDto);
	Member modifyMember(MemberModifyDto memberModifyDto);
	String withdrawMember(MemberWithdrawDto memberWithdrawDto);
	Member selectMember(MemberListDto memberListDto);
}
