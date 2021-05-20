package com.petharu.web.service;

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
