package com.petharu.web.entity;

import java.util.Date;

public class Notice {

	private int id;
	private String title;
	private int adminId;
	private Date regDate;
	private int hit;
	private String content;
	private String files;
	
	public Notice() {
		
	}

	public Notice(int id, String title, int adminId, Date regDate, int hit, String content, String files) {
		super();
		this.id = id;
		this.title = title;
		this.adminId = adminId;
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

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
				+ "\", \"adminId\":" + adminId
				+ ", \"regDate\":\"" + regDate
				+ "\", \"hit\":" + hit
				+ ", \"content\":\"" + content
				+ "\", \"files\":\"" + files + "\"}";
	}

	
	
}
