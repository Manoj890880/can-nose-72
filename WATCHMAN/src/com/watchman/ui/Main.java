package com.watchman.ui;

import java.util.Scanner;

public class Main {
	static CrimeUI crimeUI;
	
	static void printMainMenu(Scanner sc) {
		int choice=0;
		do {
			System.out.println("Enter Selection");
			System.out.println("1. Add A new Crime");
			System.out.println("2. Search By Crime");
			System.out.println("3. Solve a Crime");
			System.out.println("4. See Crime by area wise");
			System.out.println("5. See Number of Solved And Unsolved Crime");
			System.out.println("6. See Number of Crimes recorded current month");
			System.out.println("7. Search Criminal By Name");
			System.out.println("8. See Criminals by area wise");
			System.out.println("0. Exit");
			
			choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				crimeUI.addACrime();
				break;

			case 2:
				crimeUI.searchByCrime();
				break;
				
			case 3:
				crimeUI.solveACrime();
				break;
			
			case 4:
				crimeUI.seeCrimeByAreaWise();
				break;
			
			case 5:
				crimeUI.seeNumberOfSolvedAndUnsolvedCrime();
				break;
				
			case 6:
				crimeUI.seeNumberOfCrimesRecordedCurrentMonth();
				break;
			
			case 7:
				crimeUI.searchCriminalByName();
				break;
				
			case 8:
				crimeUI.seeCriminalsByAreaWise();
				break;
			
			default :
				System.out.println("Envalid Selection");
				
			}
			
			
		} while (choice!=0);
	}
	
	static void officialLoggedIn(Scanner sc) {
		System.out.println("Enter Username");
		String username=sc.next();
		System.out.println("Enter Password");
		int password=sc.nextInt();
		
		if (username.equalsIgnoreCase("admin")&&password==123) {
			printMainMenu(sc);
		}else {
			System.out.println("Invalid Username and Password");
		}
	}
	
	static void register(Scanner sc) {
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		crimeUI = new CrimeUI(sc);
		int choice=0;
		
		do {
			System.out.println("Enter Selection");
			System.out.println("1. Login\n2. Register\n0. Exit");
			choice=sc.nextInt();
			switch (choice) {
			case 1:
				officialLoggedIn(sc);
				break;

			case 2:
				register(sc);
				break;
				
			}
			
			
		} while (choice!=0);
		
		sc.close();
	}

	

	

	
}
