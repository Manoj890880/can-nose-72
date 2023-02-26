package com.watchman.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.watchman.dao.CrimeDAO;
import com.watchman.dao.CrimeDAOImpl;
import com.watchman.dao.CriminalDAO;
import com.watchman.dao.CriminalDAOImpl;
import com.watchman.dto.Crime;
import com.watchman.dto.CrimeImpl;
import com.watchman.dto.Criminal;
import com.watchman.exception.NoRecordFoundException;
import com.watchman.exception.SomeThingWrongException;

public class CrimeUI {
	
	CrimeDAO crimeDAO;
	CriminalDAO criminalDAO;
	Scanner scanner;
	
	
	public CrimeUI(Scanner scanner) {
		crimeDAO=new CrimeDAOImpl();
		criminalDAO=new CriminalDAOImpl();
		this.scanner=scanner;
	}
	
	public void addACrime() {
		System.out.println("Enter the date of the crime - YY-MM-DD");
		String date = scanner.nextLine();

		while (date == null || date.trim().isEmpty()) {
		    System.out.print("");
		    date = scanner.nextLine();
		}

		LocalDate localDate = LocalDate.parse(date);
		
		System.out.println("Enter the place of the crime");
		String place=scanner.nextLine();
		
		System.out.println("Enter the type of the crime ");
		String type=scanner.nextLine();
		
		System.out.println("Enter the name of the victims ");
		String victims=scanner.nextLine();
		
		System.out.println("Enter the details of the crime ");
		String details=scanner.nextLine();
		
		System.out.println("Enter the suspected_names of the crime ");
		String suspected_names=scanner.nextLine();
		
		System.out.println("Enter the status of the crime ");
		String status=scanner.nextLine();
		
		System.out.println("Enter the  ipc_section of the crime ");
		int  ipc_section=scanner.nextInt();
		
		Crime crime=new CrimeImpl(localDate, place, type, victims, details, suspected_names, status, ipc_section);
		
		try {
			crimeDAO.addCrime(crime);
			System.out.println("|____________________________________________________|");
			System.out.println("|                                                    |");
		} catch (SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
	
	public void searchByCrime() {
		System.out.println("Enter the type of the crime");
		String crimeType=scanner.next();
		try {
			List<Crime> crimeList=crimeDAO.searchByCrime(crimeType);
			System.out.println("Id   | Date       | Place      | Crime Type | Victims          | Details                  | Suspected Names          | Status | IPC Section");
	        System.out.println("---- | ---------- | ---------- | ---------- | ---------------- | ------------------------ | ------------------------ | ------ | -----------");
			for (Crime crime : crimeList) {
				System.out.println(crime);
			}
		} catch (SomeThingWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public void solveACrime() {
		System.out.println("Enter the id");
		int id=scanner.nextInt();
		
		try {
			crimeDAO.solveCrimeById(id);
		} catch (SomeThingWrongException e) {
			e.printStackTrace();
		}
	}
	
	public void seeCrimeByAreaWise() {
		System.out.println("Enter the name of the area");
//		String areaName=scanner.next();
		
		try {
			List<Crime> crimeList=crimeDAO.getCrimesByAreaWise();
			
			for (Crime crime : crimeList) {
				System.out.println(crime);
			}
		} catch (SomeThingWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		} 
	}
	
	public void seeNumberOfSolvedAndUnsolvedCrime() {
		
		try {
			List<Integer> list=crimeDAO.getNumberOfSolvedAndUnsolvedCrime();
			
			
			System.out.println("Number of Solved Crimes: " + list.get(0));
			System.out.println("Number of Unsolved Crimes: " + (list.get(1)-list.get(0)));
			
		} catch (SomeThingWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void seeNumberOfCrimesRecordedCurrentMonth() {
		
		try {
			int count=crimeDAO.getNumberOfCrimesRecordedCurrentMonth();
			
//			System.out.println(count);
			System.out.println("Number of crimes recorded in current month: " + count);
		} catch (SomeThingWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void searchCriminalByName() {
		System.out.println("Enter the name of the criminal");
		scanner.nextLine();
		String name=scanner.nextLine();
		
		try {
		    List<Criminal> criminalList = criminalDAO.getCriminalByName(name);
		    System.out.println(" ID | Name       | Age | Gender | Address     | Identifying Mark  | Arrest Area      | Attached Crime | IPC Section");
		    System.out.println("----|------------|-----|--------|-------------|-------------------|------------------|----------------|-------------");
		    for (Criminal criminal : criminalList) {
				System.out.println(criminal);
			}
		} catch (NoRecordFoundException e) {
		    System.out.println("No records found for the given name.");
		} catch (SomeThingWrongException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void seeCriminalsByAreaWise() {
		
		
		try {
			List<Criminal> criminalsList=criminalDAO.getCriminalByArea();
			System.out.println(" ID | Name       | Age | Gender | Address     | Identifying Mark  | Arrest Area      | Attached Crime | IPC Section");
		    System.out.println("----|------------|-----|--------|-------------|-------------------|------------------|----------------|-------------");
			for (Criminal criminal : criminalsList) {
				System.out.println(criminal);
			}
		} catch (SomeThingWrongException | NoRecordFoundException e) {
			e.printStackTrace();
		}
	}
}



