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
import com.petharu.web.entity.Schedule;

public class JDBCScheduleService implements ScheduleService {

	@Override
	public List<Schedule> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule> getList(int month, int memberId) {
		List<Schedule> list = new ArrayList<>();
		String monthString = String.format("%02d", month);
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM (   "
				+ "        SELECT * "
				+ "		FROM SCHEDULE"
				+ "        ORDER BY DATETIME ASC)			"
				+ "WHERE (REGEXP_LIKE(DATETIME, '\\d{4}-"+monthString+"-\\d{2}T\\d{2}:\\d{2}')) AND (MEMBER_ID = "+memberId+")";
			
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url,"PETHARU","1357"); //안에서 new해서 반환해줌		
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql); //쿼리 실행
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String scheduleTypeName = rs.getString("schedule_type_name");
				String dateTime = rs.getString("datetime");
				Schedule schedule = new Schedule();
				schedule.setId(id);
				schedule.setMemberId(memberId);
				schedule.setTitle(title);
				schedule.setContent(content);
				schedule.setScheduleTypeName(scheduleTypeName);
				schedule.setDateTime(dateTime);
				list.add(schedule);	
				
			}
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Schedule get(int scheduleId) {
		Schedule schedule = new Schedule();
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM SCHEDULE WHERE ID = "+scheduleId;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url,"PETHARU","1357"); 
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				int memberId = rs.getInt("member_id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String scheduleTypeName = rs.getString("schedule_type_name");
				String dateTime = rs.getString("datetime");
				
				schedule.setId(scheduleId);
				schedule.setMemberId(memberId);
				schedule.setTitle(title);
				schedule.setContent(content);
				schedule.setScheduleTypeName(scheduleTypeName);
				schedule.setDateTime(dateTime);
				
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
		
		return schedule;			
		
	}
	
	@Override
	public int insert(Schedule schedule) throws SQLException, ClassNotFoundException {
		int result = 0;
		String sql = "INSERT INTO SCHEDULE (MEMBER_ID,TITLE,CONTENT,SCHEDULE_TYPE_NAME,DATETIME) VALUES(?,?,?,?,?)";			
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url,"PETHARU","1357"); 
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, schedule.getMemberId());
		st.setString(2, schedule.getTitle());
		st.setString(3, schedule.getContent()); 
		st.setString(4,schedule.getScheduleTypeName());
		st.setString(5,schedule.getDateTime());
		
		result = st.executeUpdate(); //executeQuery() : select문, executeUpdate():update/delete/insert
		st.close();
		con.close();
		return result;
	}
	
	@Override
	public int update(Schedule schedule) {
		int result = 0;
		String sql = "UPDATE SCHEDULE SET MEMBER_ID=?,TITLE=?,CONTENT=?,SCHEDULE_TYPE_NAME=?,DATETIME=? WHERE ID=?";			
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url,"PETHARU","1357"); 
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, schedule.getMemberId());
			st.setString(2, schedule.getTitle());
			st.setString(3, schedule.getContent()); 
			st.setString(4,schedule.getScheduleTypeName());
			st.setString(5,schedule.getDateTime());
			st.setInt(6, schedule.getId());
			result = st.executeUpdate(); //executeQuery() : select문, executeUpdate():update/delete/insert
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return result;
	}
	
	@Override
	public int delete(int scheduleId) {
		int result = 0;
		String sql = "DELETE FROM SCHEDULE WHERE ID=?";			
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url,"PETHARU","1357"); 
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, scheduleId);
			
			result = st.executeUpdate(); //executeQuery() : select문, executeUpdate():update/delete/insert
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return result;
		
	}

}
