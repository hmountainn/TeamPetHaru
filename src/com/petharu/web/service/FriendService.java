package com.petharu.web.service;

import java.sql.SQLException;
import java.util.List;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.DiaryComment;
import com.petharu.web.entity.Friend;
import com.petharu.web.entity.Pet;

public interface FriendService {
	
	List<Diary> getFriendDiaryList(int memberId)throws ClassNotFoundException, SQLException;
	List<DiaryComment> getFriendDiaryCommentList(int diaryId)throws ClassNotFoundException, SQLException;
	
	int getFollowerCount(int memberId) throws ClassNotFoundException, SQLException;
	List<Friend> getFollowerList(int memberId) throws ClassNotFoundException, SQLException;
	
	List<Friend> getFollowingCount()throws ClassNotFoundException, SQLException;
	List<Friend> getRequestCount()throws ClassNotFoundException, SQLException;
	

}
