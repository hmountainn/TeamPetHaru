package com.petharu.web.entity;

import java.util.Date;

public class Weight {
	private int id;
	private int pet_id;
	private Date measure_time;
	private float number;
	
	public Weight() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Weight(int id, int pet_id, Date measure_time, float number) {
		super();
		this.id = id;
		this.pet_id = pet_id;
		this.measure_time = measure_time;
		this.number = number;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPet_id() {
		return pet_id;
	}

	public void setPet_id(int pet_id) {
		this.pet_id = pet_id;
	}

	public Date getMeasure_time() {
		return measure_time;
	}

	public void setMeasure_time(Date measure_time) {
		this.measure_time = measure_time;
	}

	public float getNumber() {
		return number;
	}

	public void setNumber(float number) {
		this.number = number;
	}



	@Override
	public String toString() {
		return "Weight [id=" + id + ", pet_id=" + pet_id + ", measure_time=" + measure_time + ", number=" + number
				+ "]";
	}
	
	
}
