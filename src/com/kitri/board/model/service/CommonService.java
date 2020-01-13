package com.kitri.board.model.service;

import com.kitri.util.*;

public interface CommonService {
//모든 게시판 공통으로 쓸 만한 것
	int getNextSeq();
	
	PageNavigation getPageNavigation(int bcode, int pg, String key, String word);
}
