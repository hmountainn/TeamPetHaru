package com.petharu.web.entity;

public class Admin {

	private int id;
	private String userId;
	private String password;
	private String email;
	private String image;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String userId, String password, String email, String image) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id
				+ ", \"userId\":\"" + userId
				+ "\", \"password\":\"" + password
				+ "\", \"email\":\"" + email
				+ "\", \"image\":\"" + image + "\"}";
	}
	
	
}
