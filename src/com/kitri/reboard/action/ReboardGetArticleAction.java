package com.kitri.reboard.action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.kitri.action.*;
import com.kitri.board.model.*;
import com.kitri.board.model.service.*;

public class ReboardGetArticleAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = act.equals("mvmodify") ? "modify" : "reply";
		int seq = Integer.parseInt(request.getParameter("seq"));
		ReboardDto reboardDto = ReboardServiceImpl.getReboardService().getArticle(seq);
		request.setAttribute("article", reboardDto);
		return "/reboard/" + path + ".jsp";
	}
}