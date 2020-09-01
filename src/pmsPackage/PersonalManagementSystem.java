package pmsPackage;

import java.util.*;

/**
 * <h2>PersonalManagementSystem<h2>
 * <p>This class implements the driver for the Personal Management System application.
 * <p>Created on 31 August 2020
 * @author Christian Harris
 *
 */

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
	
	/**
	 * This method sets the currentUser based on the username String of a user object.
	 * <pre>Examples:
	 * {@code setCurrentUser("admin") sets the current user to the user named "admin".}
	 * </pre>
	 * @param usr (String; The username of the current user)
	 */
	private void setCurrentUser(String usr) {
		for(int i = 0; i < this.getUsers().size(); i++) {
			if(this.getUsers().get(i).getUsername().equals(usr)) {
				this.currentUser = this.getUsers().get(i);
			}
		}
	}
	
	/**
	 * This method returns the current user of the application as a User object.
	 * <pre>Examples:
	 * {@code getCurrentUser() returns the User object of the current user.}
	 * </pre>
	 * @return currentUser (User; the current User object of the application.)
	 */
	private User getCurrentUser() {
		return this.currentUser;
	}
	
	/**
	 * This method returns the users ArrayList containing all of the available users for the application.
	 * <pre>Examples:
	 * {@code getUsers() returns the ArrayList users.}
	 * </pre>
	 * @return users (ArrayList<User>; all of the available users.)
	 */
	private ArrayList<User> getUsers(){
		return this.users;
	}

	/**
	 * This method prompts a user for login information and validates if the user is available.
	 * <pre>Examples:
	 * {@code login() returns true if the user enters a valid username and password.}
	 * </pre>
	 */
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

	/**
	 * This method returns a boolean value based on if the username and password are a matching pair.
	 * <pre>Examples:
	 * {@code checkPassword("admin", "password") returns true if "admin" is a user and "password" is the users password.}
	 * </pre>
	 */
	private boolean checkPassword(String usr, String pswd) {
		for(int i = 0; i < this.getUsers().size(); i++) {
			if(this.getUsers().get(i).getUsername().equals(usr) && this.getUsers().get(i).getPassword().equals(pswd)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method returns a scanner object used for console input.
	 * <pre>Examples:
	 * {@code getScanner() returns a scanner object for System.in.}
	 * </pre>
	 * @return in (Scanner, a scanner for System.in)
	 */
	private Scanner getScanner() {
		return this.in;
	}
	
	/**
	 * This method functions as the primary menu screen for the application.
	 */
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
	
	/**
	 * This method prompts a user for a new username and password. Both entries must begin with a letter.
	 * The method prints error messages if either field begins with a non-letter or if the desired username is already in the application.
	 */
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
	
	/**
	 * This method returns true if the application already has a user with the supplied username.
	 * <pre>Examples:
	 * {@code userExists("admin") returns true if the application has a user with username "admin".}
	 * </pre>
	 */
	private boolean userExists(String usr) {
		for(int i = 0; i < users.size(); i++) {
			if(this.getUsers().get(i).getUsername().equals(usr)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method sets the currentUser field to null.
	 */
	private void logout() {
		this.currentUser = null;
	}
}
