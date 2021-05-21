package com.petharu.web.entity;

public class DiaryLike {

	private int memberId;
	private int diaryId;
	
	public DiaryLike() {

	}

	public DiaryLike(int memberId, int diaryId) {
		this.memberId = memberId;
		this.diaryId = diaryId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getDiaryId() {
		return diaryId;
	}

	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}

	@Override
	public String toString() {
		return "DiaryLike [memberId=" + memberId + ", diaryId=" + diaryId + "]";
	}

}
