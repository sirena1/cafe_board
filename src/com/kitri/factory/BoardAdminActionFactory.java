package com.kitri.factory;

import com.kitri.action.*;
import com.kitri.admin.board.action.*;

public class BoardAdminActionFactory {

	//1.
	
	private static Action boardMenuListAction;
	private static Action categoryListAction;
	private static Action categoryMakeAction;
	private static Action boardListAction;
	private static Action boardMakeAction;

	
	//2.
	static {
		boardMenuListAction = new BoardMenuListAction();
		categoryListAction = new CategoryListAction();
		categoryMakeAction = new CategoryMakeAction();
		boardListAction = new BoardListAction();
		boardMakeAction = new BoardMakeAction();
	}

	public static Action getBoardMenuListAction() {
		return boardMenuListAction;
	}
	
	public static Action getCategoryListAction() {
		return categoryListAction;
	}

	public static Action getCategoryMakeAction() {
		return categoryMakeAction;
	}

	public static Action getBoardListAction() {
		return boardListAction;
	}

	public static Action getBoardMakeAction() {
		return boardMakeAction;
	}
}
