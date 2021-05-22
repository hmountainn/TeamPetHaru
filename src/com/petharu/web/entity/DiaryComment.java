package com.petharu.web.entity;

import java.util.Date;

public class DiaryComment {

	private int id;
	private String content;
	private Date regdate;
	private int memberId;
	private String userId;
	private int diaryId;
	
	public DiaryComment() {
		// TODO Auto-generated constructor stub
	}

	public DiaryComment(int id, String content, Date regdate, int memberId, String userId, int diaryId) {
		super();
		this.id = id;
		this.content = content;
		this.regdate = regdate;
		this.memberId = memberId;
		this.userId = userId;
		this.diaryId = diaryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getDiaryId() {
		return diaryId;
	}

	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id
				+ ", \"content\":\"" + content
				+ "\", \"regdate\":\"" + regdate
				+ "\", \"memberId\":" + memberId
				+ ", \"diaryId\":" + diaryId + "}";
	}
	
}
