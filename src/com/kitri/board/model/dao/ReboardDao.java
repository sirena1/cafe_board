package com.kitri.board.model.dao;

import java.util.*;

import com.kitri.board.model.*;

public interface ReboardDao {

	List<ReboardDto> listArticle(Map<String, String> map);
	int writeArticle(ReboardDto reboardDto); //글번호 리턴
	int replyArticle(ReboardDto reboardDto);
	ReboardDto viewArticle(int seq);
	int modifyArticle(ReboardDto reboardDto);
	void deleteArticle(int seq);
}
