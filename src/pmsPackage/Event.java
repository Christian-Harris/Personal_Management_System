package pmsPackage;

import java.time.*;

/**
 * <h2>Event<h2>
 * <p>This class implements an Event object describing a calendar event.
 * <p>Created on 31 August 2020
 * @author Christian Harris
 */

class Event {
	
	private String name;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private String description = "";
	private String location = "";
	private String listName = "";
	
	
	public Event(String n, LocalDate day, LocalTime start, LocalTime end) {
		this.name = n;
		date = day;
		startTime = start;
		endTime = end;
	}
	public Event(String n, LocalDate day, LocalTime start, LocalTime end, String d, String l) {
		name = n;
		date = day;
		startTime = start;
		endTime = end;
		description = d;
		location = l;
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDate(LocalDate d) {
		this.date = d;
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public void setStartTime(LocalTime t) {
		this.startTime = t;
	}
	
	public LocalTime getStartTime() {
		return this.startTime;
	}
	
	public void setEndTime(LocalTime t) {
		this.endTime = t;
	}
	
	public LocalTime getEndTime() {
		return this.endTime;
	}
	
	public void setDescription(String d) {
		this.description = d;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setLocation(String l) {
		this.location = l;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setListName(String name) {
		this.listName = name;
	}
	
	public String getListName() {
		return this.listName;
	}
	
	public String toString() {
		String value = "Name: " + name + "Date: " + this.date.toString() + "\nStart: " + this.startTime.toString() + "\nEnd: " + this.endTime.toString() + "\nDescription: " + this.description + "\nLocation: " + this.location;
		return value;
	}
}
