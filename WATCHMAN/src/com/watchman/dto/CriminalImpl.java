package com.watchman.dto;

public class CriminalImpl implements Criminal{
	
	
	private int id;
	private String name;
	private int age;
	private String gender;
	private String address;
	private String identifyingMark;
	private String arrestArea;
	private String attachedCrime;
	
	public CriminalImpl() {}

	public CriminalImpl(int id, String name, int age, String gender, String address, String identifyingMark,
			String arrestArea, String attachedCrime) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.identifyingMark = identifyingMark;
		this.arrestArea = arrestArea;
		this.attachedCrime = attachedCrime;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentifyingMark() {
		return identifyingMark;
	}

	public void setIdentifyingMark(String identifyingMark) {
		this.identifyingMark = identifyingMark;
	}

	public String getArrestArea() {
		return arrestArea;
	}

	public void setArrestArea(String arrestArea) {
		this.arrestArea = arrestArea;
	}

	public String getAttachedCrime() {
		return attachedCrime;
	}

	public void setAttachedCrime(String attachedCrime) {
		this.attachedCrime = attachedCrime;
	}

	@Override
	public String toString() {
		return id + " | " + name + " | " + age + " | " + gender + " | " +
	            address + " | " + identifyingMark + " | " + arrestArea + " | " +
	            attachedCrime;
	}
	
	
}
