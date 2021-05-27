package com.petharu.web.service;

import java.sql.SQLException;
import java.util.List;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.Friend;

public interface MyhomeService {

	List<Diary> getList() throws ClassNotFoundException, SQLException;
	List<Diary> getList(int memberId, int page) throws ClassNotFoundException, SQLException;
	
	Diary get(int id) throws ClassNotFoundException, SQLException;
	int insert(Diary diary) throws ClassNotFoundException, SQLException;
	int update(Diary diary);
	int delete(int id);
	
	List<Friend> getFollowerList(int memberId) throws ClassNotFoundException, SQLException;
	List<Friend> getFollowList(int memberId) throws ClassNotFoundException, SQLException;
	
	int getFollowerCount(int memberId);
	int getFollowCount(int memberId);
}
