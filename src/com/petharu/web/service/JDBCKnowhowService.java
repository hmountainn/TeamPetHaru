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

public class JDBCKnowhowService implements KnowhowService {

	@Override
	public List<Knowhow> getList() throws ClassNotFoundException, SQLException {

		return getList(1, "");
	}

	@Override
	public List<Knowhow> getList(int page, String pet) throws ClassNotFoundException, SQLException {
		List<Knowhow> list = new ArrayList<>();

		int size = 12;
		int startNum = 1 + (page - 1) * size;
		int endNum = page * size;
		
		String sql = null;
		
		if(!pet.equals("")) {
			sql = "SELECT * FROM (" 
				+ "    SELECT ROWNUM NUM, K.* FROM (" 
				+ "        SELECT * FROM KNOWHOW"
				+ "        ORDER BY REGDATE DESC" 
				+ ") K" 
				+ ") WHERE NUM BETWEEN " + startNum + " AND " + endNum
				+ " AND KNOWHOW_TYPE_NAME = " + pet;	
		}
		
		if(pet.equals("")) {
			sql = "SELECT * FROM (" 
				+ "    SELECT ROWNUM NUM, K.* FROM (" 
				+ "        SELECT * FROM KNOWHOW"
				+ "        ORDER BY REGDATE DESC" 
				+ ") K" 
				+ ") WHERE NUM BETWEEN " + startNum + " AND " + endNum;	
		}

		//try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				// Knowhow 데이터
				int id = rs.getInt("id");
				int memberId = rs.getInt("member_id");
				String knowhowTypeName = rs.getString("knowhow_type_name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date regDate = rs.getDate("regdate");
				int hit = rs.getInt("hit");

				// list에 담아주기
				Knowhow knowhow = new Knowhow();
				knowhow.setId(id);
				knowhow.setMemberId(memberId);
				knowhow.setKnowhowTypeName(knowhowTypeName);
				knowhow.setTitle(title);
				knowhow.setContent(content);
				knowhow.setRegDate(regDate);
				knowhow.setHit(hit);

				list.add(knowhow);
			}

			rs.close();
			st.close();
			con.close();

			return list;
			
		//} catch (Exception e) {
		//	throw new ServiceException();
		//}
		
	}

	@Override
	public Knowhow get(int id) throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM KNOWHOW WHERE ID = " + id;
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";

		//try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			Knowhow knowhow = null;

			if (rs.next()) {

				// Knowhow 데이터
				int memberId = rs.getInt("member_id");
				String knowhowTypeName = rs.getString("knowhow_type_name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date regDate = rs.getDate("regdate");
				int hit = rs.getInt("hit");

				// list에 담아주기
				knowhow = new Knowhow();
				knowhow.setId(id);
				knowhow.setMemberId(memberId);
				knowhow.setKnowhowTypeName(knowhowTypeName);
				knowhow.setTitle(title);
				knowhow.setContent(content);
				knowhow.setRegDate(regDate);
				knowhow.setHit(hit);
			}

			rs.close();
			st.close();
			con.close();

			return knowhow;

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
	public int update(Knowhow knowhow) {
		System.out.println(knowhow);
		
		int result = 0;
		  
		String sql = "UPDATE KNOWHOW SET MEMBER_ID=?, KNOWHOW_TYPE_NAME=?, TITLE=?, CONTENT=? WHERE ID=?";
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		  
		try {
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
			
		} catch (Exception e) {
			throw new ServiceException();
		} 
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
