package com.watchman.dto;

public interface Criminal {
	public int getId();
	public void setId(int id);
	public String getName();
	public void setName(String name);
	public int getAge();
	public void setAge(int age);
	public String getGender();
	public void setGender(String gender);
	public String getAddress();
	public void setAddress(String address);
	public String getIdentifyingMark();
	public void setIdentifyingMark(String identifyingMark);
	public String getArrestArea();
	public void setArrestArea(String arrestArea);
	public String getAttachedCrime();
	public void setAttachedCrime(String attachedCrime);
}
