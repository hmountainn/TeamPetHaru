package com.petharu.web.service;

import java.sql.SQLException;
import java.util.List;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.DiaryView;
import com.petharu.web.entity.Friend;

public interface MyhomeService {

	List<DiaryView> getViewList() throws ClassNotFoundException, SQLException;
	List<DiaryView> getViewList(int memberId, int page) throws ClassNotFoundException, SQLException;
	
	DiaryView get(int id) throws ClassNotFoundException, SQLException;
	int insert(Diary diary) throws ClassNotFoundException, SQLException;
	int update(DiaryView diary) throws ClassNotFoundException, SQLException;
	int delete(int id) throws ClassNotFoundException, SQLException;
		
	List<Friend> getFollowerList(int memberId) throws ClassNotFoundException, SQLException;
	List<Friend> getFollowList(int memberId) throws ClassNotFoundException, SQLException;
	
	int getFollowerCount(int memberId);
	int getFollowCount(int memberId);
}
