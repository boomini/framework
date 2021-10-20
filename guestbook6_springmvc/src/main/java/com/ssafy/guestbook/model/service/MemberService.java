package com.ssafy.guestbook.model.service;

import java.util.Map;

import com.ssafy.guestbook.model.MemberDto;

public interface MemberService {
	int idCheck(String id) throws Exception;
	void registerMember(MemberDto memberDto) throws Exception;
	MemberDto login(Map<String, String> map) throws Exception;
}
