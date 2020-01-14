package com.kitri.board.model.service;

import java.util.*;

import com.kitri.board.model.dao.*;
import com.kitri.util.*;

public class CommonServiceImpl implements CommonService {

	private static CommonService commonSerivice;
	
	static {
		commonSerivice = new CommonServiceImpl();
	}
	
	private CommonServiceImpl() {}
	
	public static CommonService getCommonService() {
		return commonSerivice;
	}
	
	@Override
	public int getNextSeq() {
		
		return CommonDaoImpl.getCommonDao().getNextSeq();
	}

	@Override
	public PageNavigation getPageNavigation(int bcode, int pg, String key, String word) {
		//페이지 계산필요
		int listCount = BoardConstance.ARTICLE_COUNT;
		int naviCount = BoardConstance.NAVIGATION_COUNT;
		
		PageNavigation navigation = new PageNavigation();
		int newArticleCount = CommonDaoImpl.getCommonDao().getNewArticleCount(bcode);
		navigation.setNewArticleCount(newArticleCount);
		Map<String, String> map = new HashMap<String, String>();
		map.put("bcode", bcode + "");
		map.put("key", key);
		map.put("word", word);
		int totalArticleCount = CommonDaoImpl.getCommonDao().getTotalArticleCount(map);
		navigation.setTotalArticleCount(totalArticleCount);
		int totalPageCount = (totalArticleCount - 1) / listCount + 1;
		navigation.setTotalPageCount(totalPageCount);
		navigation.setPageNo(pg);
		navigation.setNowFirst(pg <= naviCount);
		//tp 전단계 마지막 페이지는 true 생각해보기
		navigation.setNowEnd((totalPageCount - 1) / naviCount * naviCount < pg);
		return navigation;
	}

}
