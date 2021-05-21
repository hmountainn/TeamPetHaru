package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.petharu.web.entity.Weight;

public class JDBCWeightService implements WeightService{
	public List<Weight> getList(){
		List<Weight> list = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM WEIGHT";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 생성
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357"); //연결
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("ID");
				int petId = rs.getInt("PET_ID");
				Date measureDate = rs.getDate("MEASURE_DATE");
				Time measureTime = rs.getTime("MEASURE_TIME");
				float kg = rs.getFloat("KG");
				
				Weight weight = new Weight();
				weight.setId(id);
				weight.setPetId(petId);
				weight.setMeasureDate(measureDate);
				weight.setMeasureTime(measureTime);
				weight.setKg(kg);
				
				list.add(weight);
			}
			
			rs.close();
			st.close();
		
		} catch (Exception e) {
			throw new 서비스예외();
		}
		return list;
	}
}
