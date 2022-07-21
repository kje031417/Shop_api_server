package com.shop.api.dao;

import com.shop.api.dao.dto.MemberId;
import com.shop.api.dao.dto.Member;

public interface MemberDAO {
	int saveMember(Member member);
	Member selectMember(MemberId memberId);
	int withdrawMember(MemberId memberId);
}
