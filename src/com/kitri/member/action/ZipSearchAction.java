package com.kitri.member.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.member.model.ZipCodeDto;
import com.kitri.member.model.service.MemberServiceImpl;

public class ZipSearchAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sdoro = request.getParameter("sdoro");
		List<ZipCodeDto> list = MemberServiceImpl.getMemberService().zipSearch(sdoro);
//		TODO 나중에 json lib를 이용..
		request.setAttribute("ziplist", list);
		return "/member/ziplist_json.jsp";
	}

}














