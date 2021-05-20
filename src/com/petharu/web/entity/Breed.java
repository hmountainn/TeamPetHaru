package com.petharu.web.entity;

public class Breed {
	private int id;
	private String name;
	
	public Breed() {
		// TODO Auto-generated constructor stub
	}

	public Breed(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Breed [id=" + id + ", name=" + name + "]";
	}
	

}
