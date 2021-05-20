package com.petharu.web.service;

import java.sql.SQLException;
import java.util.List;

import com.petharu.web.entity.Notice;

public interface NoticeService {
	
	List<Notice> getList() throws ClassNotFoundException, SQLException;
	//List<Notice> getList(int page);
	List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException;

	int getCount(String field, String query) throws ClassNotFoundException, SQLException;
	Notice get(int id) throws ClassNotFoundException, SQLException;
	int delete(int id) throws ClassNotFoundException, SQLException;
	int insert(Notice notice) throws ClassNotFoundException, SQLException;
	int update(Notice notice) throws ClassNotFoundException, SQLException;
	
}
