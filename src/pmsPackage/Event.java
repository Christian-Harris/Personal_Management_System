package pmsPackage;

import java.time.*;

class Event {
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String description;
	private String location;
	private boolean repeats;
	
	public Event(LocalDateTime st, LocalDateTime et, String d, String l, boolean rep) {
		startTime = st;
		endTime = et;
		description = d;
		location = l;
		repeats = rep;
	}
	
	public void setRepeats(boolean rep) {
		this.repeats = rep;
	}
	
	public boolean doesRepeat() {
		return this.repeats;
	}
	
	public LocalDateTime getStartTime() {
		return this.startTime;
	}
	
	public LocalDateTime getEndTime() {
		return this.endTime;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setStartTime(LocalDateTime d) {
		this.startTime = d;
	}
	
	public void setEndTime(LocalDateTime d) {
		this.endTime = d;
	}
	
	public void setDescription(String d) {
		this.description = d;
	}
	
	public void setLocation(String l) {
		this.location = l;
	}
	
	public void printEvent() {
		System.out.println("Description: " + description + "\nLocation: " + location + "\nStart Time: " + this.startTime.getHour() + ":" + this.startTime.getMinute() + "\nEnd Time: " + this.endTime.getHour() + ":" + this.endTime.getMinute() + "\nRepeats: " + this.repeats);
	}
}
