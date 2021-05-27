package com.petharu.web.entity;

import java.sql.Time;
import java.util.Date;

public class Weight {
	private int id;
	private int petId;
	private String measureDatetime;
	private float kg;
	private String petname;
	
	public Weight() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Weight(int id, int petId, String measureDatetime, float kg, String petname) {
		super();
		this.id = id;
		this.petId = petId;
		this.measureDatetime = measureDatetime;
		this.kg = kg;
		this.petname = petname;
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

	public String getMeasureDatetime() {
		return measureDatetime;
	}

	public void setMeasureDatetime(String measureDatetime) {
		this.measureDatetime = measureDatetime;
	}

	public float getKg() {
		return kg;
	}

	public void setKg(float kg) {
		this.kg = kg;
	}

	public String getPetname() {
		return petname;
	}

	public void setPetname(String petname) {
		this.petname = petname;
	}

	@Override
	public String toString() {
		return "Weight [id=" + id + ", petId=" + petId + ", measureDatetime=" + measureDatetime + ", kg=" + kg
				+ ", petname=" + petname + "]";
	}



	


	
}
