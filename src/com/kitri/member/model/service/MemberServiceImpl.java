package com.kitri.member.model.service;

import java.util.*;

import com.kitri.member.model.*;
import com.kitri.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	private static MemberService memberService;
	
	static {
		memberService = new MemberServiceImpl();
	}
	
	private MemberServiceImpl() {}

	public static MemberService getMemberService() {
		return memberService;
	}

	@Override
	public int idCheck(String id) {
		return MemberDaoImpl.getMemberDao().idCheck(id);
	}

	@Override
	public List<ZipCodeDto> zipSearch(String doro) {
		return MemberDaoImpl.getMemberDao().zipSearch(doro);
	}

	@Override
	public int register(MemberDetailDto memberDetailDto) {
		return MemberDaoImpl.getMemberDao().register(memberDetailDto);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		return null;
	}

	@Override
	public void modify(MemberDetailDto memberDetailDto) {

	}

	@Override
	public void delete(String id) {

	}

	@Override
	public MemberDto login(String id, String pass) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", id);
		map.put("userpwd", pass);
		return MemberDaoImpl.getMemberDao().login(map);
	}

	@Override
	public void logout() {

	}

}
