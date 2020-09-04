package pmsPackage;

import java.util.*;
import java.time.*;

/**
 * <h2>Planner</h2>
 * <p>This class implements a Planner object describing an event planner. The Planner object is responsible for the logic pertaining to displaying calendars and lists.</p>
 * <p>Created on 31 August 2020</p>
 * @author Christian Harris
 */

class Planner {
	
	private ArrayList<Event> events = new ArrayList<Event>();
	private ArrayList<List> lists = new ArrayList<List>();
	
	/**
	 * Constructs a Planner object with and empty Event ArrayList and empty List ArrayList.
	 */
	public Planner() {}
	
	/**
	 * This method displays a calendar based on the LocalDate monthToView. Days with events are prefixed with an *.
	 * @param monthToView - A LocalDate object determining the month and year to display.
	 */
	public void displayCalendar(LocalDate monthToView) {
		int year = monthToView.getYear();
		int month = monthToView.getMonth().getValue();
		LocalDate firstOfMonth = LocalDate.of(year, month, 1);
		//Monday = 1, Tuesday = 2, ..., Sunday = 7
		int firstDayOfCurrentMonth = firstOfMonth.getDayOfWeek().getValue();
		System.out.println("Su\t\tMo\t\tTu\t\tWe\t\tTh\t\tFr\t\tSa");
		String days = "";
		for(int i = 0; i < (firstDayOfCurrentMonth % 7); i++) {
			days += "\t\t";
		}
		for(int i = 1; i <= firstOfMonth.lengthOfMonth(); i++) {
			if(this.hasEvent(LocalDate.of(year, month, i))) {
				days += "*";
			}
			if(((firstDayOfCurrentMonth % 7) + i) % 7 == 0) {
				days += (i + "\n");
			}
			else {
				days += (i + "\t\t");
			}
		}
		System.out.println(days);
	}
	
	/**
	 * This method returns true if date lies on some event in the ArrrayList events. 
	 * If an event is repeatable this method checks to see if the date lies on repeated day and inside the window of repition.
	 * @param date - the date test to see if it lies on or in some event window.
	 * @return - true if the date falls on or in some event window, false otherwise.
	 */
	public boolean hasEvent(LocalDate date) {
		for(int i = 0; i < this.events.size(); i++) {
			/*if(this.events.get(i).getDate().compareTo(date) == 0) {
				return true;
			}*/
			if(this.events.get(i).repeats() && this.events.get(i).getStartDate().compareTo(date) <= 0 && this.events.get(i).getEndDate().compareTo(date) >= 0 && this.events.get(i).repeatsOn(date.getDayOfWeek())) {
				return true;
			}
			else {
				if(this.events.get(i).getStartDate().compareTo(date) == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * This method returns true if there exists some Event in events with with parameter name.
	 * @param name - the name of the event.
	 * @return - true if an Event object with name is in the ArrayList events.
	 */
	public boolean eventExists(String name) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method finds all Events with name in events and removes them.
	 * @param name - the name of the event.
	 */
	public void removeEvent(String name) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getName().equals(name)) {
				this.events.remove(i);
			}
		}
	}
	
	/**
	 * This method prints the details of all the List objects in lists to the console.
	 */
	public void displayLists() {
		for(int i = 0; i < this.lists.size(); i++) {
			System.out.println(this.lists.get(i).toString());
		}
	}
	
	/**
	 * This method prints the names of all the List objects in lists to the console.
	 */
	public void displayEvents() {
		for(int i = 0; i < this.events.size(); i++) {
			System.out.println(this.events.get(i).getName() + "\n");
		}
	}
	
	/**
	 * This method prints the names of all the List objects in lists which lie within the month of the LocalDate monthToView.
	 * @param monthToView - a LocalDate describing which month and year to display.
	 */
	public void displayEvents(LocalDate monthToView) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getStartDate().getMonth().equals(monthToView.getMonth())) {
				System.out.println(this.events.get(i).getName() + "\n");
			}
		}
	}
	
	/**
	 * This method prints the details of all Event objects in events with name.
	 * @param name - the name of the events to display.
	 */
	public void displayEvent(String name) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getName().equals(name)) {
				this.events.get(i).display();
			}
		}
	}
	
	/**
	 * This method returns true if there is an Event object in lists with eventName that has an associated List object.
	 * @param eventName - the name of the event to test.
	 * @return - true if Event eventName has an associated list.
	 */
	public boolean eventHasList(String eventName) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getName().equals(eventName) && !this.events.get(i).getListName().equals("")) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method returns the name of the List object associated with the Event eventName in events.
	 * @param eventName - the name of the Event to retrieve the listName.
	 * @return - the name of the List associated to eventName.
	 */
	public String getEventListName(String eventName) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getName().equals(eventName)) {
				return this.events.get(i).getListName();
			}
		}
		return "";
	}
	
	/**
	 * This method returns true if there exits a List object in lists with name.
	 * @param name - the name of a List object in lists.
	 * @return - true if there exists a List object in lists with name.
	 */
	public boolean listExists(String name) {
		for(int i = 0; i < this.lists.size(); i++) {
			if(this.lists.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method adds a new empty List with name to lists.
	 * @param name - the name of the new list.
	 */
	public void addList(String name) {
		this.lists.add(new List(name));
	}
	
	/**
	 * This method adds a List with name and initialized with the Items in itms.
	 * @param name - the name of the new List.
	 * @param itms - the items inside of the new List.
	 */
	public void addList(String name, ArrayList<Item> itms) {
		this.lists.add(new List(name, itms));
	}
	
	/**
	 * This method finds all List objects in list with name and removes them.
	 * @param name - the name of the List to remove.
	 */
	public void deleteList(String name) {
		for(int i = 0; i < this.lists.size(); i++) {
			if(this.lists.get(i).getName().equals(name)) {
				this.lists.remove(i);
			}
		}
	}
	
	/**
	 * This method prints the details of the List with name to the console.
	 * @param name - the name of a List in lists.
	 */
	public void displayList(String name) {
		for(int i = 0; i < this.lists.size(); i++) {
			if(this.lists.get(i).getName().equals(name)) {
				this.lists.get(i).display();
			}
		}
	}
	
	/**
	 * This method connects an Event with eventName and a List with listName. The connection is based on the names.
	 * @param eventName - the name of an Event.
	 * @param listName - the name of a List.
	 */
	public void connectEventList(String eventName, String listName) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getName().equals(eventName)) {
				this.events.get(i).setListName(listName);
			}
		}
	}
	
	/**
	 * This method returns a List object in lists with name.
	 * @param name - the name of a List in lists.
	 * @return - the List object in lists with name.
	 */
	public List getList(String name) {
		int returnIndex = 0;
		for(int i = 0; i < this.lists.size(); i++) {
			if(this.lists.get(i).getName().equals(name)) {
				returnIndex = i;
			}
		}
		return this.lists.get(returnIndex);
	}
	
	/**
	 * This method adds Event e to events.
	 * @param e - the Event to add to events.
	 */
	public void addEvent(Event e) {
		this.events.add(e);
	}
}
