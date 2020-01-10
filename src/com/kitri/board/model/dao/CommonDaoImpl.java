package com.kitri.board.model.dao;

import java.sql.*;

import com.kitri.util.*;

public class CommonDaoImpl implements CommonDao {

private static CommonDao commonDao;
	
	static {
		commonDao = new CommonDaoImpl();
	}
	
	private CommonDaoImpl() {}
	
	public static CommonDao getCommonDao() {
		return commonDao;
	}
	
	@Override
	public int getNextSeq() {
		int seq = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select board_seq.nextval \n");
			sql.append("from dual \n");
			pstmt = conn.prepareStatement(sql.toString());			
			rs = pstmt.executeQuery();
			rs.next(); 
			seq = rs.getInt(1);	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return seq;
	}

}
