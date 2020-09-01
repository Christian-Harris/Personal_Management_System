package pmsPackage;

import java.time.*;

/**
 * <h2>Event<h2>
 * <p>This class implements an Event object describing a calendar event.
 * <p>Created on 31 August 2020
 * @author Christian Harris
 */

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
	
	/**
	 * This method returns true if this Event is set to repeat.
	 * <pre>Examples:
	 * {@code doesRepeat() returns true if this Event is set to repeat.}
	 * </pre>
	 * @return repeats (boolean; the parameter determining whether or not this Event is set to repeat.)
	 */
	public boolean doesRepeat() {
		return this.repeats;
	}
	
	/**
	 * This method returns the LocalDateTime describing the start time of this Event.
	 * <pre>Examples:
	 * {@code getStartTime() returns the LocalDateTime describing the start time of this Event.}
	 * </pre>
	 * @return startTime (LocalDateTime; the field describing the start time of this Event.)
	 */
	public LocalDateTime getStartTime() {
		return this.startTime;
	}
	
	/**
	 * This method returns the LocalDateTime describing the end time of this Event.
	 * <pre>Examples:
	 * {@code getEndTime() returns the LocalDateTime describing the end time of this Event.}
	 * </pre>
	 * @return endTime (LocalDateTime; the field describing the end time of this Event.)
	 */
	public LocalDateTime getEndTime() {
		return this.endTime;
	}
	
	/**
	 * This method returns a String describing this Event.
	 * <pre>Examples:
	 * {@code getDescription() returns a String describing this Event.}
	 * </pre>
	 * @return description (String; a description of this Event.)
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * This method returns a String describing this Events location.
	 * <pre>Examples:
	 * {@code getLocation() returns a String describing this Events location.}
	 * </pre>
	 * @return location (String; a description of this Events location.)
	 */
	public String getLocation() {
		return this.location;
	}
	
	/**
	 * This method sets the start time of this Event as a LocalDateTime object.
	 * <pre>Examples:
	 * {@code setStartTime(LocalDateTime d) sets the startTime of this Event to d.}
	 * </pre>
	 */
	public void setStartTime(LocalDateTime d) {
		this.startTime = d;
	}
	
	/**
	 * This method sets the end time of this Event as a LocalDateTime object.
	 * <pre>Examples:
	 * {@code setEndTime(LocalDateTime d) sets the endTime of this Event to d.}
	 * </pre>
	 */
	public void setEndTime(LocalDateTime d) {
		this.endTime = d;
	}
	
	/**
	 * This method sets the description of this Event as a String.
	 * <pre>Examples:
	 * {@code setDescription("School") sets the description field to this Event to "School".}
	 * </pre>
	 */
	public void setDescription(String d) {
		this.description = d;
	}
	
	/**
	 * This method sets the location of this Event as a String.
	 * <pre>Examples:
	 * {@code setDescription("School") sets the location field to this Event to "School".}
	 * </pre>
	 */
	public void setLocation(String l) {
		this.location = l;
	}
	
	/**
	 * This method prints the contents of this Event to the console.
	 */
	public void printEvent() {
		System.out.println("Description: " + description + "\nLocation: " + location + "\nStart Time: " + this.startTime.getHour() + ":" + this.startTime.getMinute() + "\nEnd Time: " + this.endTime.getHour() + ":" + this.endTime.getMinute() + "\nRepeats: " + this.repeats);
	}
}
