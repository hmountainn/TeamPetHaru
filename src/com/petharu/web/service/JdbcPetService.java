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

		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT P.*,B.NAME BREED,TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(BIRTHDAY, 'YYYY')+1 AGE \r\n"
				+ "FROM PET P \r\n" + "LEFT JOIN BREED B ON B.ID = p.breed_id WHERE MEMBER_ID = " + memberId;

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
	public int updatePetProfile(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePetProfile(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertPetProfile(Pet pet) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

}
