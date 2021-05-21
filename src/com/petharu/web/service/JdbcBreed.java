package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.petharu.web.entity.Breed;
import com.petharu.web.entity.Pet;

public class JdbcBreed {
	public List<Breed> getBreedList()throws ClassNotFoundException, SQLException{
		
		return getBreedList(1);
		
	}

	public List<Breed> getBreedList(int memberId)throws ClassNotFoundException, SQLException{
		List<Breed> list = new ArrayList<>();
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM BREED";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			
			Breed breed = new Breed();
			breed.setId(id);
			breed.setName(name);

			list.add(breed);
			
			
		}
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
}
