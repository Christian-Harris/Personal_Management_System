package pmsPackage;

/**
 * <h2>User</h2>
 * <p>This class implements a User object describing a user for the application. Users are identified by their username. A password field is used for security.</p>
 * <p>Created on 31 August 2020</p>
 * @author Christian Harris
 */

 class User {
	
	private String username = "";
	private String password = "";
	private Planner userPlanner = new Planner();
		
	/**
	 * Constructs a user with this username set to username and this password set to password. 
	 * @param username - the username of this user.
	 * @param password - the password of this user.
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
	 * This method returns the Planner object for this user.
	 * @return - the Planner object for this user.
	 */
	public Planner getPlanner() {
		return this.userPlanner;
	}
	
	/**
	 * This method returns this users username.
	 * @return - this users username.
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * This method returns this users password.
	 * @return - this users password.
	 */
	public String getPassword() {
		return this.password;
	}
}
