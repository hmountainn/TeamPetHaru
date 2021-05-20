package com.petharu.web.entity;

import java.util.Date;

public class KnowhowComment {
	private int id;
	private String content;
	private Date regDate;
	private int member_id;
	private int knowhow_id;
	
	public KnowhowComment() {
		// TODO Auto-generated constructor stub
	}

	public KnowhowComment(int id, String content, Date regDate, int member_id, int knowhow_id) {
		super();
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.member_id = member_id;
		this.knowhow_id = knowhow_id;
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

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getKnowhow_id() {
		return knowhow_id;
	}

	public void setKnowhow_id(int knowhow_id) {
		this.knowhow_id = knowhow_id;
	}

	@Override
	public String toString() {
		return "KnowhowComment [id=" + id + ", content=" + content + ", regDate=" + regDate + ", member_id=" + member_id
				+ ", knowhow_id=" + knowhow_id + "]";
	}
	
	
	
	
}
