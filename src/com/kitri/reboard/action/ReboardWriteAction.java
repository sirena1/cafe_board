package com.kitri.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.kitri.action.Action;
import com.kitri.board.model.*;
import com.kitri.board.model.service.*;
import com.kitri.member.model.*;

public class ReboardWriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//제목, 내용을 받아와야 한다
		String path = "/index.jsp";
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) { //로그인을 했다면?
			
			//작성된 것을 불러와 게시판에 insert
			ReboardDto reboardDto = new ReboardDto();
			
			reboardDto.setId(memberDto.getId());
			reboardDto.setName(memberDto.getName());
			reboardDto.setEmail(memberDto.getEmailid() + "@" + memberDto.getEmaildomain());
			reboardDto.setSubject(request.getParameter("subject"));
			reboardDto.setContent(request.getParameter("content"));
			reboardDto.setBcode(Integer.parseInt(request.getParameter("bcode")));
			
			int seq = ReboardServiceImpl.getReboardService().writeArticle(reboardDto);
			if(seq != 0) { //성공 했을 때
				path = "/reboard/writeok.jsp";
				request.setAttribute("seq", seq);
			} else { //실패 했을 때
				path = "/index.jsp";
			}
		} else { //로그인 안했을 때
			path = "/member/login.jsp";
		}
		
		return path;
	}

}

