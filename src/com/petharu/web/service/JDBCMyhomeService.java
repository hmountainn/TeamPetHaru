package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.DiaryView;
import com.petharu.web.entity.Friend;
import com.petharu.web.entity.Knowhow;

public class JDBCMyhomeService implements MyhomeService {

	@Override
	public List<DiaryView> getViewList() throws ClassNotFoundException, SQLException {
		
		return getViewList(1, 1);
	}
	
	@Override
	public List<DiaryView> getViewList(int page, int memberId) throws ClassNotFoundException, SQLException {

		List<DiaryView> list = new ArrayList<>();
		int size = 9;
		int startNum = 1 + (page-1) * size;
		int endNum = page * size;

		String sql = "SELECT * FROM ("
				+ "    SELECT ROWNUM NUM, D.* FROM ("
				+ "        SELECT * FROM DIARY_VIEW"
				+ "        ORDER BY REGDATE DESC"
				+ "    ) D"
				+ ") WHERE NUM BETWEEN " + startNum + " AND " + endNum
				+ " AND MEMBER_ID = " + memberId;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		DiaryView diaryView = null;

		while(rs.next()) {
			
			// DiaryView 데이터
			int id = rs.getInt("id");
			// int memberId = rs.getInt("member_id");
			String keyword = rs.getString("keyword");
			String content = rs.getString("content");
			Date regDate = rs.getDate("regDate");
			int likeCount = rs.getInt("like_count");
			int commentCount = rs.getInt("comment_count");
			String userId = rs.getString("user_id");

			// list에 담아주기
			diaryView = new DiaryView();
			diaryView.setId(id);
			diaryView.setMemberId(memberId);
			diaryView.setKeyword(keyword);
			diaryView.setContent(content);
			diaryView.setRegDate(regDate);
			diaryView.setLikeCount(likeCount);
			diaryView.setCommentCount(commentCount);
			diaryView.setUserId(userId);
			
			list.add(diaryView);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;		
	}
	
	@Override
	public DiaryView get(int id) throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT * FROM DIARY_VIEW WHERE ID = " + id;
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";

		//try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			DiaryView diaryView = null;

			if (rs.next()) {
				// DiaryView 데이터
				int memberId = rs.getInt("member_id");
				String keyword = rs.getString("keyword");
				String content = rs.getString("content");
				Date regDate = rs.getDate("regDate");
				int likeCount = rs.getInt("like_count");
				int commentCount = rs.getInt("comment_count");
				String userId = rs.getString("user_id");

				// list에 담아주기
				diaryView = new DiaryView();
				diaryView.setId(id);
				diaryView.setMemberId(memberId);
				diaryView.setKeyword(keyword);
				diaryView.setContent(content);
				diaryView.setRegDate(regDate);
				diaryView.setLikeCount(likeCount);
				diaryView.setCommentCount(commentCount);
				diaryView.setUserId(userId);
			}

			rs.close();
			st.close();
			con.close();

			return diaryView;

		//} catch (Exception e) {
		//	throw new ServiceException();
		//}
	}

	@Override
	public int insert(Diary diary) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		  
		String sql = "INSERT INTO DIARY(MEMBER_ID, KEYWORD, CONTENT) VALUES(?, ?, ?)";
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, diary.getMemberId()); 
		st.setString(2, diary.getKeyword());
		st.setString(3, diary.getContent());
		
		result = st.executeUpdate();
		
		st.close(); 
		con.close();
		
		return result; 
	}

	@Override
	public int update(DiaryView diary) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		  
		String sql = "UPDATE DIARY SET MEMBER_ID=?, KEYWORD=?, CONTENT=? WHERE ID=?";
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		  
		//try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, diary.getMemberId());
			st.setString(2, diary.getKeyword());
			st.setString(3, diary.getContent()); 
			st.setInt(4, diary.getId());
			
			result = st.executeUpdate();
			
			st.close(); 
			con.close();
			
			return result;
			
		//} catch (Exception e) {
		//	throw new ServiceException();
		//} 
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		
		int result = 0;

		String sql = "DELETE DIARY WHERE ID=?";
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		
		//try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
			return result;
			
		//} catch (Exception e) {
		//	throw new ServiceException();
		//}
	}
	
	@Override
	public List<Friend> getFollowerList(int memberId) throws ClassNotFoundException, SQLException {
		
		List<Friend> list = new ArrayList<>();

		String sql = "";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while(rs.next()) {
			
			// Friend 데이터
			int requestId = rs.getInt("request_id");

			// list에 담아주기
			Friend friend = new Friend();
			/*
			 * friend.setRequestId(requestId);
			 */			
			list.add(friend);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	@Override
	public List<Friend> getFollowList(int memberId) throws ClassNotFoundException, SQLException {
		
		List<Friend> list = new ArrayList<>();

		String sql = "";
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while(rs.next()) {
			
			// Friend 데이터
			int responseId = rs.getInt("response_id");

			// list에 담아주기
			Friend friend = new Friend();
			/*
			 * friend.setResponseId(responseId);
			 */			
			list.add(friend);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	};

	@Override
	public int getFollowerCount(int memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFollowCount(int memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
