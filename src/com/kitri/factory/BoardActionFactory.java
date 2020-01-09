package com.kitri.factory;

import com.kitri.action.*;
import com.kitri.album.action.*;
import com.kitri.bbs.action.*;
import com.kitri.board.action.*;
import com.kitri.memo.action.*;
import com.kitri.reboard.action.*;

public class BoardActionFactory {

	//Album Action
	private static Action albumDeleteAction;
	private static Action albumGetArticleAction;
	private static Action albumListAction;
	private static Action albumModifyAction;
	private static Action albumViewAction;
	private static Action albumWriteAction;
	
	//Bbs Action
	private static Action bbsDeleteAction;
	private static Action bbsGetArticleAction;
	private static Action bbsListAction;
	private static Action bbsModifyAction;
	private static Action bbsViewAction;
	private static Action bbsWriteAction;
	
	//Board Action
	private static Action boardDeleteAction;
	private static Action boardGetArticleAction;
	private static Action boardListAction;
	private static Action boardModifyAction;
	private static Action boardViewAction;
	private static Action boardWriteAction;
	
	//Reboard Action
	private static Action reboardDeleteAction;
	private static Action reboardGetArticleAction;
	private static Action reboardListAction;
	private static Action reboardModifyAction;
	private static Action reboardReplyAction;
	private static Action reboardViewAction;
	private static Action reboardWriteAction;
	

	//Memo Action
	private static Action memoDeleteAction;
	private static Action memoListAction;
	private static Action memoModifyAction;
	private static Action memoWriteAction;
	
	static {
		albumDeleteAction = new AlbumDeleteAction();
		albumGetArticleAction = new AlbumGetArticleAction();
		albumListAction = new AlbumListAction();
		albumModifyAction = new AlbumModifyAction();
		albumViewAction = new AlbumViewAction();
		albumWriteAction = new AlbumWriteAction();
		
		bbsDeleteAction = new BbsDeleteAction();
		bbsGetArticleAction = new BbsGetArticleAction();
		bbsListAction = new BbsListAction();
		bbsModifyAction = new BbsModifyAction();
		bbsViewAction = new BbsViewAction();
		bbsWriteAction = new BbsWriteAction();
		
		boardDeleteAction = new BoardDeleteAction();
		boardGetArticleAction = new BoardGetArticleAction();
		boardListAction = new BoardListAction();
		boardModifyAction = new BoardModifyAction();
		bbsViewAction = new BbsViewAction();
		bbsWriteAction = new BbsWriteAction();
		
		reboardDeleteAction = new ReboardDeleteAction();
		reboardGetArticleAction = new ReboardGetArticleAction();
		reboardListAction = new ReboardListAction();
		reboardModifyAction = new ReboardModifyAction();
		reboardReplyAction = new ReboardReplyAction();
		reboardViewAction = new ReboardViewAction();
		reboardWriteAction = new ReboardWriteAction();
		
		memoDeleteAction = new MemoDeleteAction();
		memoListAction = new MemoListAction();
		memoModifyAction = new MemoModifyAction();
		memoWriteAction = new MemoWriteAction();
	}

	public static Action getAlbumDeleteAction() {
		return albumDeleteAction;
	}

	public static Action getAlbumGetArticleAction() {
		return albumGetArticleAction;
	}

	public static Action getAlbumListAction() {
		return albumListAction;
	}

	public static Action getAlbumModifyAction() {
		return albumModifyAction;
	}

	public static Action getAlbumViewAction() {
		return albumViewAction;
	}

	public static Action getAlbumWriteAction() {
		return albumWriteAction;
	}

	public static Action getBbsDeleteAction() {
		return bbsDeleteAction;
	}

	public static Action getBbsGetArticleAction() {
		return bbsGetArticleAction;
	}

	public static Action getBbsListAction() {
		return bbsListAction;
	}

	public static Action getBbsModifyAction() {
		return bbsModifyAction;
	}

	public static Action getBbsViewAction() {
		return bbsViewAction;
	}

	public static Action getBbsWriteAction() {
		return bbsWriteAction;
	}

	public static Action getBoardDeleteAction() {
		return boardDeleteAction;
	}

	public static Action getBoardGetArticleAction() {
		return boardGetArticleAction;
	}

	public static Action getBoardListAction() {
		return boardListAction;
	}

	public static Action getBoardModifyAction() {
		return boardModifyAction;
	}

	public static Action getBoardViewAction() {
		return boardViewAction;
	}

	public static Action getBoardWriteAction() {
		return boardWriteAction;
	}

	public static Action getReboardDeleteAction() {
		return reboardDeleteAction;
	}

	public static Action getReboardGetArticleAction() {
		return reboardGetArticleAction;
	}

	public static Action getReboardListAction() {
		return reboardListAction;
	}

	public static Action getReboardModifyAction() {
		return reboardModifyAction;
	}

	public static Action getReboardReplyAction() {
		return reboardReplyAction;
	}

	public static Action getReboardViewAction() {
		return reboardViewAction;
	}

	public static Action getReboardWriteAction() {
		return reboardWriteAction;
	}

	public static Action getMemoDeleteAction() {
		return memoDeleteAction;
	}

	public static Action getMemoListAction() {
		return memoListAction;
	}

	public static Action getMemoModifyAction() {
		return memoModifyAction;
	}

	public static Action getMemoWriteAction() {
		return memoWriteAction;
	}
	
	
}
