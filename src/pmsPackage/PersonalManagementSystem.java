package pmsPackage;

import java.util.*;

public class PersonalManagementSystem {
	
	private ArrayList<User> users = new ArrayList<User>();
	private User currentUser = null;
	private static final int LOGIN = 1;
	private static final int NEW_USER = 2;
	private static final int EXIT = 0;
	private Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		PersonalManagementSystem pms = new PersonalManagementSystem();
		pms.mainMenu();
	}
	
	private PersonalManagementSystem(){
		users.add(new User("admin", "password"));
	}
	
	private void setCurrentUser(String usr) {
		for(int i = 0; i < this.getUsers().size(); i++) {
			if(this.getUsers().get(i).getUsername().equals(usr)) {
				this.currentUser = this.getUsers().get(i);
			}
		}
	}
	
	private User getCurrentUser() {
		return this.currentUser;
	}
	
	private ArrayList<User> getUsers(){
		return this.users;
	}

	private boolean login() {
		String username = "";
		while(true) {
			System.out.print("Username (" + EXIT + " to exit): ");
			username = this.getScanner().nextLine();
			if(username.equals(Integer.toString(EXIT))) {
				return false;
			}
			if(!this.userExists(username)) {
				System.out.println("Username does not exist.");
			}
			else {
				break;
			}
		}
		
		while(true) {
			System.out.print("Password (" + EXIT + " to exit): ");
			String input = this.getScanner().nextLine();
			if(input.equals(Integer.toString(EXIT))) {
				return false;
			}
			if(!checkPassword(username, input)) {
				System.out.println("Password does not match the username.");
			}
			else {
				this.setCurrentUser(username);
				break;
			}
		}
		return true;
	}

	private boolean checkPassword(String usr, String pswd) {
		for(int i = 0; i < this.getUsers().size(); i++) {
			if(this.getUsers().get(i).getUsername().equals(usr) && this.getUsers().get(i).getPassword().equals(pswd)) {
				return true;
			}
		}
		return false;
	}
	
	private Scanner getScanner() {
		return this.in;
	}
	
	private void mainMenu() {
		int selection = -1;
		while(true) {	
			System.out.println("Main Menu");
			System.out.print(PersonalManagementSystem.LOGIN + ") Login\n" + PersonalManagementSystem.NEW_USER +") New User\n" + PersonalManagementSystem.EXIT +") Exit\n>");
			String input = this.getScanner().nextLine();
			try {
				selection = Integer.parseInt(input);
				if(selection == PersonalManagementSystem.LOGIN) {
					if(this.login()) {
						this.getCurrentUser().loadPlanner(in);
					}
					this.logout();
				}
				else if(selection == PersonalManagementSystem.NEW_USER) {
					this.createNewUser();
				}
				else if(selection == PersonalManagementSystem.EXIT) {
					System.out.println("Exiting...");
					this.getScanner().close();
					System.exit(0);
				}
				else {
					System.out.println("Please enter a " + PersonalManagementSystem.LOGIN +", " + PersonalManagementSystem.NEW_USER + ", or " + PersonalManagementSystem.EXIT + ".");
				}
			}catch(NumberFormatException ex) {
				System.out.println("Please enter a " + PersonalManagementSystem.LOGIN +", " + PersonalManagementSystem.NEW_USER + ", or " + PersonalManagementSystem.EXIT + ".");
			}
		}
	}
	
	private void createNewUser() {
		String username;
		String password;
		while(true) {
			System.out.print("Username (0 to exit): ");
			username = this.getScanner().nextLine();
			if(username.equals("0")) {
				return;
			}
			if(userExists(username)) {
				System.out.println("Username has already been taken. Please try another username.");
			}
			else if(!username.matches("[a-zA-Z].*")) {
				System.out.println("Your username must start wtih a letter.");
			}
			else {
				break;
			}
		}
		while(true) {
			System.out.println("Password (0 to exit): ");
			password = this.getScanner().nextLine();
			if(password.equals("0")) {
				return;
			}
			if(!password.matches("[a-zA-Z].*")) {
				System.out.println("Your password must start with a letter.");
			}
			else {
				break;
			}
		}
		
		this.getUsers().add(new User(username, password));
	}
	
	private boolean userExists(String usr) {
		for(int i = 0; i < users.size(); i++) {
			if(this.getUsers().get(i).getUsername().equals(usr)) {
				return true;
			}
		}
		return false;
	}
	
	private void logout() {
		this.currentUser = null;
	}
	
	public static void clearScreen() {
		for(int i = 0; i < 50; i++) {
			System.out.print("\n");
		}
	}
	
}
