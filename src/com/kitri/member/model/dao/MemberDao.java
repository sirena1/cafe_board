package com.kitri.member.model.dao;

import java.util.List;
import java.util.Map;

import com.kitri.member.model.*;

public interface MemberDao {

	int idCheck(String id);
	List<ZipCodeDto> zipSearch(String doro);
	int register(MemberDetailDto memberDetailDto);
	MemberDetailDto getMember(String id);
	void modify(MemberDetailDto memberDetailDto);
	void delete(String id);
	MemberDto login(Map<String , String> map);
	
}
