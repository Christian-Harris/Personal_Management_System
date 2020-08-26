package pmsPackage;

public class User {
	
	private String username = "";
	private String password = "";
	private Planner userPlanner = new Planner();
	
	public User() {}
	
	public User(String u) {
		this.username = u;
	}
	
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

}
