package com.kitri.board.model.dao;

import java.util.*;

import com.kitri.board.model.*;

public interface MemoDao {

	void writeMemo(MemoDto memoDto);
	List<MemoDto> listMemo(int seq); //몇번글에 있는 댓글들
	void modifyMemo(MemoDto memoDto);
	void deleteMemo(int mseq);
}
