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

import com.petharu.web.entity.Knowhow;

public interface KnowhowService {

	List<Knowhow> getList() throws ClassNotFoundException, SQLException;
	List<Knowhow> getList(int page, String pet) throws ClassNotFoundException, SQLException;

	Knowhow get(int id) throws ClassNotFoundException, SQLException;
	int insert(Knowhow knowhow) throws ClassNotFoundException, SQLException;
	int update(Knowhow knowhow);
	int delete(int id);
	
	int hitUp(Knowhow knowhow);
	
}
