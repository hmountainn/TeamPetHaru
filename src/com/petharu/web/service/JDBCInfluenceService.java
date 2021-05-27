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
import com.petharu.web.entity.Influence;

public class JDBCInfluenceService {
	public List<Influence> getList(){
		List<Influence> list = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM DIARY,MEMBER WHERE MEMBER.ID = DIARY.MEMBER_ID";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357"); //¿¬°á
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int diaryId = rs.getInt("ID"); 
				int memberId = rs.getInt("MEMBER_ID");
				String userId = rs.getString("USER_ID");
				String keyword = rs.getString("KEYWORD");
				String content = rs.getString("CONTENT");
				Date regDate = rs.getDate("REGDATE");
				
				Influence influence = new Influence();
				influence.setId(diaryId); 
				influence.setMemberId(memberId);
				influence.setUserId(userId);
				influence.setKeyword(keyword);
				influence.setContent(content);
				influence.setRegDate(regDate);
				
				list.add(influence);
			}
			rs.close();
			st.close();
		}catch (Exception e) {
			throw new ServiceException();
		}
		
		return list;
	}
	
	public List<DiaryComment> getCommentList(int diaryId){
		List<DiaryComment> list = new ArrayList<>();
		
		String sql = "SELECT * FROM DIARY_COMMENT_VIEW WHERE DIARY_ID = ?";
		
		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, diaryId);
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String comment = rs.getString("CONTENT");
				String userId = rs.getString("USER_ID");
				
				DiaryComment dcomment = new DiaryComment();
				dcomment.setContent(comment);
				dcomment.setUserId(userId);
				
				list.add(dcomment);
			}
			
			
			st.close();
			con.close();
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		
		return list;
	}
	
	
	
	public int insert(DiaryComment dcomment) {
		int result = 0;
		
		String sql = "INSERT INTO DIARY_COMMENT(CONTENT, MEMBER_ID, DIARY_ID) VALUES(?, ?, ?)";
		
		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			System.out.println(dcomment.getContent());
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, dcomment.getContent());
			st.setInt(2, dcomment.getMemberId());
			st.setInt(3, dcomment.getDiaryId());
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		
		return result;
	}
	
	
}
