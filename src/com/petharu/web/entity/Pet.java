package com.petharu.web.entity;

import java.util.Date;

public class Pet {

	private int id;
	private String name;
	private String gender;
	private String breed;
	private String birthday;
	private String personality;
	private int age;
	private int memberId;
	private int breedId;

	public Pet() {
		// TODO Auto-generated constructor stub
	}

	public Pet(int id, String name, String gender, String breed, String birthday, String personality, int age,
			int memberId, int breedId) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.breed = breed;
		this.birthday = birthday;
		this.personality = personality;
		this.age = age;
		this.memberId = memberId;
		this.breedId = breedId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getBreedId() {
		return breedId;
	}

	public void setBreedId(int breedId) {
		this.breedId = breedId;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"name\":\"" + name + "\", \"gender\":\"" + gender + "\", \"breed\":\"" + breed
				+ "\", \"birthday\":\"" + birthday + "\", \"personality\":\"" + personality + "\", \"age\":\"" + age
				+ "\", \"memberId\":" + memberId + ", \"breedId\":" + breedId + "}";
	}

}
