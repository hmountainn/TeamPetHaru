package com.petharu.web.service;

import java.util.List;

import com.petharu.web.entity.Notice;


public interface NoticeService {
	
	List<Notice> getList();
	List<Notice> getList(int page);
	List<Notice> getList(int page, String field, String query);

	int getCount(String field, String query);
	Notice get(int id);
}
