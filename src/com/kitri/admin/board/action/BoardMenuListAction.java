package com.kitri.admin.board.action;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.kitri.action.*;
import com.kitri.admin.board.model.*;
import com.kitri.admin.board.model.service.*;

public class BoardMenuListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BoardListDto> list = BoardAdminServiceImpl.getBoardAdminService().menuList();
		System.out.println(">>>>>>>>" + list.size());
		return null;
	}

}
