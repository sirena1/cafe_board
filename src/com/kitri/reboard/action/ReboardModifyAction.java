package com.kitri.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.kitri.action.Action;
import com.kitri.board.model.*;
import com.kitri.board.model.service.*;
import com.kitri.member.model.*;

public class ReboardModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String path = "index.jsp";
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		
		if(memberDto != null) {
			
			ReboardDto reboardDto = new ReboardDto();
			
			reboardDto.setSeq(Integer.parseInt(request.getParameter("seq")));
			reboardDto.setSubject(request.getParameter("subject"));
			reboardDto.setContent(request.getParameter("content"));
			
			ReboardServiceImpl.getReboardService().modifyArticle(reboardDto);
			reboardDto = ReboardServiceImpl.getReboardService().viewArticle(reboardDto.getSeq());
			request.setAttribute("article", reboardDto);
			path = "/reboard/view.jsp";
		} else {
			path = "/member/login.jsp";
		}
		
		return path;
	}

}