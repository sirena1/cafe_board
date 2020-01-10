package com.kitri.admin.board.model.dao;

import java.sql.*;
import java.util.*;

import com.kitri.admin.board.model.*;
import com.kitri.util.*;

public class BoardAdminDaoImpl implements BoardAdminDao {
	//2.
	private static BoardAdminDao boardAdminDao;
	//3.
	static {
		boardAdminDao = new BoardAdminDaoImpl();
	}
	//1.
	private BoardAdminDaoImpl() {}
	//4.
	public static BoardAdminDao getBoardAdminDao() {
		return boardAdminDao;
	}
		
	@Override
	public List<BoardListDto> menuList() {
		List<BoardListDto> list = new ArrayList<BoardListDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn= DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select bl.bcode, bl.bname, b1.btcode,\n");
			sql.append("		c.cocde, c.cname \n");
			sql.append("		case \n");
			sql.append("			when bl.btcode = 5 \n");
			sql.append("			then 'reboard' \n");
			sql.append("			when bl.btcode = 6 \n");
			sql.append("			then 'album'\n");
			sql.append("			when bl.btcode = 7 \n");
			sql.append("			then 'bbc' \n");
			sql.append("			else 'board' \n");
			sql.append("		end control \n");
			sql.append("from board_list bl, category c \n");
			sql.append("where b1.ccode = c.ccode \n");
			sql.append("order by c.ccode, bl.bcode \n");

			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardListDto boardListDto = new BoardListDto();
				boardListDto.setBcode(rs.getInt("bcode"));
				boardListDto.setBname(rs.getString("bname"));
				boardListDto.setBtcode(rs.getInt("btcode"));
				boardListDto.setCcode(rs.getInt("ccode"));
				boardListDto.setCname(rs.getString("cname"));
				boardListDto.setControl(rs.getString("control"));
				
				list.add(boardListDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<CategoryDto> categoryList() {
		return null;
	}

	@Override
	public void categoryMake(CategoryDto catecoryDto) {
	}

	@Override
	public List<BoardListDto> boardList(int ccode) {
		return null;
	}

	@Override
	public void boardMake(BoardListDto boardListDto) {
	}
}
