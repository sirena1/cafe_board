package com.kitri.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.kitri.action.Action;

public class LogoutAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
//		session.setAttribute("userInfo", null);
//		session.removeAttribute("userInfo");
		session.invalidate();
//		return "/member/loginok.jsp";
		return "/index.jsp";
	}

}
















