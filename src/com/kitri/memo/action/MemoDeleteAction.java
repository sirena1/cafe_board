package com.kitri.memo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.board.model.service.*;

public class MemoDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String json = "{'memolist': []}";
		int seq = Integer.parseInt(request.getParameter("seq")); //글번호 얻어오기
		int mseq = Integer.parseInt(request.getParameter("mseq"));
		json = MemoServiceImpl.getMemoService().deleteMemo(mseq, seq);
		return json;
	}

}

