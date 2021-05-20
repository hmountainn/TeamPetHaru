package com.petharu.web.entity;

import java.sql.Date;

public class Diary {

	private int id;
	private int memberId;
	private String keyword;
	private String content;
	private Date regDate;
	
	public Diary() {
		// TODO Auto-generated constructor stub
	}

	public Diary(int id, int memberId, String keyword, String content, Date regDate) {
		super();
		this.id = id;
		this.memberId = memberId;
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

	public void setMebmerId(int memberId) {
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Diary [id=" + id + ", memberId=" + memberId + ", keyword=" + keyword + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}
	
}
