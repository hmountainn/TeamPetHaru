package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
				int id = rs.getInt("ID");
				int memberId = rs.getInt("MEMBER_ID");
				String userId = rs.getString("USER_ID");
				String keyword = rs.getString("KEYWORD");
				String content = rs.getString("CONTENT");
				Date regDate = rs.getDate("REGDATE");
				
				Influence influence = new Influence();
				influence.setId(id);
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
	
	
}
