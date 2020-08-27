package pmsPackage;

//import java.io.*;
import java.util.*;

public class PersonalManagementSystem {
	
	//private String currentUser = "";
	private static final int LOGIN = 1;
	private static final int NEW_USER = 2;
	private static final int EXIT = 0;
	private int selector = -1;
	private Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		PersonalManagementSystem pms = new PersonalManagementSystem();
		
		while(true) {
			pms.setSelector(pms.mainMenu());
			if(pms.getSelector() == PersonalManagementSystem.LOGIN) {
			
			}
			else if(pms.getSelector() == PersonalManagementSystem.NEW_USER) {
				
			}
			else if(pms.getSelector() == PersonalManagementSystem.EXIT) {
				System.out.println("Exiting...");
				pms.getScanner().close();
				System.exit(0);
			}
			else {
				System.out.println("Erroneous selection has been made.");
				pms.getScanner().close();
				System.exit(1);
			}
			
		}

	}
	
	public PersonalManagementSystem(){}
	
	public String loginPromptUsername() {
		System.out.print("Username: ");
		String userInput = this.getScanner().nextLine();
		return userInput;
	}
	
	public String loginPromptPassword() {
		System.out.print("Password: ");
		String userInput = this.getScanner().nextLine();
		return userInput;
	}
	
	public int getSelector() {
		return selector;
	}
	
	public void setSelector(int s) {
		this.selector = s;
	}
	
	public Scanner getScanner() {
		return this.in;
	}
	
	public int mainMenu() {
		int selection = -1;
		String s = "";
		//Scanner in = new Scanner(System.in);
		while(selection != PersonalManagementSystem.LOGIN && selection != PersonalManagementSystem.NEW_USER && selection != PersonalManagementSystem.EXIT) {
			System.out.println("Main Menu");
			System.out.println(PersonalManagementSystem.LOGIN + ") Login\n" + PersonalManagementSystem.NEW_USER +") New User\n" + PersonalManagementSystem.EXIT +") Exit");
			System.out.print(">");
			s = this.getScanner().nextLine();
			try {
				selection = Integer.parseInt(s);
				if(selection != PersonalManagementSystem.LOGIN && selection != PersonalManagementSystem.NEW_USER && selection != PersonalManagementSystem.EXIT) {
					System.out.println("Please enter a " + PersonalManagementSystem.LOGIN +", " + PersonalManagementSystem.NEW_USER + ", or " + PersonalManagementSystem.EXIT + ".");
				}
			}catch(NumberFormatException ex) {
				System.out.println("Please enter a " + PersonalManagementSystem.LOGIN +", " + PersonalManagementSystem.NEW_USER + ", or " + PersonalManagementSystem.EXIT + ".");
			}
		}
		return selection;
	}
	
	
	
	
}
