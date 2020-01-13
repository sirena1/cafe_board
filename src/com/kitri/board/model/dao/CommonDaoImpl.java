package com.kitri.board.model.dao;

import java.sql.*;
import java.util.*;

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

	@Override
	public int getNewArticleCount(int bcode) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(seq) \n");
			sql.append("from board \n");
			sql.append("where bcode = ? \n");
			sql.append("and to_char(logtime, 'yymmdd') = to_char(sysdate, 'yymmdd') \n");
			pstmt = conn.prepareStatement(sql.toString());		
			pstmt.setInt(1, bcode);
			rs = pstmt.executeQuery();
			rs.next(); 
			cnt = rs.getInt(1);	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int getTotalArticleCount(Map<String, String> map) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select count(seq) \n");
			sql.append("from board \n");
			sql.append("where bcode = ? \n");
			pstmt = conn.prepareStatement(sql.toString());		
			pstmt.setInt(1, Integer.parseInt(map.get("bcode")));
			rs = pstmt.executeQuery();
			rs.next(); 
			cnt = rs.getInt(1);	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return cnt;
	}

}
