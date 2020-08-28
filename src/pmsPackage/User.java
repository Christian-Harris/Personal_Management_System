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
		while(true) {
			this.getPlanner().displayPlanner();
			System.out.println("0) Logout.");
			String input = in.nextLine();
			if(input.equals("0")) {
				return;
			}
		}
	}

}
