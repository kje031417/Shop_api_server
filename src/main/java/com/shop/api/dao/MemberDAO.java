package com.shop.api.dao;

import com.shop.api.dao.dto.MemberId;
import com.shop.api.dao.dto.Member;

public interface MemberDAO {
	int joinMember(Member member);
	int modifyMember(Member member);
	int withdrawMember(MemberId memberId);
	Member selectMember(MemberId memberId);
}
