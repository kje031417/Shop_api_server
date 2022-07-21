package com.shop.api.mapper;

import com.shop.api.dao.dto.MemberId;
import com.shop.api.dao.dto.Member;

public interface MemberMapper {
	int joinMember(Member member);
	int modifyMember(Member member);
	int withdrawMember(MemberId memberId);
	Member selectMember(MemberId memberId);
}
