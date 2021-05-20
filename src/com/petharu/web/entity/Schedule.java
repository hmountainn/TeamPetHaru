package com.petharu.web.entity;

import java.sql.Time;
import java.util.Date;
//Ä¿¹Ô¿¬½À
public class Schedule {
	private int id;
	private String memberId;
	private String title;
	private String content;
	private String scheduleTypeName;
	private Date registeredDate;
	private Time registeredTime;
	
	public Schedule() {	
	}
	
	

	public Schedule(int id, String memberId, String title, String content, String scheduleTypeName, Date registeredDate,
			Time registeredTime) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.title = title;
		this.content = content;
		this.scheduleTypeName = scheduleTypeName;
		this.registeredDate = registeredDate;
		this.registeredTime = registeredTime;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
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

	public String getscheduleTypeName() {
		return scheduleTypeName;
	}

	public void setscheduleTypeName(String scheduleTypeName) {
		this.scheduleTypeName = scheduleTypeName;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Time getRegisteredTime() {
		return registeredTime;
	}

	public void setRegisteredTime(Time registeredTime) {
		this.registeredTime = registeredTime;
	}

	

}
