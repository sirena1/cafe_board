package com.kitri.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.factory.*;
import com.kitri.util.*;

@WebServlet("/album")
public class AlbumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bcode = ValidateCheck.nullToZero(request.getParameter("bcode"));
		int pg = ValidateCheck.nullToOne(request.getParameter("pg"));
		String key = ValidateCheck.nullToBlank(request.getParameter("key"));
		String word = ValidateCheck.nullToBlank(request.getParameter("word"));
		String queryString = "?bcode=" + bcode + "&pg=" + pg + "&key=" + key + "&word=" + Encoder.utfEncode(word);
		System.out.println("queryString>>>>>>>" + queryString);		
		String path = "/index.jsp";
		
		String act = request.getParameter("act");
		System.out.println("<>>>>>>>>>>>>><<<<<<< " + act);
		
		if("list".equals(act)) {
			path = BoardActionFactory.getAlbumListAction().execute(request, response);
			MovePage.forward(request, response, path);
		} else if("mvwrite".equals(act)) {
			path = "/album/write.jsp" + queryString;
			MovePage.redirect(request, response, path);
		} else if("write".equals(act)) {
			path = BoardActionFactory.getAlbumWriteAction().execute(request, response);
			if(path.contains("writeok")) {
				path += queryString;
				MovePage.forward(request, response, path);
			} else {
				MovePage.redirect(request, response, path);
			}
		} else if("view".equals(act)) {
			path = BoardActionFactory.getAlbumViewAction().execute(request, response);
			path += queryString;
			MovePage.forward(request, response, path);
		} else if("mvmodify".equals(act)) {
			path = BoardActionFactory.getAlbumGetArticleAction().execute(request, response);
			path += queryString;
			MovePage.forward(request, response, path);
		} else if("modify".equals(act)) {
			path = BoardActionFactory.getAlbumModifyAction().execute(request, response);
			path += queryString;
			MovePage.forward(request, response, path);
		} else if("mvreply".equals(act)) {
			path = BoardActionFactory.getAlbumGetArticleAction().execute(request, response);
			path += queryString;
			MovePage.forward(request, response, path);
		} else {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.ENCODING);
		doGet(request, response);
	}

}
