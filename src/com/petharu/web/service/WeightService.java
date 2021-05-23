package com.petharu.web.service;

import java.util.List;

import com.petharu.web.entity.Weight;

public interface WeightService {
	List<Weight> getList();
	int insert(Weight weight);
	Weight get(int id);
	int update(Weight weight);
	
}
