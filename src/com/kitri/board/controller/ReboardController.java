package com.kitri.board.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.kitri.factory.*;
import com.kitri.util.*;

@WebServlet("/reboard")
public class ReboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		
		int bcode = ValidateCheck.nullToZero(request.getParameter("bcode"));
		int pg = ValidateCheck.nullToOne(request.getParameter("pg"));
		String key = ValidateCheck.nullToBlank(request.getParameter("key"));
		String word = ValidateCheck.nullToBlank(request.getParameter("word"));
		String queryString = "?bcode=" + bcode + "&pg=" + pg + "&key=" + key + "&word=" + Encoder.utfEncode(word);
		System.out.println("queryString>>>>>>>" + queryString);		
		String path = "/index.jsp";
		
		String act = request.getParameter("act");
		
		if("list".equals(act)) {
			path = BoardActionFactory.getReboardListAction().execute(request, response);
			MovePage.forward(request, response, path);
		} else if("mvwrite".equals(act)) {
			path = "/reboard/write.jsp" + queryString;
			MovePage.redirect(request, response, path);
		} else if("write".equals(act)) {
			path = BoardActionFactory.getReboardWriteAction().execute(request, response);
			if(path.contains("writeok")) {
				path += queryString;
				MovePage.forward(request, response, path);
			} else {
				MovePage.redirect(request, response, path);
			}
		} else if("view".equals(act)) {
			path = BoardActionFactory.getReboardViewAction().execute(request, response);
			path += queryString;
			MovePage.forward(request, response, path);
		} else if("mvmodify".equals(act)) {
			path = BoardActionFactory.getReboardGetArticleAction().execute(request, response);
			path += queryString;
			MovePage.forward(request, response, path);
		} else if("modify".equals(act)) {
			path = BoardActionFactory.getReboardModifyAction().execute(request, response);
			path += queryString;
			MovePage.forward(request, response, path);
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		}
		else {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.ENCODING);
		doGet(request, response);
	}

}
