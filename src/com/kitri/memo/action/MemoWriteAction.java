package com.kitri.memo.action;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.json.*;

import com.kitri.action.*;
import com.kitri.board.model.*;
import com.kitri.board.model.service.*;
import com.kitri.member.model.*;

public class MemoWriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String json = "{'memolist': []}"; //json형태로 맞춰주기
		
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) { //로그인을 했다면?
			int seq = Integer.parseInt(request.getParameter("seq"));
			MemoDto memoDto = new MemoDto();
			memoDto.setSeq(seq);
			memoDto.setId(memberDto.getId());
			memoDto.setName(memberDto.getName());
			memoDto.setMcontent(request.getParameter("mcontent"));
				
			json = MemoServiceImpl.getMemoService().writeMemo(memoDto);
		}
			return json;
	}

}

