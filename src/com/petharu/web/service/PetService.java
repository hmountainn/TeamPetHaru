package com.petharu.web.service;

import java.sql.SQLException;
import java.util.List;

import com.petharu.web.entity.Pet;

public interface PetService {
	
	public List<Pet> getPetList(int memberId);
	
	Pet get(int id);

	int updatePetProfile(Pet pet);
	int deletePetProfile(int id);
	int insertPetProfile(Pet pet);
	


}
