package com.kitri.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String path = "/index.jsp";
		
		String act = request.getParameter("act");
		
		if("list".equals(act)) {
			
		} else if("mvwrite".equals(act)) {
			path = "/reboard/write.jsp?bcode=" + bcode + "&pg=" + pg + "&key=" + key + "&word=" + word;
			MovePage.redirect(request, response, path);
		} else if("write".equals(act)) {
			path = BoardActionFactory.getReboardWriteAction().execute(request, response);
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
