package com.petharu.web.service;

import java.util.List;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.Friend;

public interface MyhomeService {

	List<Diary> getList();
	List<Diary> getList(int id, int page);
	
	List<Friend> getFollowerList(int id);
	List<Friend> getFollowList(int id);
	
	int getFollowerCount(int id);
	int getFollowCount(int id);
}
