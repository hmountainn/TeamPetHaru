package com.petharu.web.service;

import java.util.List;

import com.petharu.web.entity.Friend;
import com.petharu.web.entity.Pet;

public interface FriendService {
	List<Friend> getList();
	List<Friend> getFollowCount();
	List<Friend> getFollowingCount();
	List<Friend> getRequestCount();
	

}
