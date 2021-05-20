package com.petharu.web.entity;

import java.util.Date;

public class KnowhowType {

	private int id;
	private String name;
	
	public KnowhowType() {
		
	}

	public KnowhowType(int id, String name) {
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
		return "KnowhowType [id=" + id + ", name=" + name + "]";
	}
	
}
