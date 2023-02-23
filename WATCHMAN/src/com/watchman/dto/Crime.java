package com.watchman.dto;

import java.time.LocalDate;

public interface Crime {
	public int getId();
	public void setId(int id);
	public LocalDate getDate();
	public void setDate(LocalDate date);
	public String getPlace();
	public void setPlace(String place);
	public String getCrimeType();
	public void setCrimeType(String crimeType) ;
	public String getVictims();
	public void setVictims(String victims);
	public String getDetails();
	public void setDetails(String details);
	public String getSuspectedNames();
	public void setSuspectedNames(String suspectedNames);
	public String getStatus();
	public void setStatus(String status);
	public int getIpcSection();
	public void setIpcSection(int ipcSection);
}
