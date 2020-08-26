package pmsPackage;

import java.io.*;
import java.util.*;

public class PersonalManagementSystem {
	
	private String currentUser = "";
	
	public static void main(String[] args) {
		
		PersonalManagementSystem pms = new PersonalManagementSystem();

	}
	
	public PersonalManagementSystem(){}
	
	public String loginPromptUsername() {
		System.out.print("Username: ");
		Scanner in = new Scanner(System.in);
		String userInput = in.nextLine();
		in.close();
		return userInput;
	}
	
	public String loginPromptPassword() {
		System.out.print("Password: ");
		Scanner in = new Scanner(System.in);
		String userInput = in.nextLine();
		in.close();
		return userInput;
	}
	
	public int mainMenu() {
		int selection = -1;
		Scanner in = new Scanner(System.in);
		while(selection != 1 && selection != 2 && selection != 3) {
			System.out.println("Main Menu");
			System.out.println("1) Login\n2) New User\n3) Exit");
			System.out.print(">");
			try {
				selection = in.nextInt();
			}catch(InputMismatchException ex) {
				System.out.println("Please enter a 1, 2, or 3.");
			}
		}
		in.close();
		return selection;
	}
	
	
	
	
}
