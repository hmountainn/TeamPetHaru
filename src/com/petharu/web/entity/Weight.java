package com.petharu.web.entity;

import java.util.Date;

public class Weight {
	private int id;
	private int petId;
	private Date measureTime;
	private float number;
	
	public Weight() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Weight(int id, int petId, Date measureTime, float number) {
		super();
		this.id = id;
		this.petId = petId;
		this.measureTime = measureTime;
		this.number = number;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public Date getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(Date measureTime) {
		this.measureTime = measureTime;
	}

	public float getNumber() {
		return number;
	}

	public void setNumber(float number) {
		this.number = number;
	}



	@Override
	public String toString() {
		return "Weight [id=" + id + ", petId=" + petId + ", measureTime=" + measureTime + ", number=" + number
				+ "]";
	}
	
	
}
