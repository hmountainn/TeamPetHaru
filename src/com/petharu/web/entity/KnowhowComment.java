package com.petharu.web.entity;

import java.util.Date;

public class KnowhowComment {
	private int id;
	private String content;
	private Date regDate;
	private int memberId;
	private int knowhowId;
	
	public KnowhowComment() {
		// TODO Auto-generated constructor stub
	}

	public KnowhowComment(int id, String content, Date regDate, int memberId, int knowhowId) {
		super();
		this.id = id;
		this.content = content;
		this.regDate = regDate;
		this.memberId = memberId;
		this.knowhowId = knowhowId;
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

	public int getKnowhowId() {
		return knowhowId;
	}

	public void setKnowhowId(int knowhowId) {
		this.knowhowId = knowhowId;
	}

	@Override
	public String toString() {
		return "KnowhowComment [id=" + id + ", content=" + content + ", regDate=" + regDate + ", memberId=" + memberId
				+ ", knowhow_Id=" + knowhowId + "]";
	}
	
	
	
	
}
