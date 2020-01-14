package com.kitri.reboard.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.board.model.*;
import com.kitri.board.model.service.*;

public class ReboardViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		ReboardDto reboardDto = ReboardServiceImpl.getReboardService().viewArticle(seq);
		//다음페이지에서만 보여주니깐 request에 담으면 된다.
		request.setAttribute("article", reboardDto);
		return "reboard/view.jsp";
	}
}

