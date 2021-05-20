package com.petharu.web.entity;

public class KnowhowLike {

	private int memberId;
	private int knowhowId;
	
	public KnowhowLike() {

	}

	public KnowhowLike(int memberId, int knowhowId) {
		this.memberId = memberId;
		this.knowhowId = knowhowId;
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
		return "KnowhowLike [memberId=" + memberId + ", knowhowId=" + knowhowId + "]";
	}
	
}
