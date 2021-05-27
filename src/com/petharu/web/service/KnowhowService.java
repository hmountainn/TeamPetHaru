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
import com.petharu.web.entity.KnowhowView;

public interface KnowhowService {

	List<KnowhowView> getViewList() throws ClassNotFoundException, SQLException;
	List<KnowhowView> getViewList(int page, String pet) throws ClassNotFoundException, SQLException;
	
	KnowhowView get(int id) throws ClassNotFoundException, SQLException;
	int insert(Knowhow knowhow) throws ClassNotFoundException, SQLException;
	int update(KnowhowView knowhow) throws ClassNotFoundException, SQLException;
	int delete(int id) throws ClassNotFoundException, SQLException;
	
	int hitUp(Knowhow knowhow);
	
}
