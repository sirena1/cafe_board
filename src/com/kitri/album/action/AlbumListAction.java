package com.kitri.album.action;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.kitri.action.*;
import com.kitri.board.model.*;
import com.kitri.board.model.service.*;
import com.kitri.util.*;

public class AlbumListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bcode = ValidateCheck.nullToZero(request.getParameter("bcode"));
		int pg = ValidateCheck.nullToOne(request.getParameter("pg"));
		String key = ValidateCheck.nullToBlank(request.getParameter("key"));
		String word = ValidateCheck.nullToBlank(request.getParameter("word"));
		
		List<AlbumDto> list = AlbumServiceImpl.getAlbumService().listArticle(bcode, pg, key, word);
		request.setAttribute("articleList", list);
		
		PageNavigation navigation = CommonServiceImpl.getCommonService().getPageNavigation(bcode, pg, key, word);
		navigation.setRoot(request.getContextPath());
		navigation.makeNavigator();
		request.setAttribute("navigator", navigation);
		
		return "/album/list.jsp";
	}
}

