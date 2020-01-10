package com.kitri.board.model.service;

import java.util.*;

import com.kitri.board.model.*;

public class ReboardServiceImpl implements ReboardService {

	private static ReboardService reboardService;
	
	static {
		reboardService = new ReboardServiceImpl();
	}
	
	private ReboardServiceImpl() {}
	
	public static ReboardService getReboardService() {
		return reboardService;
	}
	
	@Override
	public List<ReboardDto> listArticle(int bcode, int pg, String key, String word) {
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
