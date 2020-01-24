package com.kitri.reboard.action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.kitri.action.*;
import com.kitri.board.model.service.*;

public class ReboardDeleteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		ReboardServiceImpl.getReboardService().deleteArticle(seq);
		return "/reboard?act=list";
	}

}

