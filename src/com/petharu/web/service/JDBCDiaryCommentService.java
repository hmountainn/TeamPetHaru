package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petharu.web.entity.DiaryComment;
import com.petharu.web.entity.Notice;

public class JDBCDiaryCommentService implements DiaryCommentService {

	@Override
	public List<DiaryComment> getList(int diaryId) {
		
		List<DiaryComment> list = new ArrayList<>();
		
		String sql = String.format("SELECT *"
				+ "    FROM DIARY_COMMENT_VIEW"
				+ "    WHERE DIARY_ID=%d"
				+ "    ORDER BY REGDATE", diaryId);
		
		try {
			
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String content = rs.getString("content");
				Date regdate = rs.getDate("regdate");
				int memberId = rs.getInt("member_id");
				String userId = rs.getString("user_id");
				
				DiaryComment diaryComment = new DiaryComment();
				diaryComment.setId(id);
				diaryComment.setContent(content);
				diaryComment.setRegdate(regdate);
				diaryComment.setMemberId(memberId);
				diaryComment.setDiaryId(diaryId);
				diaryComment.setUserId(userId);
				
				list.add(diaryComment);
			}
			
			rs.close();
			st.close();
			con.close();
		
			return list;
			
		} catch(Exception e) {
			throw new ServiceException();
		}

	};

	@Override
	public DiaryComment get(int id) {
		
		String sql = String.format("SELECT * FROM DIARY_COMMENT_VIEW DC WHERE DC.ID=%d", id);
		
		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			rs.next();

			String content = rs.getString("content");
			Date regdate = rs.getDate("regdate");
			int memberId = rs.getInt("member_id");
			String userId = rs.getString("user_id");
			int diaryId = rs.getInt("diary_id");
			
			DiaryComment diaryComment = new DiaryComment();
			diaryComment.setId(id);
			diaryComment.setContent(content);
			diaryComment.setRegdate(regdate);
			diaryComment.setMemberId(memberId);
			diaryComment.setUserId(userId);
			diaryComment.setDiaryId(diaryId);
			
			rs.close();
			st.close();
			con.close();
			
			return diaryComment;
			
		} catch (Exception e) {
			throw new ServiceException();
		}
	}
	
	@Override
	public int delete(int id) {
		
		int result = 0;
		
		String sql = "DELETE FROM DIARY_COMMENT WHERE ID=?";
		
		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		return result;
	};
	
	@Override
	public int insert(DiaryComment diaryComment) {
		
		int result = 0;
		
		String sql = "INSERT INTO DIARY_COMMENT(CONTENT, MEMBER_ID, DIARY_ID) VALUES(?, ?, ?)";
		
		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, diaryComment.getContent());
			st.setInt(2, diaryComment.getMemberId());
			st.setInt(3, diaryComment.getDiaryId());
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		return result;
	};
	
	@Override
	public int update(DiaryComment diaryComment) {
		
		int result = 0;
		
		String sql = "UPDATE DIARY_COMMENT SET CONTENT=? WHERE ID=?";
		
		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, diaryComment.getContent());
			st.setInt(2, diaryComment.getId());
			result = st.executeUpdate();
			
			st.close();
			con.close();
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		return result;
	};

	@Override
	public int reply(DiaryComment diaryComment) {
		
		int result = 0;
		
		return result;
	}
	
}
