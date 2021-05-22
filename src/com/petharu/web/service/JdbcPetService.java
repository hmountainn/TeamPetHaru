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

public class JdbcPetService implements PetService {

	public List<Pet> getPetList(int memberId) {
		List<Pet> list = new ArrayList<>();
		memberId = 1;
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT P.*,B.NAME BREED,TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(BIRTHDAY, 'YYYY')+1 AGE FROM PET P LEFT JOIN BREED B ON B.ID = p.breed_id WHERE MEMBER_ID = "+ memberId;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

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
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int updatePetProfile(Pet pet) {

		int result = 0;

		String sql = "UPDATE PET SET NAME=?, GENDER=?, BIRTHDAY=?, PERSONALITY=? ";

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, pet.getName());
			st.setString(2, pet.getGender());
			st.setString(3, pet.getBirthday());
			st.setString(4, pet.getPersonality());
			
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deletePetProfile(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertPetProfile(Pet pet) throws SQLException, ClassNotFoundException {
		int result = 0;

		String sql = "INSERT INTO PET(NAME,GENDER,BIRTHDAY,PERSONALITY) VALUES(?,?,?,?)";

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, pet.getName());
		System.out.println(pet.getName());
		st.setString(2, pet.getGender());
		st.setString(3, pet.getBirthday());
		st.setString(4, pet.getPersonality());
		
		result = st.executeUpdate();//sql�������� ex.executeQuery(sql):Select, ex, Update:
		
		st.close();
		con.close();
		
		return result;
	}

}
