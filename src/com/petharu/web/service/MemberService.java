package com.petharu.web.service;

import com.petharu.web.entity.Member;

public interface MemberService {
	Member get(String userId);
	int insert(Member member);
	int update(Member member);
	int delete(int memberId);
	String getPwd(String userId);
}
