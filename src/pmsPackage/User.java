package pmsPackage;

import java.util.*;

/**
 * <h2>User<h2>
 * <p>This class implements a User object describing a user for the applicatoin.
 * <p>Created on 31 August 2020
 * @author Christian Harris
 */

 class User {
	
	private String username = "";
	private String password = "";
	private Planner userPlanner = new Planner();
		
	public User(String u, String p) {
		this.username = u;
		this.password = p;
	}
	
	/**
	 * This method returns the username of this User object as a String
	 * <pre>Examples:
	 * {@code getUsername() returns the username of this User object as a String.}
	 * </pre>
	 * @return username (String; the username of this User object.)
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * This method returns the password of this User object as a String
	 * <pre>Examples:
	 * {@code getPassword() returns the password of this User object as a String.}
	 * </pre>
	 * @return password (String; the password of this User object.)
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * This method sets the username of this User object as a String.
	 * <pre>Examples:
	 * {@code setUsername("admin") sets the username of this User object to "admin".}
	 * </pre>
	 */
	public void setUsername(String u) {
		this.username = u;
	}
	
	/**
	 * This method sets the password of this User object as a String.
	 * <pre>Examples:
	 * {@code setPassword("password") sets the password of this User object to "password".}
	 * </pre>
	 */
	public void setPassword(String p) {
		this.password = p;
	}
	
	/**
	 * This method returns a reference to the Planner object for this User.
	 * <pre>Examples:
	 * {@code getPlanner() returns the Planner object for this User.}
	 * </pre>
	 * @return planner (Planner; the Planner object for this User.)
	 */
	public Planner getPlanner() {
		return this.userPlanner;
	}
	
	/**
	 * This method implements the calendar screen for the application.
	 */
	public void loadPlanner(Scanner in) {
		String selection = "";
		while(true) {
			this.getPlanner().displayPlanner();
			System.out.print("\n0) Logout\n1) Add Event\n2) View Daily Events\n3) View All Events\n4) Go to lists\n>");
			selection = in.nextLine();
			if(selection.equals("0")) {
				return;
			}
			else if(selection.equals("1")) {
				this.getPlanner().constructEvent(in);
			}
			else if(selection.equals("2")) {
				this.getPlanner().viewDailyEvents(in);
			}
			else if(selection.equals("3")) {
				this.getPlanner().viewAllEvents(in);
			}
			else if(selection.equals("4")) {
				this.getPlanner().displayLists(in);
			}
			else {
				System.out.println(selection + " is not a valid selection.");
			}
		}
	}

}
