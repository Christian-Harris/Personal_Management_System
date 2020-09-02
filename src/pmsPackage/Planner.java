package pmsPackage;

import java.util.*;
import java.time.*;

/**
 * <h2>Planner<h2>
 * <p>This class implements a Planner object describing an event planner.
 * <p>Created on 31 August 2020
 * @author Christian Harris
 */

class Planner {
	
	private ArrayList<Event> events = new ArrayList<Event>();
	private ArrayList<List> lists = new ArrayList<List>();
	
	public Planner() {}
	
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
	
	private boolean hasEvent(LocalDate date) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getDate().compareTo(date) == 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean eventExists(String name) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public void removeEvent(String name) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getName().equals(name)) {
				this.events.remove(i);
			}
		}
	}
	
	public void displayLists() {
		for(int i = 0; i < this.lists.size(); i++) {
			System.out.println(this.lists.get(i).toString());
		}
	}
	
	public void displayEvents() {
		for(int i = 0; i < this.events.size(); i++) {
			System.out.println(this.events.get(i).getName() + "\n");
		}
	}
	
	public void displayEvents(LocalDate monthToView) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getDate().getMonth().equals(monthToView.getMonth())) {
				System.out.println(this.events.get(i).getName() + "\n");
			}
		}
	}
	
	public void displayEvent(String name) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getName().equals(name)) {
				this.events.get(i).display();
			}
		}
	}
	
	public boolean eventHasList(String eventName) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getName().equals(eventName) && !this.events.get(i).getListName().equals("")) {
				return true;
			}
		}
		return false;
	}
	
	public String getEventListName(String eventName) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getName().equals(eventName)) {
				return this.events.get(i).getListName();
			}
		}
		return "";
	}
	
	public boolean listExists(String name) {
		for(int i = 0; i < this.lists.size(); i++) {
			if(this.lists.get(i).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public void addList(String name) {
		this.lists.add(new List(name));
	}
	
	public void addList(String name, ArrayList<Item> itms) {
		this.lists.add(new List(name, itms));
	}
	
	public void deleteList(String name) {
		for(int i = 0; i < this.lists.size(); i++) {
			if(this.lists.get(i).getName().equals(name)) {
				this.lists.remove(i);
			}
		}
	}
	
	public void displayList(String name) {
		for(int i = 0; i < this.lists.size(); i++) {
			if(this.lists.get(i).getName().equals(name)) {
				this.lists.get(i).display();
			}
		}
	}
	
	public void connectEventList(String eventName, String listName) {
		for(int i = 0; i < this.events.size(); i++) {
			if(this.events.get(i).getName().equals(eventName)) {
				this.events.get(i).setListName(listName);
			}
		}
	}
	
	public List getList(String name) {
		int returnIndex = 0;
		for(int i = 0; i < this.lists.size(); i++) {
			if(this.lists.get(i).getName().equals(name)) {
				returnIndex = i;
			}
		}
		return this.lists.get(returnIndex);
	}
	
	public void addEvent(Event e) {
		this.events.add(e);
	}
}
