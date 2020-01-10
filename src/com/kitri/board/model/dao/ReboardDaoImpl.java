package com.kitri.board.model.dao;

import java.util.*;

import com.kitri.board.model.*;

public class ReboardDaoImpl implements ReboardDao {

	private static ReboardDao reboardDao;
	
	static {
		reboardDao = new ReboardDaoImpl();
	}
	
	private ReboardDaoImpl() {}
	
	public static ReboardDao getReboardDao() {
		return reboardDao;
	}
	
	@Override
	public List<ReboardDto> listArticle(Map<String, String> map) {
		return null;
	}

	@Override
	public int writeArticle(ReboardDto reboardDto) {
		return 0;
	}

	@Override
	public int replyArticle(ReboardDto reboardDto) {
		return 0;
	}

	@Override
	public ReboardDto viewArticle(int seq) {
		return null;
	}

	@Override
	public ReboardDto getArticle(int seq) {
		return null;
	}

	@Override
	public int modyfyArticle(ReboardDto reboardDto) {
		return 0;
	}

	@Override
	public void deleteArticle(int seq) {
	}

}
