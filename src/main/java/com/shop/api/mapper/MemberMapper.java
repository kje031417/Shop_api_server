package com.shop.api.mapper;

import com.shop.api.dao.dto.MemberId;
import com.shop.api.dao.dto.Member;

public interface MemberMapper {
	int saveMember(Member member);
	Member selectMember(MemberId memberId);
	int withdrawMember(MemberId memberId);
}
