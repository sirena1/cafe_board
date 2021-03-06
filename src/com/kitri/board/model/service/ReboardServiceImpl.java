package com.kitri.board.model.service;

import java.util.*;

import com.kitri.board.model.*;
import com.kitri.board.model.dao.*;
import com.kitri.util.*;

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
		int end = pg * BoardConstance.ARTICLE_COUNT;
		int start = end - BoardConstance.ARTICLE_COUNT;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("bcode", bcode + "");
		map.put("key", key);
		map.put("word", word);
		map.put("start", start + "");
		map.put("end", end + "");
		return ReboardDaoImpl.getReboardDao().listArticle(map);
	}

	@Override
	public int writeArticle(ReboardDto reboardDto) {
		int seq = CommonServiceImpl.getCommonService().getNextSeq();
		reboardDto.setSeq(seq);
		reboardDto.setRef(seq);
		int cnt = ReboardDaoImpl.getReboardDao().writeArticle(reboardDto);
		return cnt != 0? seq : 0;
	}

	@Override
	public int replyArticle(ReboardDto reboardDto) {
		int seq = CommonServiceImpl.getCommonService().getNextSeq();
		//답글일 떄는 원글의 ref랑 같다
		reboardDto.setSeq(seq);
		int cnt = ReboardDaoImpl.getReboardDao().replyArticle(reboardDto);
		return cnt != 0? seq : 0;
	}

	@Override
	public ReboardDto viewArticle(int seq) {
		//db가기
		ReboardDto reboardDto = ReboardDaoImpl.getReboardDao().viewArticle(seq);
		CommonDaoImpl.getCommonDao().updateHit(seq);
		return reboardDto;
	}

	@Override
	public ReboardDto getArticle(int seq) {
		return ReboardDaoImpl.getReboardDao().viewArticle(seq);
	}

	
	@Override
	public void deleteArticle(int seq) {
	}

	@Override
	public int modifyArticle(ReboardDto reboardDto) {
		return ReboardDaoImpl.getReboardDao().modifyArticle(reboardDto);
	}

}
