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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Schedule get(int scheduleId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int insert(Schedule schedule) throws SQLException, ClassNotFoundException {
		int result = 0;
		String sql = "INSERT INTO SCHEDULE (MEMBER_ID,TITLE,CONTENT,DATETIME) VALUES(?,?,?,?)";			
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver"); 
		Connection con = DriverManager.getConnection(url,"PETHARU","1357"); 
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, schedule.getMemberId());//첫번째물음표에 notice.gettitle()꽂음
		st.setString(2, schedule.getTitle());
		st.setString(3, schedule.getContent()); 
		st.setString(4,schedule.getDateTime());
		
		result = st.executeUpdate(); //executeQuery() : select문, executeUpdate():update/delete/insert
		st.close();
		con.close();
		return result;
	}

}
