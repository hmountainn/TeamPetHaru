package com.petharu.web.entity;

import java.util.Date;

public class Notice {

	private int id;
	private String title;
	private String adminUserId;
	private Date regDate;
	private int hit;
	private String content;
	private String files;
	
	public Notice() {
		
	}

	public Notice(int id, String title, String adminUserId, Date regDate, int hit, String content, String files) {
		super();
		this.id = id;
		this.title = title;
		this.adminUserId = adminUserId;
		this.regDate = regDate;
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

	public String getAdminUserId() {
		return adminUserId;
	}

	public void setAdminUserId(String adminUserId) {
		this.adminUserId = adminUserId;
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
				+ "\", \"adminUserId\":\"" + adminUserId
				+ "\", \"regDate\":\"" + regDate
				+ "\", \"hit\":" + hit
				+ ", \"content\":\"" + content
				+ "\", \"files\":\"" + files + "\"}";
	}

	
	
}
