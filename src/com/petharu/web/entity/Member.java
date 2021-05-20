package com.petharu.web.entity;

public class Member {
	private int id;
	private String userId;
	private String email;
	private String password;
	private String image;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Member(int id, String user_id, String email, String password, String image) {
		super();
		this.id = id;
		this.userId = user_id;
		this.email = email;
		this.password = password;
		this.image = image;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return userId;
	}

	public void setUser_id(String user_id) {
		this.userId = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", userId=" + userId + ", email=" + email + ", password=" + password + ", image="
				+ image + "]";
	}
	
	
}
