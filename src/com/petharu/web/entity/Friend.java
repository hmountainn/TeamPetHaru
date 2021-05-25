package com.petharu.web.entity;

import java.util.Date;

public class Friend {

	private int followrId;
	private int memberId;
	private Date requestDate;
	private Date responseDate;
	private String userId;
	private int followerCnt;

	public Friend() {
		// TODO Auto-generated constructor stub
	}

	public Friend(int followrId, int memberId, Date requestDate, Date responseDate, String userId, int followerCnt) {
		super();
		this.followrId = followrId;
		this.memberId = memberId;
		this.requestDate = requestDate;
		this.responseDate = responseDate;
		this.userId = userId;
		this.followerCnt = followerCnt;
	}

	public int getFollowrId() {
		return followrId;
	}

	public void setFollowrId(int followrId) {
		this.followrId = followrId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getFollowerCnt() {
		return followerCnt;
	}

	public void setFollowerCnt(int followerCnt) {
		this.followerCnt = followerCnt;
	}

	@Override
	public String toString() {
		return "Friend [followrId=" + followrId + ", memberId=" + memberId + ", requestDate=" + requestDate
				+ ", responseDate=" + responseDate + ", userId=" + userId + ", followerCnt=" + followerCnt + "]";
	}
	

}
