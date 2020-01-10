package com.kitri.admin.board.model.service;

import java.util.*;

import com.kitri.admin.board.model.*;
import com.kitri.admin.board.model.dao.*;

public class BoardAdminServiceImpl implements BoardAdminService{

	private static BoardAdminService boardAdminService;
	
	static {
		boardAdminService = new BoardAdminServiceImpl();
	}
	
	private BoardAdminServiceImpl() {}
	
	public static BoardAdminService getBoardAdminService() {
		return boardAdminService;
	}
	
	@Override
	public List<BoardListDto> menuList() {
		return BoardAdminDaoImpl.getBoardAdminDao().menuList();
	}

	@Override
	public List<CategoryDto> categoryList() {
		return null;
	}

	@Override
	public void categoryMake(CategoryDto catecoryDto) {
	}

	@Override
	public List<BoardListDto> boardList(int ccode) {
		return null;
	}

	@Override
	public void boardMake(BoardListDto boardListDto) {
	}

}
