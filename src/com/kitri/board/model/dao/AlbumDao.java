package com.kitri.board.model.dao;

import java.util.*;

import com.kitri.board.model.*;

public interface AlbumDao {

	List<AlbumDto> listArticle(Map<String, String> map);
	int writeArticle(AlbumDto albumDto); //글번호 리턴
	AlbumDto viewArticle(int seq);
	AlbumDto getArticle(int seq);
	int modifyArticle(AlbumDto albumDto);
	void deleteArticle(int seq);
}
