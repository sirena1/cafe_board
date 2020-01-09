package com.kitri.admin.board.model.service;

import java.util.*;

import com.kitri.admin.board.model.*;

public interface BoardAdminService {

	List<BoardListDto> menuList();//모든것을 가져와야 하니깐 인자값으로 가져올 것이 없다.
	
	List<CategoryDto> categoryList();
	void categoryMake(CategoryDto catecoryDto); //카테고리 정보로 insert할 꺼니깐
	
	List<BoardListDto> boardList(int ccode); //어떤 카테고리 밑에 무슨 이름이 있는지 알아야 되기 때문에 인자값으로 ccode
	void boardMake(BoardListDto boardListDto);
}
