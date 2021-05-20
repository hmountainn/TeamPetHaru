package com.petharu.web.entity;

import java.util.Date;


public class Notice {

	private int id;
	private String title;
	private String userId;
	private int adminId;
	private Date regdate;
	private int hit;
	private String content;
	private String files;
	
	public Notice() {
		
	}

	public Notice(int id, String title, int adminId, String userId, Date regdate, int hit, String content, String files) {
		super();
		this.id = id;
		this.title = title;
		this.adminId = adminId;
		this.userId = userId;
		this.regdate = regdate;
		this.hit = hit;
		this.content = content;
		this.files = files;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id
				+ ", \"title\":\"" + title
				+ "\", \"adminId\":" + adminId
				+ "\", \"userId\":" + userId
				+ ", \"regdate\":\"" + regdate
				+ "\", \"hit\":" + hit
				+ ", \"content\":\"" + content
				+ "\", \"files\":\"" + files + "\"}";
	}

	
	
}
