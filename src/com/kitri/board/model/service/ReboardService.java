package com.kitri.board.model.service;

import java.util.*;

import com.kitri.board.model.*;

public interface ReboardService {

	List<ReboardDto> listArticle(int bcode, int pg, String key, String word);
	int writeArticle(ReboardDto reboardDto); //글번호 리턴
	int replyArticle(ReboardDto reboardDto);
	ReboardDto viewArticle(int seq);
	ReboardDto getArticle(int seq);
	int modifyArticle(ReboardDto reboardDto);
	void deleteArticle(int seq);
	
}
