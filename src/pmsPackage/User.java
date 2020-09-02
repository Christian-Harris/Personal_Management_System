package pmsPackage;

/**
 * <h2>User<h2>
 * <p>This class implements a User object describing a user for the application.
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
	
	public Planner getPlanner() {
		return this.userPlanner;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
}
