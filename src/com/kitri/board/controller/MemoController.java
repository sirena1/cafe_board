package com.kitri.board.controller;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kitri.factory.*;
import com.kitri.util.BoardConstance;

@WebServlet("/memo")
public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "";
		
		String act = request.getParameter("act");
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if("write".equals(act)) {
			json = BoardActionFactory.getMemoWriteAction().execute(request, response);
		} else if("list".equals(act)) {
			json = BoardActionFactory.getMemoListAction().execute(request, response);
		} else if("delete".equals(act)) {
			json = BoardActionFactory.getMemoDeleteAction().execute(request, response);
		} else if("modify".equals(act)) {
			json = BoardActionFactory.getMemoModifyAction().execute(request, response);
		} 
		out.print(json); //json을 보내라
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(BoardConstance.ENCODING);
		doGet(request, response);
	}

}
