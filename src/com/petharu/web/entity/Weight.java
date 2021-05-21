package com.petharu.web.entity;

import java.sql.Time;
import java.util.Date;

public class Weight {
	private int id;
	private int petId;
<<<<<<< HEAD
	private Date measureTime;
	private float number;
=======
	private Date measureDate;
	private Time measureTime;
	private float kg;
>>>>>>> refs/remotes/origin/master
	
	public Weight() {
		// TODO Auto-generated constructor stub
	}

<<<<<<< HEAD
	public Weight(int id, int petId, Date measureTime, float number) {
		super();
=======

	public Weight(int id, int petId, Date measureDate, Time measureTime, float kg) {

>>>>>>> refs/remotes/origin/master
		this.id = id;
		this.petId = petId;
<<<<<<< HEAD
		this.measureTime = measureTime;
		this.number = number;
=======
		this.measureDate = measureDate;
		this.measureTime = measureTime;
		this.kg = kg;

>>>>>>> refs/remotes/origin/master
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
<<<<<<< HEAD

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
=======
	
	public int getPetId() {
		return petId;
>>>>>>> refs/remotes/origin/master
	}


	public void setPetId(int petId) {
		this.petId = petId;
	}
	public Date getMeasureDate() {
		return measureDate;
	}

	public void setMeasureDate(Date measureDate) {
		this.measureDate = measureDate;
	}

	public Time getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(Time measureTime) {
		this.measureTime = measureTime;
	}

	public float getKg() {
		return kg;
	}

	public void setKg(float kg) {
		this.kg = kg;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Weight [id=" + id + ", petId=" + petId + ", measureTime=" + measureTime + ", number=" + number
				+ "]";
=======
		return "Weight [id=" + id + ", petId=" + petId + ", measureDate=" + measureDate + ", measureTime=" + measureTime
				+ ", kg=" + kg + "]";
>>>>>>> refs/remotes/origin/master
	}
}
