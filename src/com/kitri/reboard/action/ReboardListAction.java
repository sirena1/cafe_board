package com.kitri.reboard.action;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.action.Action;
import com.kitri.board.model.*;
import com.kitri.board.model.service.*;
import com.kitri.util.*;

public class ReboardListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//뭘 얻어와야 하나?? db가서 select할건데.. 필요한 게 뭘까??
		int bcode = ValidateCheck.nullToZero(request.getParameter("bcode"));
		int pg = ValidateCheck.nullToOne(request.getParameter("pg"));
		String key = ValidateCheck.nullToBlank(request.getParameter("key"));
		String word = ValidateCheck.nullToBlank(request.getParameter("word"));
		List<ReboardDto> list = ReboardServiceImpl.getReboardService().listArticle(bcode, pg, key, word);
//		System.out.println("list>>>>>>>>" + list.size());
		request.setAttribute("articleList", list);
		
		PageNavigation navigation = CommonServiceImpl.getCommonService().getPageNavigation(bcode, pg, key, word);
		navigation.setRoot(request.getContextPath());
		navigation.makeNavigator();
		request.setAttribute("navigator", navigation);
		
		return "/reboard/list.jsp";
	}
}

