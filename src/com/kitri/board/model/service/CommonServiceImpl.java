package com.kitri.board.model.service;

import com.kitri.board.model.dao.*;

public class CommonServiceImpl implements CommonService {

	private static CommonService commonSerivice;
	
	static {
		commonSerivice = new CommonServiceImpl();
	}
	
	private CommonServiceImpl() {}
	
	public static CommonService getCommonService() {
		return commonSerivice;
	}
	
	@Override
	public int getNextSeq() {
		return CommonDaoImpl.getCommonDao().getNextSeq();
	}

}
