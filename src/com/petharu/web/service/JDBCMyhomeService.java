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
import com.petharu.web.entity.Friend;
import com.petharu.web.entity.Knowhow;

public class JDBCMyhomeService implements MyhomeService {

	@Override
	public List<Diary> getList() throws ClassNotFoundException, SQLException {
		
		return getList(1, 1);
	}
	
	@Override
	public List<Diary> getList(int page, int memberId) throws ClassNotFoundException, SQLException {
		
		List<Diary> list = new ArrayList<>();
		int size = 9;
		int startNum = 1 + (page-1) * size;
		int endNum = page * size;

		String sql = "SELECT * FROM ("
				+ "    SELECT ROWNUM NUM, D.* FROM ("
				+ "        SELECT * FROM DIARY"
				+ "        ORDER BY REGDATE DESC"
				+ "    ) D"
				+ ") WHERE NUM BETWEEN " + startNum + " AND " + endNum
				+ " AND MEMBER_ID = " + memberId;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while(rs.next()) {
			
			// Diary 데이터
			int id = rs.getInt("id");
			String keyword = rs.getString("keyword");
			String content = rs.getString("content");
			Date regDate = rs.getDate("regDate");

			// list에 담아주기
			Diary diary = new Diary();
			diary.setId(id);
			diary.setMemberId(memberId);
			diary.setKeyword(keyword);
			diary.setContent(content);
			diary.setRegDate(regDate);
			
			list.add(diary);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;		
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
			friend.setRequestId(requestId);
			
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
			friend.setResponseId(responseId);
			
			list.add(friend);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	};
	
	@Override
	public Diary get(int id) throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT * FROM DIARY WHERE ID = " + id;
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";

		//try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			Diary diary = null;

			if (rs.next()) {

				// Diary 데이터
				int memberId = rs.getInt("member_id");
				String keyword = rs.getString("keyword");
				String content = rs.getString("content");
				Date regDate = rs.getDate("regdate");

				// list에 담아주기
				diary = new Diary();
				diary.setId(id);
				diary.setMemberId(memberId);
				diary.setKeyword(keyword);
				diary.setContent(content);
				diary.setRegDate(regDate);
			}

			rs.close();
			st.close();
			con.close();

			return diary;

		//} catch (Exception e) {
		//	throw new ServiceException();
		//}
	}

	@Override
	public int insert(Diary diary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Diary diary) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Diary diary) {
		// TODO Auto-generated method stub
		return 0;
	}

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
