package com.petharu.web.service;

import java.sql.SQLException;
import java.util.List;

import com.petharu.web.entity.Breed;
import com.petharu.web.entity.Pet;

public interface BreedService {
	List<Breed> getBreedList()throws ClassNotFoundException, SQLException;
	List<Breed> getBreedList(int memberId)throws ClassNotFoundException, SQLException;

}
