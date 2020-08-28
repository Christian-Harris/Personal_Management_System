package pmsPackage;

import java.util.*;
import java.time.*;

class Planner {
	
	private ArrayList<Event> events = new ArrayList<Event>();
	private ArrayList<List> lists = new ArrayList<List>();
	private LocalDate currentDate = LocalDate.now();
	
	public Planner() {}
	
	public void addEvent(Event e) {
		this.events.add(e);
	}
	
	public void addList(List l) {
		this.lists.add(l);
	}
	
	public LocalDate getCurrentDate() {
		return this.currentDate;
	}
	
	public void displayPlanner() {
		System.out.println(this.getCurrentDate().getMonth());
		System.out.println("Su\t\tMo\t\tTu\t\tWe\t\tTh\t\tFr\t\tSa");
	}

}
