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
	private boolean repeats = false;
	private String repitionMask = "";
	private LocalDate endDate;
	
	
	public Event(String n, LocalDate day, LocalTime start, LocalTime end) {
		this.name = n;
		date = day;
		startTime = start;
		endTime = end;
	}
	public Event(String n, LocalDate day, LocalTime start, LocalTime endT, String d, String l, String ln, boolean r, String rM) {
		name = n;
		date = day;
		startTime = start;
		endTime = endT;
		description = d;
		location = l;
		listName = ln;
		repeats = r;
		repitionMask = rM;
	}
	
	public Event(String n, LocalDate day, LocalTime start, LocalTime endT, String d, String l, String ln, boolean r, String rM, LocalDate endD) {
		name = n;
		date = day;
		startTime = start;
		endTime = endT;
		description = d;
		location = l;
		listName = ln;
		repeats = r;
		repitionMask = rM;
		endDate = endD;
	}
	
	public String getName() {
		return name;
	}
	
	public LocalDate getDate() {
		return this.date;
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
		String value = "Name: " + name + "\nDate: " + this.date.toString() + "\nStart: " + this.startTime.getHour() + ":" + this.startTime.getMinute() + "\nEnd: " + this.endTime.getHour() + ":" + this.endTime.getMinute() + "\nDescription: " + this.description + "\nLocation: " + this.location + "\nList: " + this.listName;
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
	
	public void setEndDate(LocalDate day) {
		this.endDate = day;
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
