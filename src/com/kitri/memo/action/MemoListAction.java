package com.kitri.memo.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.*;

import com.kitri.action.Action;
import com.kitri.board.model.*;
import com.kitri.board.model.service.*;

public class MemoListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String json = "{'memolist': []}"; //json형태로 맞춰주기, json return
		int seq = Integer.parseInt(request.getParameter("seq")); //글번호 얻어오기
		json = MemoServiceImpl.getMemoService().listMemo(seq);//list를 json으로 바꿔라

		return json;
	}

}

