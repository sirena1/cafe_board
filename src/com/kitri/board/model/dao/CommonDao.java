package com.kitri.board.model.dao;

import java.util.*;

public interface CommonDao {

	int getNextSeq();
	int getNewArticleCount(int bcode);
	int getTotalArticleCount(Map<String, String> map);
}
