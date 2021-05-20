package com.petharu.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.petharu.web.entity.Pet;

public class JDBCPetService {

	public List<Pet> getList() throws ClassNotFoundException, SQLException{
		
		return getList("name","breed",1);
		
	}

	public List<Pet> getList(String n,String b,int i) throws ClassNotFoundException, SQLException {
		List<Pet> list = new ArrayList<>();
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
//		String sql = "SELECT * FROM PET";
		String sql = "SELECT P.*,B.NAME BREED,TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(BIRTHDAY, 'YYYY')+1 AGE FROM PET P LEFT JOIN BREED B ON B.ID = p.breed_id";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			int age = rs.getInt("age");
			String breed = rs.getString("breed");
			String personality = rs.getString("personality");
			
			Pet pet = new Pet();
			pet.setId(id);
			pet.setName(name);
			pet.setGender(gender);
			pet.setAge(age);
			pet.setBreed(breed);
			pet.setPersonality(personality);
			
			list.add(pet);
			
			
		}
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	
	public Pet get(int id) throws ClassNotFoundException, SQLException{
		Pet pet = null;
		
		String sql = "SELECT * FROM MYPET WHERE ID =" + id;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			String name = rs.getString("name");
			String breed = rs.getString("breed");
			String gender = rs.getString("gender");
			String birthday = rs.getString("birthday");
			String personality = rs.getString("personality");
			
			pet = new Pet();
			pet.setName(name);
			pet.setBreed(breed);
			pet.setGender(gender);
			pet.setBirthday(birthday);
			pet.setPersonality(personality);
		}
		rs.close();
		st.close();
		con.close();

		return pet;		
	}

	public int update(Pet pet) throws ClassNotFoundException, SQLException {
		//조회수,공개비공개 등 업데이트경우가 많다.
		int result = 0;

		//모든업데이트 시 하나의 쿼리문이용//데이터꽂을공간에 ?넣기
		//String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=?, HIT=?, FILES=? WHERE ID=?";
		String sql = "UPDATE NOTICE SET id=?, name=?, breed=?, gender=?, birthday=?, personality=?";

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, pet.getId());//순서대로
		st.setString(2, pet.getName());
		st.setString(3, pet.getBreed());
		st.setString(4, pet.getGender());
		st.setString(5,pet.getBirthday());
		st.setString(7, pet.getPersonality());

		
		result = st.executeUpdate();//sql넣지말것 ex.executeQuery(sql):Select, ex, Update:
		
		st.close();
		con.close();
		
		return result;
		
	}
	
}
