package com.kitri.board.model.service;

import java.util.*;

import com.kitri.board.model.*;
import com.kitri.board.model.dao.*;

public class AlbumServiceImpl implements AlbumService {

	private static AlbumServiceImpl albumService;
	
	static {
		albumService = new AlbumServiceImpl();
	}
	
	private AlbumServiceImpl() {}
	
	public static AlbumService getAlbumService() {
		return albumService;
	}
	
	@Override
	public List<AlbumDto> listArticle(int bcode, int pg, String key, String word) {
		return null;
	}

	@Override
	public int writeArticle(AlbumDto albumDto) {
		int seq = CommonServiceImpl.getCommonService().getNextSeq();
		albumDto.setSeq(seq);
		int cnt = AlbumDaoImpl.getAlbumDao().writeArticle(albumDto);
		return cnt != 0? seq : 0;
	}

	@Override
	public AlbumDto viewArticle(int seq) {
		return null;
	}

	@Override
	public AlbumDto getArticle(int seq) {
		return null;
	}

	@Override
	public int modifyArticle(AlbumDto albumDto) {
		return 0;
	}

	@Override
	public void deleteArticle(int seq) {
	}

}
