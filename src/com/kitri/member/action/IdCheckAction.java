package com.kitri.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.member.model.service.MemberServiceImpl;

public class IdCheckAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("checkid");
		int cnt = MemberServiceImpl.getMemberService().idCheck(id);
		System.out.println(id + "            " + cnt);
		request.setAttribute("searchid", id);
		request.setAttribute("idcount", cnt + "");
		return "/member/idresult.jsp";
	}

}
