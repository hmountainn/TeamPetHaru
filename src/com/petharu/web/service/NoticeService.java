package com.petharu.web.service;

import java.sql.SQLException;
import java.util.List;

import com.petharu.web.entity.Notice;

public interface NoticeService {
	
	List<Notice> getList();
	List<Notice> getList(int page, String field, String query, String sort, int size);

	int getCount(String field, String query);
	Notice get(int id);
	int delete(int id);
	int insert(Notice notice);
	int update(Notice notice);
	int hitUp(Notice notice);

}
