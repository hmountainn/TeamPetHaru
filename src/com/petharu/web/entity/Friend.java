package com.petharu.web.entity;

import java.util.Date;

public class Friend {

	private int requestId;
	private int responseId;
	private Date requestDate;
	private Date responseDate;
	private String userId;
	
	public Friend() {
		// TODO Auto-generated constructor stub
	}


	public Friend(int requestId, int responseId, Date requestDate, Date responseDate, String userId) {
		super();
		this.requestId = requestId;
		this.responseId = responseId;
		this.requestDate = requestDate;
		this.responseDate = responseDate;
		this.userId = userId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}
	
	

	public String getUserId() {
		return userId;
	}


	public void setUserId(String uerId) {
		this.userId = uerId;
	}





	@Override
	public String toString() {
		return "Friend [requestId=" + requestId + ", responseId=" + responseId + ", requestDate=" + requestDate
				+ ", responseDate=" + responseDate + ", uerId=" + userId + "]";
	}



	
	
}
