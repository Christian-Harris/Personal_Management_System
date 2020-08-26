package pmsPackage;

import java.util.*;

public class Planner {
	
	private ArrayList<Event> events = new ArrayList<Event>();
	private ArrayList<List> lists = new ArrayList<List>();
	
	public Planner() {}
	
	public void addEvent(Event e) {
		this.events.add(e);
	}
	
	public void addList(List l) {
		this.lists.add(l);
	}

}
