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
	private LocalDate startDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String description = "";
	private String location = "";
	private String listName = "";
	private boolean repeats = false;
	private String repitionMask = "";
	private LocalDate endDate;
	
	
	public Event(String name, LocalDate startDate, LocalTime startTime, LocalTime endTime) {
		this.name = name;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public Event(String name, LocalDate startDate, LocalTime startTime, LocalTime endTime, String description, String location, String listName, boolean repeats, String repitionMask) {
		this.name = name;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.location = location;
		this.listName = listName;
		this.repeats = repeats;
		this.repitionMask = repitionMask;
	}
	
	public Event(String name, LocalDate startDate, LocalTime startTime, LocalTime endTime, String description, String location, String listName, boolean repeats, String repitionMask, LocalDate endDate) {
		this.name = name;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.location = location;
		this.listName = listName;
		this.repeats = repeats;
		this.repitionMask = repitionMask;
		this.endDate = endDate;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDate getStartDate() {
		return this.startDate;
	}
	
	public LocalTime getStartTime() {
		return this.startTime;
	}
	
	public LocalTime getEndTime() {
		return this.endTime;
	}
	
	public String getDescription() {
		return this.description;
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
		String value = "Name: " + name + "\nStart Date: " + this.startDate.toString() + "\nStart: " + this.startTime.getHour() + ":" + this.startTime.getMinute() + "\nEnd: " + this.endTime.getHour() + ":" + this.endTime.getMinute() + "\nDescription: " + this.description + "\nLocation: " + this.location + "\nList: " + this.listName;
		return value;
	}
	
	public void display() {
		System.out.println(this.toString());
	}
	
	public boolean repeats() {
		return this.repeats;
	}
	
	public String getRepitionMask() {
		return this.repitionMask;
	}
	
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public LocalDate getEndDate() {
		return this.endDate;
	}
	
	public boolean repeatsOn(DayOfWeek day) {
		boolean value = false;
		if(day.equals(DayOfWeek.MONDAY) && this.repitionMask.contains("M".subSequence(0, 1))) {
			value = true;
		}
		else if(day.equals(DayOfWeek.TUESDAY) && this.repitionMask.contains("T".subSequence(0, 1))) {
			value = true;
		}
		else if(day.equals(DayOfWeek.WEDNESDAY) && this.repitionMask.contains("W".subSequence(0, 1))) {
			value = true;
		}
		else if(day.equals(DayOfWeek.THURSDAY) && this.repitionMask.contains("H".subSequence(0, 1))) {
			value = true;
		}
		else if(day.equals(DayOfWeek.FRIDAY) && this.repitionMask.contains("F".subSequence(0, 1))) {
			value = true;
		}
		else if(day.equals(DayOfWeek.SATURDAY) && this.repitionMask.contains("S".subSequence(0, 1))) {
			value = true;
		}
		else if(day.equals(DayOfWeek.SUNDAY) && this.repitionMask.contains("U".subSequence(0, 1))) {
			value = true;
		}
		return value;
	}
}
