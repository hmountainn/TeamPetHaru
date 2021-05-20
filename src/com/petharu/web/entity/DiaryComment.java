package com.petharu.web.entity;

import java.util.Date;

public class DiaryComment {

	private int id;
	private String content;
	private Date regDate;
	private int memberId;
	private int diaryId;
	
	public DiaryComment() {
		// TODO Auto-generated constructor stub
	}

	public DiaryComment(int id, String content, Date regDate, int memberId, int diaryId) {
		super();
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.memberId = memberId;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
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
				+ "\", \"regDate\":\"" + regDate
				+ "\", \"memberId\":" + memberId
				+ ", \"diaryId\":" + diaryId + "}";
	}
	
}
