package com.kitri.member.model.service;

import java.util.List;

import com.kitri.member.model.*;

public interface MemberService {

	int idCheck(String id);
	List<ZipCodeDto> zipSearch(String doro);
	int register(MemberDetailDto memberDetailDto);
	MemberDetailDto getMember(String id);
	void modify(MemberDetailDto memberDetailDto);
	void delete(String id);
	MemberDto login(String id, String pass);
	void logout();
	
}
