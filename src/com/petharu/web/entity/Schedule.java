package com.petharu.web.entity;

import java.sql.Time;
import java.util.Date;
//Ä¿¹Ô¿¬½À
public class Schedule {
	private int id;
	private int memberId;
	private String title;
	private String content;
	private String scheduleTypeName;
	private String dateTime;
	
	public Schedule() {	
	}

	public Schedule(int id, int memberId, String title, String content, String scheduleTypeName, String dateTime) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.title = title;
		this.content = content;
		this.scheduleTypeName = scheduleTypeName;
		this.dateTime = dateTime;
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

	public String getScheduleTypeName() {
		return scheduleTypeName;
	}

	public void setScheduleTypeName(String scheduleTypeName) {
		this.scheduleTypeName = scheduleTypeName;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", memberId=" + memberId + ", title=" + title + ", content=" + content
				+ ", scheduleTypeName=" + scheduleTypeName + ", dateTime=" + dateTime + "]";
	}
	
	

	

	

}
