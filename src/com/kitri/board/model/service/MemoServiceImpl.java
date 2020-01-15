package com.kitri.board.model.service;

import java.util.List;

import org.json.*;

import com.kitri.board.model.MemoDto;
import com.kitri.board.model.dao.MemoDaoImpl;

public class MemoServiceImpl implements MemoService {

	private static MemoService memoService;
	
	static {
		memoService = new MemoServiceImpl();
	}
	
	private MemoServiceImpl() {}
		
	public static MemoService getMemoService() {
		return memoService;
	}
	
	@Override
	public String writeMemo(MemoDto memoDto) {
		MemoDaoImpl.getMemoDao().writeMemo(memoDto);
		return makeJsonList(memoDto.getSeq());
	}

	@Override
	public String listMemo(int seq) {
		return makeJsonList(seq);
	}

	@Override
	public String modifyMemo(MemoDto memoDto) {
		MemoDaoImpl.getMemoDao().modifyMemo(memoDto);
		return makeJsonList(memoDto.getSeq());
	}

	@Override
	public String deleteMemo(int mseq, int seq) {
		MemoDaoImpl.getMemoDao().deleteMemo(mseq);
		return makeJsonList(seq);
	}
	
	private String makeJsonList(int seq) {
		List<MemoDto> list = MemoDaoImpl.getMemoDao().listMemo(seq);
		JSONObject obj = new JSONObject();
		JSONArray jarray = new JSONArray(list);
		obj.put("memolist", jarray);
		return obj.toString();
	}

	

}
