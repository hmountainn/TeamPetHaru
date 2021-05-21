package com.petharu.web.service;

import java.sql.SQLException;
import java.util.List;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.Friend;
import com.petharu.web.entity.Pet;

public interface FriendService {
	
	List<Diary> getFriendDiaryList()throws ClassNotFoundException, SQLException;
	List<Diary> getFriendDiaryCommentList()throws ClassNotFoundException, SQLException;
	List<Friend> getFollowerCount() throws ClassNotFoundException, SQLException;
	List<Friend> getFollowingCount()throws ClassNotFoundException, SQLException;
	List<Friend> getRequestCount()throws ClassNotFoundException, SQLException;
	

}
