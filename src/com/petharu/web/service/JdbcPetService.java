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

import com.petharu.web.entity.Notice;
import com.petharu.web.entity.Pet;

public class JdbcPetService implements PetService {

	public List<Pet> getPetList(int memberId) {
		List<Pet> list = new ArrayList<>();
		memberId = 1;
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT P.*,B.NAME BREED,TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(BIRTHDAY, 'YYYY')+1 AGE "
		+"FROM PET P LEFT JOIN BREED B ON B.ID = p.breed_id WHERE MEMBER_ID = "+ memberId
		+" ORDER BY P.ID";

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
				String personality = rs.getString("personality");
				String breed = rs.getString("breed");
				int breedid = rs.getInt("breed_id");

				Pet pet = new Pet();
				pet.setId(id);
				pet.setName(name);
				pet.setGender(gender);
				pet.setAge(age);
				pet.setPersonality(personality);
				pet.setBreed(breed);
				pet.setBreedId(breedid);

				list.add(pet);

			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			throw new ServiceException();
		}

		return list;

	}
	
	@Override
	public Pet get(int id) {
//		String sql = String.format("SELECT * FROM PET WHERE PET.ID=%d", id);
		String sql = String.format("SELECT P.*,B.NAME BREED,TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(BIRTHDAY, 'YYYY')+1 AGE FROM PET P LEFT JOIN BREED B ON B.ID = p.breed_id WHERE P.ID =%d", id);
		
		try {

			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			rs.next();
	
			String name = rs.getString("name");
			String gender = rs.getString("gender");
//			String breed = rs.getString("breed");
			String birthday = rs.getString("birthday");
			String personality = rs.getString("personality");
			int age = rs.getInt("age");
	
			
			Pet pet = new Pet();
			pet.setName(name);
			pet.setGender(gender);
//			pet.setBreed(breed);
			pet.setBirthday(birthday);
			pet.setPersonality(personality);
			pet.setAge(age);
//			pet.setMemberId(memberId);
//			pet.setBreedId(breedId);			
			
			rs.close();
			st.close();
			con.close();
			
			return pet;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException();
		}
	}


	@Override
	public int deletePetProfile(int id) {

		int result = 0;
		
		String sql = "DELETE FROM PET WHERE ID=?";
		
		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		return result;
	}


	
	@Override
	public int insertPetProfile(Pet pet){
		int result = 0;
		System.out.println(pet);
									//멤버아이디수정할것
		String sql = "INSERT INTO PET(NAME,GENDER,BIRTHDAY,PERSONALITY,MEMBER_ID,BREED_ID) "
				+ "VALUES(?,?,?,?,?,?)";
//		String sql = "INSERT INTO PET(NAME,GENDER,BIRTHDAY,PERSONALITY) VALUES(?,?,?,?)";

		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
//			st.setInt(0, pet.getId());
			st.setString(1, pet.getName());
			st.setString(2, pet.getGender());
			st.setString(3, pet.getBirthday());
			st.setString(4, pet.getPersonality());
			st.setInt(5, pet.getMemberId());
			st.setInt(6, pet.getBreedId());
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (Exception e) {
			throw new ServiceException();
		}
		
		return result;
	}

	@Override
	public int updatePetProfile(Pet pet){
		System.out.println("test");
		System.out.println(pet);
		int result = 0;
		
		String sql = "UPDATE PET SET NAME=?, BREED_ID=?, BIRTHDAY=?,GENDER=?, PERSONALITY=? WHERE ID=?";
		
		try {
			String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url, "PETHARU", "1357");
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, pet.getName());
			st.setInt(2, pet.getBreedId());			
			st.setString(3, pet.getBirthday());
			st.setString(4, pet.getGender());
			st.setString(5, pet.getPersonality());
			st.setInt(6, pet.getId());			
			
			result = st.executeUpdate();
			
			st.close();
			
			con.close();
		}catch (Exception e) {
			throw new ServiceException();
		}
		
		return result;
	}
}
