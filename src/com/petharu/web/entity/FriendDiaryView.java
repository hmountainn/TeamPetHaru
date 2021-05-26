package com.petharu.web.entity;

import java.util.Date;

public class FriendDiaryView {
	
	private String userId;
	private int memberId;
	private String keyword;
	private String content;
	private int followerId;
	private Date regDate;
	
	public FriendDiaryView() {
		// TODO Auto-generated constructor stub
	}

	public FriendDiaryView(String userId, int memberId, String keyword, String content, int followerId, Date regDate) {
		super();
		this.userId = userId;
		this.memberId = memberId;
		this.keyword = keyword;
		this.content = content;
		this.followerId = followerId;
		this.regDate = regDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getFollowerId() {
		return followerId;
	}

	public void setFollowerId(int followerId) {
		this.followerId = followerId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "FriendDiaryView [userId=" + userId + ", memberId=" + memberId + ", keyword=" + keyword + ", content="
				+ content + ", followerId=" + followerId + ", regDate=" + regDate + "]";
	}
	

}
