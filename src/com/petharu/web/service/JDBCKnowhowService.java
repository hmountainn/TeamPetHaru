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

import com.petharu.web.entity.Knowhow;
import com.petharu.web.entity.KnowhowView;

public class JDBCKnowhowService implements KnowhowService {

	@Override
	public List<KnowhowView> getViewList() throws ClassNotFoundException, SQLException {

		return getViewList(1, "");
	}

	@Override
	public List<KnowhowView> getViewList(int page, String pet) throws ClassNotFoundException, SQLException {
		List<KnowhowView> list = new ArrayList<>();

		int size = 12;
		int startNum = 1 + (page - 1) * size;
		int endNum = page * size;
		
		String sql = null;

		if(!pet.equals("")) {
			sql = "SELECT * FROM (" 
				+ "    SELECT ROWNUM NUM, K.* FROM (" 
				+ "        SELECT * FROM KNOWHOW_VIEW"
				+ "        ORDER BY REGDATE DESC" 
				+ ") K" 
				+ ") WHERE NUM BETWEEN " + startNum + " AND " + endNum
				+ " AND KNOWHOW_TYPE_NAME = " + pet;	
		}
		
		if(pet.equals("")) {
			sql = "SELECT * FROM (" 
				+ "    SELECT ROWNUM NUM, K.* FROM (" 
				+ "        SELECT * FROM KNOWHOW_VIEW"
				+ "        ORDER BY REGDATE DESC" 
				+ ") K" 
				+ ") WHERE NUM BETWEEN " + startNum + " AND " + endNum;	
		}
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";

		//try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			KnowhowView knowhowView = null;

			while (rs.next()) {
				// KnowhowView 데이터
				int id = rs.getInt("id");
				int memberId = rs.getInt("member_id");
				String knowhowTypeName = rs.getString("knowhow_type_name");
				String title = rs.getString("title");
				Date regDate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				int likeCount = rs.getInt("like_count");
				int commentCount = rs.getInt("comment_count");
				String userId = rs.getString("user_id");
				String content = rs.getString("content");

				// list에 담아주기
				knowhowView = new KnowhowView();
				knowhowView.setId(id);
				knowhowView.setMemberId(memberId);
				knowhowView.setKnowhowTypeName(knowhowTypeName);
				knowhowView.setTitle(title);
				knowhowView.setRegDate(regDate);
				knowhowView.setHit(hit);
				knowhowView.setLikeCount(likeCount);
				knowhowView.setCommentCount(commentCount);
				knowhowView.setUserId(userId);
				knowhowView.setContent(content);
				
				list.add(knowhowView);
			}

			rs.close();
			st.close();
			con.close();

			return list;
	}

	@Override
	public KnowhowView get(int id) throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM KNOWHOW_VIEW WHERE ID = " + id;
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";

		//try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			KnowhowView knowhowView = null;

			if (rs.next()) {

				// KnowhowView 데이터
				int memberId = rs.getInt("member_id");
				String knowhowTypeName = rs.getString("knowhow_type_name");
				String title = rs.getString("title");
				Date regDate = rs.getDate("regdate");
				int hit = rs.getInt("hit");
				int likeCount = rs.getInt("like_count");
				int commentCount = rs.getInt("comment_count");
				String userId = rs.getString("user_id");
				String content = rs.getString("content");

				knowhowView = new KnowhowView();
				knowhowView.setId(id);
				knowhowView.setMemberId(memberId);
				knowhowView.setKnowhowTypeName(knowhowTypeName);
				knowhowView.setTitle(title);
				knowhowView.setRegDate(regDate);
				knowhowView.setHit(hit);
				knowhowView.setLikeCount(likeCount);
				knowhowView.setCommentCount(commentCount);
				knowhowView.setUserId(userId);
				knowhowView.setContent(content);
			}

			rs.close();
			st.close();
			con.close();

			return knowhowView;

		//} catch (Exception e) {
		//	throw new ServiceException();
		//}
	}

	@Override
	public int insert(Knowhow knowhow) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		  
		String sql = "INSERT INTO KNOWHOW(MEMBER_ID, KNOWHOW_TYPE_NAME, TITLE, CONTENT) VALUES(?, ?, ?, ?)";
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		
		//try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, knowhow.getMemberId()); 
			st.setString(2, knowhow.getKnowhowTypeName());
			st.setString(3, knowhow.getTitle()); 
			st.setString(4, knowhow.getContent());
			
			result = st.executeUpdate();
			
			st.close(); 
			con.close();
			
			return result; 
			
		//} catch (Exception e) {
		//	throw new ServiceException();
		//} 
			
	}
	
	@Override
	public int update(Knowhow knowhow) throws ClassNotFoundException, SQLException {
		System.out.println(knowhow);
		
		int result = 0;
		  
		String sql = "UPDATE KNOWHOW SET MEMBER_ID=?, KNOWHOW_TYPE_NAME=?, TITLE=?, CONTENT=? WHERE ID=?";
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		  
		//try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, knowhow.getMemberId());
			st.setString(2, knowhow.getKnowhowTypeName());
			st.setString(3, knowhow.getTitle()); 
			st.setString(4, knowhow.getContent());
			st.setInt(5, knowhow.getId());
			
			result = st.executeUpdate();
			
			st.close(); 
			con.close();
			
			return result;
			
		//} catch (Exception e) {
		//	throw new ServiceException();
		//} 
	}
	
	@Override
	public int delete(int id) {
		
		int result = 0;

		String sql = "DELETE KNOWHOW WHERE ID=?";
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
			return result;
			
		} catch (Exception e) {
			throw new ServiceException();
		}
	}

	@Override
	public int hitUp(Knowhow knowhow) {
		// TODO Auto-generated method stub
		return 0;
	}

}
