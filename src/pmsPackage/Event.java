package pmsPackage;

import java.time.*;

/**
 * <h2>Event</h2>
 * <p>This class implements an Event object describing a calendar event. Events can be marked repeatable and contain a String object called a repetition mask.
 * This mask is an ordered list of single characters denoting the days of the week to repeat. For example a repetition mask of "MWF" would mean to repeat every Monday, Wednesday, and Friday.</p>
 * <p>Created on 31 August 2020</p>
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
	private String repetionMask = "";
	private LocalDate endDate;
	
	/**
	 * Constructs an event with the minimum parameters needed to describe an event.
	 * @param name - the name of the event.
	 * @param startDate - the date the event begins on.
	 * @param startTime - the time the event begins.
	 * @param endTime - the time the Eveeventnt ends.
	 */
	public Event(String name, LocalDate startDate, LocalTime startTime, LocalTime endTime) {
		this.name = name;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/**
	 * Constructs an event with additional event information.
	 * @param name - the name of the event.
	 * @param startDate - the date the event begins on.
	 * @param startTime - the time the event begins.
	 * @param endTime - the time the event ends.
	 * @param description - a description of the event.
	 * @param location - the location of the event.
	 * @param listName - the name of the List associated with the event.
	 * @param repeats - determines if the event is set to repeat.
	 * @param repetionMask - a formatted String encoding which days of the week the event repeats on.
	 */
	public Event(String name, LocalDate startDate, LocalTime startTime, LocalTime endTime, String description, String location, String listName, boolean repeats, String repetionMask) {
		this.name = name;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.location = location;
		this.listName = listName;
		this.repeats = repeats;
		this.repetionMask = repetionMask;
	}
	
	/**
	 * Constructs an event with additional Event information.
	 * @param name - the name of the event.
	 * @param startDate - the date the event begins on.
	 * @param startTime - the time the event begins.
	 * @param endTime - the time the event ends.
	 * @param description - a description of the event.
	 * @param location - the location of the event.
	 * @param listName - the name of the List associated with the event.
	 * @param repeats - determines if the event is set to repeat.
	 * @param repetionMask - a formatted String encoding which days of the week the event repeats on.
	 *@param endDate - the date the event is set to stop repeating.
	 */
	public Event(String name, LocalDate startDate, LocalTime startTime, LocalTime endTime, String description, String location, String listName, boolean repeats, String repetionMask, LocalDate endDate) {
		this.name = name;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.location = location;
		this.listName = listName;
		this.repeats = repeats;
		this.repetionMask = repetionMask;
		this.endDate = endDate;
	}
	
	/**
	 * This method returns the name of this event.
	 * @return - the name of this event.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method returns the start date of this event.
	 * @return - the start date of this event.
	 */
	public LocalDate getStartDate() {
		return this.startDate;
	}
	
	/**
	 * This method returns the start time of this event.
	 * @return - the start time of this event.
	 */
	public LocalTime getStartTime() {
		return this.startTime;
	}
	
	/**
	 * This method returns the end time of this event.
	 * @return - the end time of this event.
	 */
	public LocalTime getEndTime() {
		return this.endTime;
	}
	
	/**
	 * This method returns the description of this event.
	 * @return - the description of this event.
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * This method returns the location of this event.
	 * @return - the location of this event.
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * This method sets the name of the List object associated with this event.
	 * @param name - the name of the List object associated with this event.
	 */
	public void setListName(String name) {
		this.listName = name;
	}
	
	/**
	 * This method gets the name of the List object associated with this event.
	 * @return - the name of the List object associated with this event.
	 */
	public String getListName() {
		return this.listName;
	}
	
	/**
	 * This method constructs a formatted String containing all the details of this Event.
	 * @return - a formatted String containing all the details of this event.
	 */
	public String toString() {
		String value = "Name: " + name + "\nStart Date: " + this.startDate.toString() + "\nStart: " + this.startTime.getHour() + ":" + this.startTime.getMinute() + "\nEnd: " + this.endTime.getHour() + ":" + this.endTime.getMinute() + "\nDescription: " + this.description + "\nLocation: " + this.location + "\nList: " + this.listName;
		return value;
	}
	
	/**
	 * This method prints the contents of this Event to the console.
	 */
	public void display() {
		System.out.println(this.toString());
	}
	
	/**
	 * This method returns true if this Event is set to repeat and false otherwise.
	 * @return - the repeats field of this Event.
	 */
	public boolean repeats() {
		return this.repeats;
	}
	
	/**
	 * This method returns the repition mask encoding which days this event is set to repeat.
	 * @return - the repition mask encoding which days this event is set to repeat.
	 */
	public String getRepitionMask() {
		return this.repetionMask;
	}
	
	/**
	 * This method sets the end date on which this event is set to stop repeating.
	 * @param endDate - the end date on which this event is set to stop repeating.
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * This method returns the end date on which this event is set to stop repeating.
	 * @return - the end date on which this event is set to stop repeating.
	 */
	public LocalDate getEndDate() {
		return this.endDate;
	}
	
	/**
	 * This method determines if this event is set to repeat on day.
	 * @param day - the DayOfWeek to test.
	 * @return - true if this event repeats on day, false otherwise.
	 */
	public boolean repeatsOn(DayOfWeek day) {
		boolean value = false;
		if(day.equals(DayOfWeek.MONDAY) && this.repetionMask.contains("M".subSequence(0, 1))) {
			value = true;
		}
		else if(day.equals(DayOfWeek.TUESDAY) && this.repetionMask.contains("T".subSequence(0, 1))) {
			value = true;
		}
		else if(day.equals(DayOfWeek.WEDNESDAY) && this.repetionMask.contains("W".subSequence(0, 1))) {
			value = true;
		}
		else if(day.equals(DayOfWeek.THURSDAY) && this.repetionMask.contains("H".subSequence(0, 1))) {
			value = true;
		}
		else if(day.equals(DayOfWeek.FRIDAY) && this.repetionMask.contains("F".subSequence(0, 1))) {
			value = true;
		}
		else if(day.equals(DayOfWeek.SATURDAY) && this.repetionMask.contains("S".subSequence(0, 1))) {
			value = true;
		}
		else if(day.equals(DayOfWeek.SUNDAY) && this.repetionMask.contains("U".subSequence(0, 1))) {
			value = true;
		}
		return value;
	}
}
