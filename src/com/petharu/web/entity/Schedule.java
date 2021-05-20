package com.petharu.web.entity;

import java.util.Date;

public class Schedule {
	private int id;
	private String userId;
	private String title;
	private String content;
	private String type;
	private Date dateTime;
	
	public Schedule() {	
	}
	

	public Schedule(int id, String userId, String title, String content, String type, Date dateTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.type = type;
		this.dateTime = dateTime;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	

}
