package com.watchman.dto;


import java.time.LocalDate;

public class CrimeImpl implements Crime{
	
	private int id;
	private LocalDate date;
	private String place;
	private String crimeType;
	private String victims;
	private String details;
	private String suspectedNames;
	private String status;
	private int ipcSection;
	
	public CrimeImpl() {}
	
	public CrimeImpl(LocalDate date, String place, String crimeType, String victims, String details,
			String suspectedNames, String status, int ipcSection) {
		

		this.date = date;
		this.place = place;
		this.crimeType = crimeType;
		this.victims = victims;
		this.details = details;
		this.suspectedNames = suspectedNames;
		this.status = status;
		this.ipcSection = ipcSection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}

	public String getVictims() {
		return victims;
	}

	public void setVictims(String victims) {
		this.victims = victims;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getSuspectedNames() {
		return suspectedNames;
	}

	public void setSuspectedNames(String suspectedNames) {
		this.suspectedNames = suspectedNames;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getIpcSection() {
		return ipcSection;
	}

	public void setIpcSection(int ipcSection) {
		this.ipcSection = ipcSection;
	}

	@Override
	public String toString() {
		return "Id=" + id + ", date=" + date + ", place=" + place + ", crimeType=" + crimeType + ", victims="
				+ victims + ", details=" + details + ", suspectedNames=" + suspectedNames + ", status=" + status
				+ ", ipcSection=" + ipcSection + "]";
	}
	
	
	
}
