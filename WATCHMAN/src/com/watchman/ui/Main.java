package com.watchman.ui;

import java.util.Scanner;

public class Main {
	static CrimeUI crimeUI;
	
	static void printMainMenu(Scanner sc) {
		int choice=0;
		do {
			System.out.println("|____________________________________________________|");
			System.out.println("|                                                    |");
			System.out.println("|                    MENU                            |");
			System.out.println("|____________________________________________________|");
			System.out.println("|                                                    |");
			System.out.println("|  Enter Selection:                                  |");
			System.out.println("|   1. Add a new Crime                               |");
			System.out.println("|   2. Search by Crime                               |");
			System.out.println("|   3. Solve a Crime                                 |");
			System.out.println("|   4. See Crime by Area wise                        |");
			System.out.println("|   5. See Number of Solved and Unsolved Crime       |");
			System.out.println("|   6. See Number of Crimes Recorded Current Month   |");
			System.out.println("|   7. Search Criminal by Name                       |");
			System.out.println("|   8. See Criminals by Area wise                    |");
			System.out.println("|   0. Exit                                          |");
			System.out.println("|                                                    |");
			System.out.println("|____________________________________________________|");
			
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
				System.out.println("Closing down. Don't hesitate to contact us if you need further assistance!");
				
			}
			
			
		} while (choice!=0);
	}
	
	static void officialLoggedIn(Scanner sc) {
		System.out.println("|____________________________________________________|");
		System.out.println("|                                                    |");
		System.out.println("|                 LOGIN TO YOUR ACCOUNT              |");
		System.out.println("|____________________________________________________|");
		System.out.println("|                                                    |");
		System.out.println("|  Enter your username:                              |");
		String username=sc.next();
		System.out.println("|                                                    |");
		System.out.println("|  Enter your password:                              |");
		int password=sc.nextInt();
		System.out.println("|                                                    |");
		System.out.println("|____________________________________________________|");
		
		
		
		
		
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
			System.out.println("_______________________________________");
			System.out.println("|                                      |");
			System.out.println("|     🕵️‍♂️ Crime Management System       |");
			System.out.println("|             - Watchman -             |");
			System.out.println("|______________________________________|");
			System.out.println("|                                      |");
			System.out.println("| Please Select an Option to Continue: |");
			System.out.println("|                                      |");
			System.out.println("|         1. 🔒 Login                  |");
			System.out.println("|         2. 📝 Register               |");
			System.out.println("|         0. ❌ Exit                   |");
			System.out.println("|                                      |");
			System.out.println("|______________________________________|");

			choice=sc.nextInt();
			switch (choice) {
			case 1:
				officialLoggedIn(sc);
				break;

			case 2:
				register(sc);
				break;
			
			default :
				System.out.println("Closing down. Don't hesitate to contact us if you need further assistance!");
				
			}
			
				
			
			
		} while (choice!=0);
		
		sc.close();
	}

	
	
	

	
}
