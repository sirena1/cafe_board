package com.kitri.admin.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.factory.*;
import com.kitri.util.*;

@WebServlet("/boardadmin")
public class BoardAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		
		String path = "/index.jsp";
		
		String act = request.getParameter("act");
		
		if("index".equals(act)) {
			path = BoardAdminActionFactory.getBoardMenuListAction().execute(request, response);
			MovePage.redirect(request, response, path);
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
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
