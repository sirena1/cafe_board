package com.kitri.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.kitri.action.Action;
import com.kitri.member.model.MemberDto;
import com.kitri.member.model.service.MemberServiceImpl;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDto memberDto = MemberServiceImpl.getMemberService().login(id, pass);
		if(memberDto != null) {
//			request.setAttribute("userInfo", memberDto);
			
			/////////////////////// cookie /////////////////////
			String idck = request.getParameter("idsave");
			if("saveok".equals(idck)) {			
				Cookie cookie = new Cookie("asid", id);
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60 * 60 * 24 * 365 * 20);
				
				response.addCookie(cookie);
			} else {
				Cookie cookie[] = request.getCookies();
				if(cookie != null) {
					int len = cookie.length;
					for(int i=0;i<len;i++) {
						if(cookie[i].getName().equals("asid")) {
							cookie[i].setMaxAge(0);
							cookie[i].setPath(request.getContextPath());
							response.addCookie(cookie[i]);
							break;
						}
					}
				}
			}
			/////////////////////////////////////////////////////
			
			/////////////////////// session ///////////////////
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", memberDto);
			////////////////////////////////////////////////////
			path = "/index.jsp";
		} else {
			path = "/member/loginfail.jsp";
		}
		return path;
	}

}
