package com.petharu.web.entity;

import java.util.Date;

public class Influence {
	private int id;
	private int memberId;
	private String userId;
	private String keyword;
	private String content;
	private Date regDate;
	
	public Influence() {
		
	}
	
	

	public Influence(int id, int memberId, String userId, String keyword, String content, Date regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.userId = userId;
		this.keyword = keyword;
		this.content = content;
		this.regDate = regDate;
	}
 


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Influence [id=" + id + ", memberId=" + memberId + ", userId=" + userId + ", keyword=" + keyword
				+ ", content=" + content + ", regDate=" + regDate + "]";
	}

	
	
	
}
