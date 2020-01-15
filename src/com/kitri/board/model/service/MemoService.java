package com.kitri.board.model.service;

import com.kitri.board.model.*;

public interface MemoService {

	String writeMemo(MemoDto memoDto);
	String listMemo(int seq); //몇번글에 있는 댓글들
	String modifyMemo(MemoDto memoDto);
	String deleteMemo(int mseq, int seq);
}
