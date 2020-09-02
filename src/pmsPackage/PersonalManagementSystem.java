package pmsPackage;

import java.util.*;
import java.time.*;
import java.time.format.*;

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
	private Scanner in = new Scanner(System.in);
	private boolean userLoggedIn = false;
	private boolean calendarViewer = true;
	
	public static void main(String[] args) {
		
		PersonalManagementSystem pms = new PersonalManagementSystem();
		pms.run();
	}
	
	private PersonalManagementSystem(){
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
		Event eventOne = new Event("Shopping", LocalDate.now(), LocalTime.now(), LocalTime.MIDNIGHT, "Grocery Shopping", "Grocery store");
		Event eventTwo = new Event("Future", LocalDate.of(2021,  1, 12), LocalTime.of(12, 0), LocalTime.of(18, 30), "Future Event", "Somewhere");
		admin.getPlanner().addEvent(eventOne);
		admin.getPlanner().addEvent(eventTwo);
		
	}
	
	private void run() {
		this.clearConsole();
		this.mainMenu();
	}
	
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
	
	private boolean usernameExists(String usr) {
		for(int i = 0; i < this.users.size(); i++) {
			if(this.users.get(i).getUsername().equals(usr)) {
				return true;
			}
		}
		return false;
	}
	
	private void setCurrentUser(String usr) {
		for(int i = 0; i < this.users.size(); i++) {
			if(this.users.get(i).getUsername().equals(usr)) {
				currentUser = this.users.get(i);
			}
		}
	}
	
	private boolean checkPassword(String usr, String pswd) {
		for(int i = 0; i < this.users.size(); i++) {
			if(this.users.get(i).getUsername().equals(usr) && this.users.get(i).getPassword().equals(pswd)) {
				return true;
			}
		}
		return false;
	}
	
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
	
	public void addEvent() {
		String name = "";
		String selection = "";
		LocalDate date = LocalDate.now();
		LocalTime startTime = LocalTime.now();
		LocalTime endTime = LocalTime.now();
		String description = "";
		String location = "";
		
		
		String dateString = "";
		String startString = "";
		String endString = "";
		while(true) {
			System.out.println("Add Event");
			System.out.print("1) *Name: " + name + "\n2) *Date: " + dateString + "\n3) *Start: " + startString + "\n4) *End: " + endString + "\n5) Description: " + description + "\n6) Location: " + location + "\n7) Submit\nSelect a field to enter * means required (0 to Exit):\n>");
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
				else if(selection.matches("[a-zA-Z].*")) {
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
				if(name.equals("") || dateString.equals("") || startString.equals("") || endString.equals("")) {
					System.out.println("Missing required field.");
				}
				else {
					this.currentUser.getPlanner().addEvent(new Event(name, date, startTime, endTime, description, location));
					return;
				}
			}
			else {
				System.out.println("Please enter a 1, 2, 3, 4, 5, 6, 7 or 0.");
			}
		}
	}
	
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
	
	private void viewAllEvents() {
		String selection = "";
		while(true) {
			System.out.println("View All Events");
			this.currentUser.getPlanner().displayEvents();
			System.out.println("0) Exit\nEnter event name for details:\n>");
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
	
	private void viewEvent(String eventName) {
		String selection = "";
		while(true) {
			System.out.println("Event: " + eventName);
			this.currentUser.getPlanner().displayEvent(eventName);
			System.out.print("0) Exit\n 1) List\n>");
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
			else {
				System.out.println("Please enter a 1 or 0.");
			}
		}
	}
	
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
	
	private boolean listExists(String name) {
		return this.currentUser.getPlanner().listExists(name);
	}
	
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
	
	private void clearConsole() {
		for(int i = 0; i < 50; i++) {
			System.out.print("\n");
		}
	}
	
	private void logout() {
		this.userLoggedIn = false;
		this.currentUser = null;
	}
}
