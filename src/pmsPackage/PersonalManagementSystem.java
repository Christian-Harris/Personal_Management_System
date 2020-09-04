package pmsPackage;

import java.util.*;
import java.time.*;
import java.time.format.*;

/**
 * <h2>PersonalManagementSystem</h2>
 * <p>This class implements the driver for the Personal Management System application. All menu logic is done in this class.</p>
 * <p>Created on 31 August 2020</p>
 * @author Christian Harris
 *
 */

public class PersonalManagementSystem {
	
	private ArrayList<User> users = new ArrayList<User>();
	private User currentUser = null;
	private Scanner in = new Scanner(System.in);
	private boolean userLoggedIn = false;
	private boolean calendarViewer = true;
	
	/**
	 * The main method begins the application by instantiating a new PersonalManagementSystem object and then calls the run method.
	 * @param args - a string array from the console.
	 */
	public static void main(String[] args) {
		
		PersonalManagementSystem pms = new PersonalManagementSystem();
		pms.run();
	}
	
	/**
	 * Constructs a PersonalManagementSystem with an admin user and some data entries for testing.
	 */
	PersonalManagementSystem(){
		User admin = new User("admin", "password");
		users.add(admin);
		Item bannana = new Item("bannana");
		bannana.setChecked(true);
		Item tacos = new Item("tacos");
		ArrayList<Item> itms = new ArrayList<Item>();
		itms.add(bannana);
		itms.add(tacos);
		admin.getPlanner().addList("Shopping", itms);
		admin.getPlanner().addList("To Do");
		Event eventOne = new Event("Shopping", LocalDate.now(), LocalTime.now(), LocalTime.MIDNIGHT, "Grocery Shopping", "Grocery store", "Shopping", false, "");
		Event eventTwo = new Event("Future", LocalDate.of(2021,  1, 12), LocalTime.of(12, 0), LocalTime.of(18, 30), "Future Event", "Somewhere", "", false, "");
		admin.getPlanner().addEvent(eventOne);
		admin.getPlanner().addEvent(eventTwo);
		
	}
	
	/**
	 * This method begins the application fully by clearing the console screen and calling the mainMenu method.
	 */
	private void run() {
		this.clearConsole();
		this.mainMenu();
	}
	
	/**
	 * The main menu of the application. Here users an login, make or delete users, or logout.
	 */
	private void mainMenu() {
		String selection = "";
		while(true) {
			if(!this.userLoggedIn) {
				System.out.println("Main Menu");
				System.out.print("1) Login\n2) Create New User\n3) Delete User\n0) Exit\n>");
				selection = in.nextLine();
				this.clearConsole();
				if(selection.equals("0")) {
					System.out.println("Exiting...");
					System.exit(0);
				}
				else if(selection.equals("1")) {
					this.login();
				}
				else if(selection.equals("2")) {
					this.createNewUser();
				}
				else if(selection.equals("3")) {
					this.deleteUser();
				}
				else {
					System.out.println("Please select 1, 2, or 0.");
				}
			}
			else {
				if(calendarViewer){
					this.calendarView();
				}
				else {
					this.listsView();
				}
			}
		}
	}
	
	/**
	 * This method controls the logic for an already existing user to login. Their username and passwords are checked for validity.
	 */
	private void login() {
		String selection = "";
		String username = "";
		while(true) {
			System.out.println("Login");
			System.out.print("Username (0 to Exit): ");
			selection = in.nextLine();
			if(selection.equals("0")) {
				this.clearConsole();
				return;
			}
			else if(!this.usernameExists(selection)) {
				this.clearConsole();
				System.out.println(selection + " does not exist.");
			}
			else {
				username = selection;
				this.clearConsole();
				break;
			}
		}
		
		while(true) {
			System.out.println("Login\nUsername: " + username);
			System.out.print("Password (0 to Exit): ");
			selection = in.nextLine();
			if(selection.equals("0")) {
				this.clearConsole();
				return;
			}
			else if(!this.checkPassword(username, selection)) {
				this.clearConsole();
				System.out.println("Password does not match username " + username);
			}
			else {
				this.setCurrentUser(username);
				this.userLoggedIn = true;
				this.clearConsole();
				return;
			}
		}
	}
	
	/**
	 * This method returns true if there is a User in users with a username of usr.
	 * @param usr - the username of a User in users.
	 * @return - true if usr is a valid user.
	 */
	public boolean usernameExists(String usr) {
		for(int i = 0; i < this.users.size(); i++) {
			if(this.users.get(i).getUsername().equals(usr)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method sets the current User of the applicaton to the user with username usr.
	 * @param usr - the user to be set as the current user.
	 */
	private void setCurrentUser(String usr) {
		for(int i = 0; i < this.users.size(); i++) {
			if(this.users.get(i).getUsername().equals(usr)) {
				currentUser = this.users.get(i);
			}
		}
	}
	
	/**
	 * This method makes sure that the user usr has a password of pswd.
	 * @param usr - the username of a user.
	 * @param pswd - the password of a user.
	 * @return - true if the username and password match, false otherwise.
	 */
	public boolean checkPassword(String usr, String pswd) {
		for(int i = 0; i < this.users.size(); i++) {
			if(this.users.get(i).getUsername().equals(usr) && this.users.get(i).getPassword().equals(pswd)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method controls the logic for creating new users. Users must enter a username and password. Usernames cannot be the same as any username of previously created users.
	 * Both usernames and password must begin with letters.
	 */
	private void createNewUser() {
		String username;
		String password;
		while(true) {
			System.out.println("New User");
			System.out.print("Username (0 to exit): ");
			username = in.nextLine();
			this.clearConsole();
			if(username.equals("0")) {
				return;
			}
			else if(this.usernameExists(username)) {
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
			System.out.println("New User");
			System.out.println("Username: " + username);
			System.out.print("Password (0 to exit): ");
			password = in.nextLine();
			this.clearConsole();
			if(password.equals("0")) {
				return;
			}
			else if(!password.matches("[a-zA-Z].*")) {
				System.out.println("Your password must start with a letter.");
			}
			else {
				break;
			}
		}
		this.users.add(new User(username, password));
	}
	
	/**
	 * This method controls the logic for deleting a user. A username must be entered and then the correct password in order to successfully delete a user.
	 */
	private void deleteUser() {
		String selection = "";
		String username = "";
		while(true) {
			System.out.print("Enter the username of the user to be deleted (0 to Exit):\n>");
			selection = in.nextLine();
			this.clearConsole();
			if(selection.equals("0")) {
				return;
			}
			else if(!this.usernameExists(selection)){
				System.out.println(selection + " does not exist.");
			}
			else {
				username = selection;
				System.out.print("Enter password for " + selection + " to confirm deletion:\n>");
				selection = in.nextLine();
				if(!this.checkPassword(username, selection)) {
					System.out.println("Password does not match " + username);
				}
				else {
					for(int i = 0; i < this.users.size(); i++) {
						if(this.users.get(i).getUsername().equals(username)) {
							this.users.remove(i);
						}
					}
					return;
				}
			}
		}
	}
	
	/**
	 * This method control the logic for the calendar view of the application. The current users planner is called to display the current month.
	 * The user can then add/remove events, view all the current months events, view all events, switch to viewing thier lists, move to next/previous months, or logout.
	 */
	private void calendarView() {
		String selection = "";
		LocalDate monthToView = LocalDate.now();
		while(true) {
			System.out.println("Calendar View: " + monthToView.toString());
			this.currentUser.getPlanner().displayCalendar(monthToView);
			System.out.print("1) Add Event\n2) Remove Event\n3) View Current Month Events\n4) View All Events\n5) View Lists\n6) Next Month\n7) Previous Month\n8) Current Month\n0) Logout\n>");
			selection = in.nextLine();
			this.clearConsole();
			if(selection.equals("0")) {
				this.logout();
				return;
			}
			else if(selection.equals("1")) {
				this.addEvent();
			}
			else if(selection.equals("2")) {
				this.removeEvent();
			}
			else if(selection.equals("3")) {
				this.viewCurrentMonthEvents(monthToView);
			}
			else if(selection.equals("4")) {
				this.viewAllEvents();
			}
			else if(selection.equals("5")) {
				this.calendarViewer = false;
				return;
			}
			else if(selection.equals("6")) {
				monthToView = monthToView.plusMonths(1);
			}
			else if(selection.equals("7")) {
				monthToView = monthToView.minusMonths(1);
			}
			else if(selection.equals("8")) {
				monthToView = LocalDate.now();
			}
			else {
				System.out.println("Please enter a 1, 2, 3, 4, 5, 6, 7, 8 or 0.");
			}
		}
	}
	
	/**
	 * This method handles the menu for interacting with all the events of the current month determined by the LocalDate monthToView.
	 * @param monthToView - the LocalDate object describing which month to interact with.
	 */
	private void viewCurrentMonthEvents(LocalDate monthToView) {
		String selection = "";
		while(true) {
			System.out.println("View Current Months Events");
			this.currentUser.getPlanner().displayEvents(monthToView);
			System.out.println("0) Exit");
			selection = in.nextLine();
			this.clearConsole();
			if(selection.equals("0")) {
				return;
			}
			else {
				System.out.println("Please enter a 0.");
			}
		}
	}
	
	/**
	 * This method handles all the logic for creating a new event. Fields marked with an * are required for successfully creating a new Event.
	 * Nothing is comitted to the current users planner until the user attempts to submit the data. 
	 * If there are missing required fiels the user will be notified an no new Event will be created.
	 */
	public void addEvent() {
		String name = "";
		String selection = "";
		LocalDate date = LocalDate.now();
		LocalTime startTime = LocalTime.now();
		LocalTime endTime = LocalTime.now();
		LocalDate endDate = LocalDate.now();
		String description = "";
		String location = "";
		String listName = "";
		boolean repeats = false;
		String repetionMask = "";
		
		boolean newLink = false;
		
		String dateString = "";
		String startString = "";
		String endString = "";
		String endDateString = "";
		while(true) {
			System.out.println("Add Event");
			System.out.print("1) *Name: " + name + "\n2) *Date: " + dateString + "\n3) *Start: " + startString + "\n4) *End: " + endString + "\n5) Description: " + description + "\n6) Location: " + location + "\n7) Repeats on " + repetionMask + " until: " + endDateString + "\n8) List: " + listName + "\n9) Submit\nSelect a field to enter * means required (0 to Exit):\n>");
			selection = in.nextLine();
			this.clearConsole();
			if(selection.equals("0")) {
				return;
			}
			else if(selection.equals("1")) {
				System.out.print("Enter name of event:\n>");
				selection = in.nextLine();
				if(this.currentUser.getPlanner().eventExists(selection)) {
					System.out.println(selection + " already exists as an event.");
				}
				else if(!selection.matches("[a-zA-Z].*")) {
					System.out.println("Event name must start with a letter.");
				}
				else {
					name = selection;
				}
			}
			else if(selection.equals("2")) {
				System.out.print("Enter date as YYYY-MM-DD\n>");
				selection = in.nextLine();
				try {
					CharSequence cs = selection.subSequence(0, selection.length());
					date = LocalDate.parse(cs);
					dateString = date.toString();
				}catch(DateTimeParseException ex) {
					System.out.println("Invalid date entered.");
				}
			}
			else if(selection.equals("3")) {
				System.out.print("Enter start time as HH:MM\n>");
				selection = in.nextLine();
				try {
					CharSequence cs = selection.subSequence(0, selection.length());
					startTime = LocalTime.parse(cs);
					startString = startTime.toString();
				}catch(DateTimeParseException ex) {
					System.out.println("Invalid time entered.");
				}
			}
			else if(selection.equals("4")) {
				System.out.print("Enter end time as HH:MM\n>");
				selection = in.nextLine();
				try {
					CharSequence cs = selection.subSequence(0, selection.length());
					endTime = LocalTime.parse(cs);
					endString = endTime.toString();
				}catch(DateTimeParseException ex) {
					System.out.println("Invalid time entered.");
				}
			}
			else if(selection.equals("5")) {
				System.out.print("Enter a description:\n>");
				description = in.nextLine();
			}
			else if(selection.equals("6")) {
				System.out.print("Enter a location:\n>");
				location = in.nextLine();
			}
			else if(selection.equals("7")) {
				System.out.print("Enter the day to terminate repition as YYYY-MM-DD:\n>");
				selection = in.nextLine();
				try {
					CharSequence cs = selection.subSequence(0,  selection.length());
					endDate = LocalDate.parse(cs);
					endDateString = endDate.toString();
					System.out.println("M = Monday, T = Tuesday, W = Wednesday, H = Thursday, F = Friady, S = Satruday, U = Sunday.");
					System.out.print("Enter which days to repeat (example MWF repeats Monday, Wednesday, and Friday:\n>");
					selection = in.nextLine();
					if(!selection.toUpperCase().matches("M?T?W?H?F?S?U?")) {
						System.out.println("Invalid entry.");
					}
					else {
						repetionMask = selection.toUpperCase();
						repeats = true;
					}
				}catch(DateTimeParseException ex) {
					System.out.println("Invalid date entered.");
				}
			}
			else if(selection.equals("8")) {
				System.out.println("Would you like to link and existing list? (Y/N)");
				selection = in.nextLine();
				if(selection.equalsIgnoreCase("Y")) {
					this.currentUser.getPlanner().displayLists();
					System.out.print("Enter the name of the list to link:\n>");
					selection = in.nextLine();
					if(!this.currentUser.getPlanner().listExists(selection)) {
						System.out.println(selection + " does not exist.");
					}
					else {
						listName = selection;
					}
				}
				else if(selection.equalsIgnoreCase("N")) {
					System.out.println("Please enter the name of the new list.");
					selection = in.nextLine();
					if(this.currentUser.getPlanner().listExists(selection)) {
						System.out.println("List already exists.");
					}
					else if(!selection.matches("[a-zA-Z].*")) {
						System.out.println("List name must start with a letter.");
					}
					else {
						listName = selection;
						newLink = true;
					}
				}
				else {
					System.out.println("Invalid input.");
				}
			}
			else if(selection.equals("9")) {
				if(name.equals("") || dateString.equals("") || startString.equals("") || endString.equals("")) {
					System.out.println("Missing required field.");
				}
				else {
					if(newLink);
					{
						this.currentUser.getPlanner().addList(listName);
					}
					if(repeats) {
						this.currentUser.getPlanner().addEvent(new Event(name, date, startTime, endTime, description, location, listName, repeats, repetionMask, endDate));
					}
					else {
						this.currentUser.getPlanner().addEvent(new Event(name, date, startTime, endTime, description, location, listName, repeats, repetionMask));
					}
					return;
				}
			}
			else {
				System.out.println("Please enter a 1, 2, 3, 4, 5, 6, 7 or 0.");
			}
		}
	}
	
	/**
	 * This method handles the logic for removing an event based on its name. If no event with the given name exists the user is notified.
	 */
	private void removeEvent() {
		String selection = "";
		while(true) {
			System.out.println("Remove Event");
			this.currentUser.getPlanner().displayEvents();
			System.out.println("Enter name of event to remove (0 to Exit):\n>");
			selection = in.nextLine();
			this.clearConsole();
			if(selection.equals("0")) {
				return;
			}
			else {
				if(!this.currentUser.getPlanner().eventExists(selection)) {
					System.out.println(selection + "does not exist.");
				}
				else {
					this.currentUser.getPlanner().removeEvent(selection);
				}
			}
		}
	}
	
	/**
	 * This method handles the menu for viewing all Events which have been created by the current user.
	 */
	private void viewAllEvents() {
		String selection = "";
		while(true) {
			System.out.println("View All Events");
			this.currentUser.getPlanner().displayEvents();
			System.out.print("0) Exit\nEnter event name for details:\n>");
			selection = in.nextLine();
			this.clearConsole();
			if(selection.equals("0")) {
				return;
			}
			else {
				if(!this.currentUser.getPlanner().eventExists(selection)) {
					System.out.println(selection + " does not exist.");
				}
				else {
					this.viewEvent(selection);
				}
			}
		}
	}
	
	/**
	 * This method views all the details for an Event with eventName.
	 * @param eventName - the name of an Event.
	 */
	private void viewEvent(String eventName) {
		String selection = "";
		while(true) {
			System.out.println("Event: " + eventName);
			this.currentUser.getPlanner().displayEvent(eventName);
			System.out.print("0) Exit\n1) List\n2) Add List\n>");
			selection = in.nextLine();
			this.clearConsole();
			if(selection.equals("0")) {
				return;
			}
			else if(selection.equals("1")) {
				if(!this.currentUser.getPlanner().eventHasList(eventName)) {
					System.out.println(eventName + " does not have an associated list.");
				}
				else {
					this.clearConsole();
					this.accessList(this.currentUser.getPlanner().getEventListName(eventName));
				}
			}
			else if(selection.equals("2")) {
				if(this.currentUser.getPlanner().eventHasList(eventName)) {
					System.out.println(eventName + " already as a list.");
				}
				else {
					System.out.println("Enter name of list to add:\n>");
					selection = in.nextLine();
					if(!selection.matches("[a-zA-Z].*")) {
						System.out.println("List name must start with a letter.");
					}
					else {
						this.currentUser.getPlanner().addList(selection);
						this.currentUser.getPlanner().connectEventList(eventName, selection);
					}
				}
				
			}
			else {
				System.out.println("Please enter a 1 or 0.");
			}
		}
	}
	
	/**
	 * This method handles the menu for viewing all the Lists the current user has created. Users can switch to the calendar view, add/remove lists, view the details of a list, or logout.
	 */
	private void listsView() {
		String selection = "";
		while(true) {
			System.out.println("List View");
			this.currentUser.getPlanner().displayLists();
			System.out.print("1) View Calendar\n2) Add List\n3) Delete List\n4) View\n0) Logout\n>");
			selection = in.nextLine();
			this.clearConsole();
			if(selection.equals("0")) {
				this.logout();
				return;
			}
			else if(selection.equals("1")) {
				calendarViewer = true;
				return;
			}
			else if(selection.equals("2")) {
				this.addList();
			}
			else if(selection.equals("3")) {
				this.deleteList();
			}
			else if(selection.equals("4")) {
				this.currentUser.getPlanner().displayLists();
				System.out.print("Enter the name of the list to view:\n>");
				selection = in.nextLine();
				if(this.listExists(selection)) {
					this.clearConsole();
					this.accessList(selection);
				}
				else {
					System.out.println(selection + " is not a current list.");
				}
			}
			else {
				System.out.println("Please enter a 1, 2, 3, 4, or 0.");
			}
		}
	}
	
	/**
	 * This method handles the logic for accessing the details of a specific list. Users can add/delete items, check/uncheck items, or return to a previous menu.
	 * @param name - the name of a List.
	 */
	private void accessList(String name) {
		String selection = "";
		while(true) {
			System.out.println(name);
			this.currentUser.getPlanner().displayList(name);
			System.out.print("1) Add Item\n2) Delete Item\n3) Check Item\n4) Uncheck Item\n0) Exit\n>");
			selection = in.nextLine();
			this.clearConsole();
			this.currentUser.getPlanner().displayList(name);
			if(selection.equals("0")) {
				return;
			}
			else if(selection.equals("1")) {
				System.out.print("Enter item:\n>");
				selection = in.nextLine();
				this.currentUser.getPlanner().getList(name).addItem(new Item(selection));
			}
			else if(selection.equals("2")) {
				System.out.print("Enter item to delete:\n>");
				selection = in.nextLine();
				this.currentUser.getPlanner().getList(name).deleteItem(selection);
			}
			else if(selection.equals("3")) {
				System.out.print("Enter item:\n>");
				selection = in.nextLine();
				this.currentUser.getPlanner().getList(name).checkItem(selection);
			}
			else if(selection.equals("4")) {
				System.out.print("Enter item:\n>");
				selection = in.nextLine();
				this.currentUser.getPlanner().getList(name).uncheckItem(selection);
			}
			else {
				this.clearConsole();
				System.out.println("Please enter a 1, 2, 3, or 0.");
			}
			this.clearConsole();
		}
	}
	
	/**
	 * This method returns true if there exists a list with Name in the current users planner.
	 * @param name - the name of a List.
	 * @return - true if a List with name exists.
	 */
	public boolean listExists(String name) {
		return this.currentUser.getPlanner().listExists(name);
	}
	
	/**
	 * This method handles the logic for creating a new list for the user.
	 */
	private void addList() {
		String selection = "";
		while(true) {
			System.out.println("Add List");
			this.currentUser.getPlanner().displayLists();
			System.out.print("Enter the name of your new list (0 to Exit):\n>");
			selection = in.nextLine();
			this.clearConsole();
			if(selection.equals("0")) {
				return;
			}
			else {
				this.currentUser.getPlanner().addList(selection);
				return;
			}
		}
	}
	
	/**
	 * This method handles the logic for deleting a list made by the user.
	 */
	private void deleteList() {
		String selection = "";
		while(true) {
			System.out.println("Delete List");
			this.currentUser.getPlanner().displayLists();
			System.out.print("Enter the name of the list to delete (0 to Exit):\n>");
			selection = in.nextLine();
			this.clearConsole();
			if(selection.equals("0")) {
				return;
			}
			else {
				if(!this.listExists(selection)) {
					System.out.println(selection + " does not exist.");
				}
				else {
					this.currentUser.getPlanner().deleteList(selection);
					return;
				}
			}
		}
	}
	
	/**
	 * This is a method for clearing the console. It prints 50 emtpy lines. Should clear most consoles.
	 */
	private void clearConsole() {
		for(int i = 0; i < 50; i++) {
			System.out.print("\n");
		}
	}
	
	/**
	 * This method logs out the current user. The userLoggedIn flag is set to false and the currentUser is set to point to null.
	 */
	private void logout() {
		this.userLoggedIn = false;
		this.currentUser = null;
	}
}
