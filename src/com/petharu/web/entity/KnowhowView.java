package com.petharu.web.entity;

import java.util.Date;

public class KnowhowView {

	private int id;
	private int memberId;
	private String knowhowTypeName;
	private String title;
	private Date regDate;
	private int hit;
	private int likeCount;
	private int commentCount;
	private String userId;
	private String content;
	
	public KnowhowView() {
		
	}

	public KnowhowView(int id, int memberId, String knowhowTypeName, String title, Date regDate, int hit, int likeCount,
			int commentCount, String userId, String content) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.knowhowTypeName = knowhowTypeName;
		this.title = title;
		this.regDate = regDate;
		this.hit = hit;
		this.likeCount = likeCount;
		this.commentCount = commentCount;
		this.userId = userId;
		this.content = content;
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

	public String getKnowhowTypeName() {
		return knowhowTypeName;
	}

	public void setKnowhowTypeName(String knowhowTypeName) {
		this.knowhowTypeName = knowhowTypeName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "KnowhowView [id=" + id + ", memberId=" + memberId + ", knowhowTypeName=" + knowhowTypeName + ", title="
				+ title + ", regDate=" + regDate + ", hit=" + hit + ", likeCount=" + likeCount + ", commentCount="
				+ commentCount + ", userId=" + userId + ", content=" + content + "]";
	}

}
