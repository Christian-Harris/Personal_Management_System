package pmsPackage;

import java.util.Date;

public class Event {
	private Date startTime;
	private Date endTime;
	private String description;
	private boolean alert;
	private String location;
	
	public Event(Date st, Date et, String d, boolean a, String l) {
		startTime = st;
		endTime = et;
		description = d;
		alert = a;
		location = l;
	}
	
	public Date getStartTime() {
		return this.startTime;
	}
	
	public Date getEndTime() {
		return this.endTime;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public boolean alertOn() {
		return this.alert;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setStartTime(Date d) {
		this.startTime = d;
	}
	
	public void setEndTime(Date d) {
		this.endTime = d;
	}
	
	public void setDescription(String d) {
		this.description = d;
	}
	
	public void setAlertOn(boolean b) {
		this.alert = b;
	}
	
	public void setLocation(String l) {
		this.location = l;
	}
}
