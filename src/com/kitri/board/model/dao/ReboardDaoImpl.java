package com.kitri.board.model.dao;

import java.sql.*;
import java.util.*;

import com.kitri.board.model.*;
import com.kitri.util.*;

public class ReboardDaoImpl implements ReboardDao {

	private static ReboardDao reboardDao;
	
	static {
		reboardDao = new ReboardDaoImpl();
	}
	
	private ReboardDaoImpl() {}
	
	public static ReboardDao getReboardDao() {
		return reboardDao;
	}
	
	@Override
	public List<ReboardDto> listArticle(Map<String, String> map) {
		List<ReboardDto> list = new ArrayList<ReboardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select a.*\n");
			sql.append("from (\n");
			sql.append("        select RANK() OVER(ORDER BY r.ref DESC, r.step) rank,\n");
			sql.append("                b.seq, b.name, b.id, b.email, b.subject, b.content, b.hit, b.bcode,\n");
			sql.append("                case when trunc(b.logtime, 'dd')=trunc(sysdate, 'dd')\n");
			sql.append("                       then to_char(b.logtime, 'hh24:mi:ss')\n");
			sql.append("                       else to_char(b.logtime, 'yy.mm.dd')\n");
			sql.append("               end as logtime, r.rseq, r.ref, r.lev, r.step, r.pseq, r.reply\n");
			sql.append("        from board b, reboard r\n");
			sql.append("        where b.seq = r.seq\n");
			sql.append("		and bcode=?\n");
			
			String key = map.get("key"); //subject, content, name
			String word = map.get("word");
			if(!key.isEmpty() && !word.isEmpty()) {
				if(key.equals("name"))
					sql.append("		and name = ? \n");
				else
					sql.append("		and " + key + " like '%'||?||'%' \n");
			}
			sql.append("     ) a\n");
			sql.append("where a.rank > ? and a.rank <= ? \n");
			pstmt = conn.prepareStatement(sql.toString());	
//			System.out.println(sql.toString()); //쿼리문 찍어보기
			int idx = 0;
			pstmt.setInt(++idx, Integer.parseInt(map.get("bcode")));
			if(!key.isEmpty() && !word.isEmpty()) {
				pstmt.setString(++idx, word);
			}
			pstmt.setInt(++idx, Integer.parseInt(map.get("start")));
			pstmt.setInt(++idx, Integer.parseInt(map.get("end")));
			rs = pstmt.executeQuery();
			while(rs.next()) { //있을 수도 있고 없을 수도 있기 때문에
				ReboardDto reboardDto = new ReboardDto();
				reboardDto.setSeq(rs.getInt("seq"));
				reboardDto.setId(rs.getString("id"));
				reboardDto.setName(rs.getString("name"));
				reboardDto.setEmail(rs.getString("email"));
				reboardDto.setSubject(rs.getString("subject"));
				reboardDto.setContent(rs.getString("content"));
				reboardDto.setHit(rs.getInt("hit"));
				reboardDto.setLogtime(rs.getString("logtime"));
				reboardDto.setBcode(rs.getInt("bcode"));
				reboardDto.setRseq(rs.getInt("rseq"));
				reboardDto.setRef(rs.getInt("ref"));
				reboardDto.setLev(rs.getInt("lev"));
				reboardDto.setStep(rs.getInt("step"));
				reboardDto.setPseq(rs.getInt("pseq"));
				reboardDto.setReply(rs.getInt("reply"));
				
				list.add(reboardDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}	
		return list;
	}

	@Override
	public int writeArticle(ReboardDto reboardDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert all \n");
			sql.append("	into board (seq, id, name, email, subject, content, hit, logtime, bcode) \n");
			sql.append("	values (?, ?, ?, ?, ?, ?, 0, sysdate, ?) \n");
			sql.append("	into reboard (rseq, seq, ref, lev, step, pseq, reply) \n");
			sql.append("	values (reboard_seq.nextval, ?, ?, 0, 0, 0, 0) \n");
			sql.append("select * from dual \n");
			pstmt = conn.prepareStatement(sql.toString());			
			int idx = 0;
			pstmt.setInt(++idx, reboardDto.getSeq());
			pstmt.setString(++idx, reboardDto.getId());
			pstmt.setString(++idx, reboardDto.getName());
			pstmt.setString(++idx, reboardDto.getEmail());
			pstmt.setString(++idx, reboardDto.getSubject());
			pstmt.setString(++idx, reboardDto.getContent());
			pstmt.setInt(++idx, reboardDto.getBcode());
			pstmt.setInt(++idx, reboardDto.getSeq());
			pstmt.setInt(++idx, reboardDto.getRef());
			cnt = pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public int replyArticle(ReboardDto reboardDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false); //자동커밋되기 때문에 중간에 에러가 날경우 문제발생!! false로 자동커밋 막기
			
			StringBuilder update_step = new StringBuilder();
			update_step.append("update reboard \n");
			update_step.append("set step = step + 1 \n");
			update_step.append("where ref = ? and step > ?");
			pstmt = conn.prepareStatement(update_step.toString());
			pstmt.setInt(1, reboardDto.getRef());
			pstmt.setInt(2, reboardDto.getStep());
			pstmt.executeUpdate();
			pstmt.close();
			
			StringBuilder insert_reply = new StringBuilder();
			insert_reply.append("insert all \n");
			insert_reply.append("	into board (seq, id, name, email, subject, content, hit, logtime, bcode) \n");
			insert_reply.append("	values (?, ?, ?, ?, ?, ?, 0, sysdate, ?) \n");
			insert_reply.append("	into reboard (rseq, seq, ref, lev, step, pseq, reply) \n");
			insert_reply.append("	values (reboard_seq.nextval, ?, ?, ?, ?, ?, 0) \n");
			insert_reply.append("select * from dual \n");
			pstmt = conn.prepareStatement(insert_reply.toString());			
			int idx = 0;
			pstmt.setInt(++idx, reboardDto.getSeq());
			pstmt.setString(++idx, reboardDto.getId());
			pstmt.setString(++idx, reboardDto.getName());
			pstmt.setString(++idx, reboardDto.getEmail());
			pstmt.setString(++idx, reboardDto.getSubject());
			pstmt.setString(++idx, reboardDto.getContent());
			pstmt.setInt(++idx, reboardDto.getBcode());
			pstmt.setInt(++idx, reboardDto.getSeq());
			pstmt.setInt(++idx, reboardDto.getRef());
			pstmt.setInt(++idx, reboardDto.getLev() + 1);
			pstmt.setInt(++idx, reboardDto.getStep() + 1);
			pstmt.setInt(++idx, reboardDto.getPseq());
			pstmt.executeUpdate();
			pstmt.close();
			
			StringBuilder update_reply = new StringBuilder();
			update_reply.append("update reboard \n");
			update_reply.append("set reply = reply + 1 \n");
			update_reply.append("where seq = ?"); //글번호가 원글의 글번호인 것을 +1 증가
			pstmt = conn.prepareStatement(update_reply.toString());
			pstmt.setInt(1, reboardDto.getPseq());
			pstmt.executeUpdate();
			
			conn.commit();
			cnt = 1; //commit이 error가 나지 않았다!! 성공했을때 1을 return
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				if(conn != null)
					conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBClose.close(conn, pstmt);
		}
		return cnt;
	}

	@Override
	public ReboardDto viewArticle(int seq) {
		ReboardDto reboardDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select b.seq, b.id, b.name, b.email, b.subject, b.content, b.hit, \n");
			sql.append("	b.logtime, b.bcode, r.rseq, r.ref, r.lev, r.step, r.pseq, r.reply \n");
			sql.append("from board b, reboard r\n");
			sql.append("where b.seq = r.seq \n");
			sql.append("and b.seq = ? \n");
			pstmt = conn.prepareStatement(sql.toString());	
//			System.out.println(sql.toString()); //쿼리문 찍어보기
			pstmt.setInt(1,seq);
			rs = pstmt.executeQuery();
			if(rs.next()) { //있을 수도 있고 없을 수도 있기 때문에
				reboardDto = new ReboardDto();
				reboardDto.setSeq(rs.getInt("seq"));
				reboardDto.setId(rs.getString("id"));
				reboardDto.setName(rs.getString("name"));
				reboardDto.setEmail(rs.getString("email"));
				reboardDto.setSubject(rs.getString("subject"));
				reboardDto.setContent(rs.getString("content"));
				reboardDto.setHit(rs.getInt("hit"));
				reboardDto.setLogtime(rs.getString("logtime"));
				reboardDto.setBcode(rs.getInt("bcode"));
				reboardDto.setRseq(rs.getInt("rseq"));
				reboardDto.setRef(rs.getInt("ref"));
				reboardDto.setLev(rs.getInt("lev"));
				reboardDto.setStep(rs.getInt("step"));
				reboardDto.setPseq(rs.getInt("pseq"));
				reboardDto.setReply(rs.getInt("reply"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}		
		return reboardDto;
	}


	@Override
	public int modifyArticle(ReboardDto reboardDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update board \n");
			sql.append("set subject = ?, content = ? \n");
			sql.append("where seq = ? \n");
			pstmt = conn.prepareStatement(sql.toString());			
			int idx = 0;
			pstmt.setString(++idx, reboardDto.getSubject());
			pstmt.setString(++idx, reboardDto.getContent());
			pstmt.setInt(++idx, reboardDto.getSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return 0;
	}

//reboard랑 board 둘 다 지워지려면 트랜잭션 처리
	@Override
	public void deleteArticle(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false); //자동커밋되기 때문에 중간에 에러가 날경우 문제발생!! false로 자동커밋 막기
			StringBuilder reboardsql = new StringBuilder();
			reboardsql.append("delete from reBoard \n");
			reboardsql.append("where seq = ? \n");
			pstmt = conn.prepareStatement(reboardsql.toString());
			pstmt.setInt(1, seq);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			
			StringBuilder boardsql = new StringBuilder();
			boardsql.append("delete from Board \n");
			boardsql.append("where seq = ? \n");
			pstmt = conn.prepareStatement(boardsql.toString());
			pstmt.setInt(1, seq);
			
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
	}

}
