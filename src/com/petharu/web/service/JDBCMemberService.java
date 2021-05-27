package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.petharu.web.entity.Member;

public class JDBCMemberService implements MemberService {
	
	@Override
	public String getPwd(String userId) {
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT PASSWORD FROM MEMBER WHERE USER_ID = "+"'"+userId+"'";
		String password="";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url,"PETHARU","1357"); 
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				password = rs.getString("password");
				
			
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return password;
	}
	@Override
	public Member get(String userId) {
		Member member = new Member();
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER WHERE USER_ID = "+"'"+userId+"'";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url,"PETHARU","1357"); 
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				String password = rs.getString("password");
				
				member.setId(id);
				member.setEmail(email);
				member.setPassword(password);
			
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return member;
	}

	@Override
	public int insert(Member member) {
		int result = 0;
		String sql = "INSERT INTO MEMBER (USER_ID,EMAIL,PASSWORD) VALUES(?,?,?)";			
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Connection con;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			con = DriverManager.getConnection(url,"PETHARU","1357");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,member.getUserId());
			st.setString(2,member.getEmail());
			st.setString(3, member.getPassword());
			result = st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
		
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
