package pmsPackage;

import java.util.*;

 class User {
	
	private String username = "";
	private String password = "";
	private Planner userPlanner = new Planner();
		
	public User(String u, String p) {
		this.username = u;
		this.password = p;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setUsername(String u) {
		this.username = u;
	}
	
	public void setPassword(String p) {
		this.password = p;
	}
	
	public Planner getPlanner() {
		return this.userPlanner;
	}
	
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
