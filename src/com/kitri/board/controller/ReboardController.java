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
		String queryString = "?bcode=" + bcode + "&pg=" + pg + "&key=" + key + "&word=" + word;
				
		String path = "/index.jsp";
		
		String act = request.getParameter("act");
		
		if("list".equals(act)) {
			
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
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.ENCODING);
		doGet(request, response);
	}

}
