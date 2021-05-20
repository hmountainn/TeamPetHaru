package com.petharu.web.entity;

import java.util.Date;

public class Knowhow {

	private int id;
	private int memberId;
	private int knowhowTypeId;
	private String title;
	private String content;
	private Date regDate;
	private int hit;
	
	public Knowhow() {
		
	}

	public Knowhow(int id, int memberId, int knowhowTypeId, String title, String content, Date regDate, int hit) {
		this.id = id;
		this.memberId = memberId;
		this.knowhowTypeId = knowhowTypeId;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
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

	public int getKnowhowTypeId() {
		return knowhowTypeId;
	}

	public void setKnowhowTypeId(int knowhowTypeId) {
		this.knowhowTypeId = knowhowTypeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "Knowhow [id=" + id + ", memberId=" + memberId + ", knowhowTypeId=" + knowhowTypeId + ", title=" + title
				+ ", content=" + content + ", regDate=" + regDate + ", hit=" + hit + "]";
	}
	
}
