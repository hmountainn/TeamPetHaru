package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.DiaryComment;
import com.petharu.web.entity.Friend;
import com.petharu.web.entity.Pet;

public class JdbcFriendService implements FriendService {
	
	public List<Diary> getFriendDiaryList() throws ClassNotFoundException, SQLException{
		return getFriendDiaryList(1);		
	}
	public List<Diary> getFriendDiaryList(int memberId) throws ClassNotFoundException, SQLException{
		List<Diary> list = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT D.*,M.USER_ID FROM DIARY D "
				+ "LEFT JOIN MEMBER M ON M.ID = D.MEMBER_ID WHERE MEMBER_ID = "+memberId;
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String keyword = rs.getString("keyword");
			String content = rs.getString("content");
			java.sql.Date regDate = rs.getDate("regdate");
			String userId = rs.getString("user_id");
			
			Diary diary = new Diary();
			diary.setId(id);
			diary.setKeyword(keyword);
			diary.setContent(content);
			diary.setRegDate(regDate);
			diary.setUserId(userId);

			
			list.add(diary);
			
			
		}
		rs.close();
		st.close();
		con.close();
		
		return list;
		
	}
	
	public List<DiaryComment> getFriendDiaryCommentList(int diaryId) throws ClassNotFoundException, SQLException{
		List<DiaryComment> list = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT DIARY_COMMENT.*,MEMBER.USER_ID FROM DIARY_COMMENT LEFT JOIN MEMBER ON MEMBER.ID = diary_comment.member_id WHERE DIARY_ID="+diaryId;
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String content = rs.getString("content");
			java.sql.Date regDate = rs.getDate("regdate");
			String userId = rs.getString("user_id");
			
			DiaryComment diary = new DiaryComment();
			diary.setId(id);
			diary.setContent(content);
			diary.setRegdate(regDate);
			diary.setUserId(userId);

			
			list.add(diary);
			
			
		}
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	public List<Friend> getFollowerCount() throws ClassNotFoundException, SQLException{
		return null;
		
	}
	public List<Friend> getFollowingCount() throws ClassNotFoundException, SQLException{
		return null;
		
	}
	public List<Friend> getRequestCount() throws ClassNotFoundException, SQLException{
		return null;
		
	}
	@Override
	public List<Diary> getFriendDiaryCommentList() {
		// TODO Auto-generated method stub
		return null;
	}
}
