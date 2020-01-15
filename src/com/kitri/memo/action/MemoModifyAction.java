package com.kitri.memo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.board.model.*;
import com.kitri.board.model.service.*;

public class MemoModifyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String json = "{'memolist': []}";
		int seq = Integer.parseInt(request.getParameter("seq"));
		int mseq = Integer.parseInt(request.getParameter("mseq"));
		String mcontent = request.getParameter("mcontent");
		MemoDto memoDto = new MemoDto();
		memoDto.setSeq(seq);
		memoDto.setMseq(mseq);
		memoDto.setMcontent(mcontent);
		json = MemoServiceImpl.getMemoService().modifyMemo(memoDto);
		return json;
	}

}

