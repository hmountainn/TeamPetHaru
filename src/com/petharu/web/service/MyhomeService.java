package com.petharu.web.service;

<<<<<<< HEAD
import java.util.List;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.Friend;

public interface MyhomeService {

	List<Diary> getList();
	List<Diary> getList(int memberId, int page);
	
	List<Friend> getFollowerList(int memberId);
	List<Friend> getFollowList(int memberId);
	
	int getFollowerCount(int memberId);
	int getFollowCount(int memberId);
}
=======
import java.sql.SQLException;
import java.util.List;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.Friend;

public interface MyhomeService {

	List<Diary> getList() throws ClassNotFoundException, SQLException;
	List<Diary> getList(int memberId, int page) throws ClassNotFoundException, SQLException;
	
	List<Friend> getFollowerList(int memberId) throws ClassNotFoundException, SQLException;
	List<Friend> getFollowList(int memberId) throws ClassNotFoundException, SQLException;
	
	int getFollowerCount(int memberId);
	int getFollowCount(int memberId);
}
>>>>>>> refs/remotes/origin/master
