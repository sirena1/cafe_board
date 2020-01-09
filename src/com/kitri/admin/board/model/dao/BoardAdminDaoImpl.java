package com.kitri.admin.board.model.dao;

import java.util.*;

import com.kitri.admin.board.model.*;

public class BoardAdminDaoImpl implements BoardAdminDao {
	//2.
	private static BoardAdminDao boardAdminDao;
	//3.
	static {
		boardAdminDao = new BoardAdminDaoImpl();
	}
	//1.
	private BoardAdminDaoImpl() {}
	//4.
	public static BoardAdminDao getBoardAdminDao() {
		return boardAdminDao;
	}
		
	@Override
	public List<BoardListDto> menuList() {
		return null;
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
