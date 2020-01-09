package com.kitri.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.member.model.MemberDetailDto;
import com.kitri.member.model.service.MemberServiceImpl;

public class RegisterAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = null;
		
		MemberDetailDto memberDetailDto = new MemberDetailDto();
		memberDetailDto.setId(request.getParameter("id"));
		memberDetailDto.setName(request.getParameter("name"));
		memberDetailDto.setPass(request.getParameter("pass"));
		memberDetailDto.setEmailid(request.getParameter("emailid"));
		memberDetailDto.setEmaildomain(request.getParameter("emaildomain"));
		memberDetailDto.setTel1(request.getParameter("tel1"));
		memberDetailDto.setTel2(request.getParameter("tel2"));
		memberDetailDto.setTel3(request.getParameter("tel3"));
		memberDetailDto.setZipcode(request.getParameter("zipcode"));
		memberDetailDto.setAddress(request.getParameter("address"));
		memberDetailDto.setAddressDetail(request.getParameter("address_detail"));
		
		int cnt = MemberServiceImpl.getMemberService().register(memberDetailDto);
		
		if(cnt != 0) {
			request.setAttribute("registerInfo", memberDetailDto);
			path = "/member/registerok.jsp";
		} else {
			path = "/member/registerfail.jsp";
		}
		
		return path;
	}

}







