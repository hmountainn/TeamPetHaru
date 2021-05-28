package com.petharu.web.service;

import java.sql.SQLException;
import java.util.List;

import com.petharu.web.entity.Diary;
import com.petharu.web.entity.DiaryComment;
import com.petharu.web.entity.Friend;
import com.petharu.web.entity.FriendDiaryView;
import com.petharu.web.entity.Member;
import com.petharu.web.entity.Pet;

public interface FriendService {
	
	//친구다이어리
	List<FriendDiaryView> getFriendDiaryList(int memberId)throws ClassNotFoundException, SQLException;
	//친구다이어리 댓글
	List<DiaryComment> getFriendDiaryCommentList()throws ClassNotFoundException, SQLException;
	//팔로워수
	int getFollowerCount(int memberId) throws ClassNotFoundException, SQLException;
	//팔로워목록
	List<Friend> getFollowerList(int memberId) throws ClassNotFoundException, SQLException;
	//팔로잉수
	int getFollowingCount(int memberId)throws ClassNotFoundException, SQLException;
	//팔로잉목록
	List<Friend> getFollowingList(int mebmerId) throws ClassNotFoundException, SQLException;
	List<Friend> getRequestCount()throws ClassNotFoundException, SQLException;
	List<Member> getMemberList(String query)throws ClassNotFoundException, SQLException;
	

}
