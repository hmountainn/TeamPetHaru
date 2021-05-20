package com.petharu.web.entity;

public class Pet {
	
	private int id;
	private String name;
	private String breed;
	private String gender;
	private String birthday;
	private int age;
	private String personality;
	
	


	public Pet() {
		// TODO Auto-generated constructor stub
	}
	

	public Pet(int id, String name, String breed, String gender, String birthday, int age, String personality) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.gender = gender;
		this.birthday = birthday;
		this.age = age;
		this.personality = personality;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	
	
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "{\"name\":\"" + name + "\", \"breed\":\"" + breed + "\", \"gender\":\"" + gender + "\", \"birthday\":\"" + birthday + "\", \"personality\":\"" + personality + "\", \"id\":\"" + id +"\"}";
	}
	
	
	

}
