package com.kitri.board.model.service;

import java.util.*;

import com.kitri.board.model.*;

public interface AlbumService {

	List<AlbumDto> listArticle(int bcode, int pg, String key, String word);
	int writeArticle(AlbumDto albumDto); //글번호 리턴
	AlbumDto viewArticle(int seq);
	AlbumDto getArticle(int seq);
	int modifyArticle(AlbumDto albumDto);
	void deleteArticle(int seq);
}
