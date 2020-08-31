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
	
	public void removeList(String s) {
		for(int i = 0; i < this.lists.size(); i++) {
			if(this.lists.get(i).getName().equals(s)) {
				lists.remove(i);
			}
		}
	}
	
	public ArrayList<List> getLists(){
		return this.lists;
	}
	
	public LocalDate getCurrentDate() {
		return this.currentDate;
	}
	
	public void displayPlanner() {
		System.out.println(this.getCurrentDate().getMonth());
		LocalDate firstOfMonth = LocalDate.of(this.getCurrentDate().getYear(), this.getCurrentDate().getMonth(), 1);
		//Monday = 1, Tuesday = 2, ..., Sunday = 7
		int firstDayOfCurrentMonth = firstOfMonth.getDayOfWeek().getValue();
		System.out.println("Su\t\tMo\t\tTu\t\tWe\t\tTh\t\tFr\t\tSa");
		String days = "";
		for(int i = 0; i < (firstDayOfCurrentMonth % 7); i++) {
			days += "\t\t";
		}
		for(int i = 1; i <= firstOfMonth.lengthOfMonth(); i++) {
			if(this.hasEvent(LocalDate.of(this.getCurrentDate().getYear(), this.getCurrentDate().getMonthValue(), i))) {
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
	
	private boolean hasEvent(LocalDate ld) {
		for(int i = 0; i < this.events.size(); i++) {
			if(ld.compareTo(this.events.get(i).getStartTime().toLocalDate()) == 0) {
				return true;
			}
			if(this.events.get(i).doesRepeat() && ld.getDayOfWeek().equals(this.events.get(i).getStartTime().getDayOfWeek()) && ld.compareTo(this.events.get(i).getStartTime().toLocalDate()) > 0) {
				return true;
			}
		}
		return false;
	}
	
	public void constructEvent(Scanner in) {
		String yearString = "";
		String monthString = "";
		String dayString = "";
		String startTimeHourString = "";
		String startTimeMinuteString = "";
		String endTimeHourString = "";
		String endTimeMinuteString = "";
		int startTimeHour = 0;
		int startTimeMinute = 0;
		int endTimeHour = 0;
		int endTimeMinute = 0;
		int year = 0;
		int month = 0;
		int day = 0;
		String description = "";
		String location = "";
		boolean repeats = false;
		
		String selection = "";
		
		while(true) {
			this.displayEventDetails(yearString, monthString, dayString, startTimeHourString, startTimeMinuteString, endTimeHourString, endTimeMinuteString, description, location, repeats);
			System.out.print("Select a field to set (0 to exit):\n9) Submit\n>");
			selection = in.nextLine();
			if(selection.equals("0")) {
				return;
			}
			else if(selection.equals("1")) {
				while(true) {
					System.out.print("Enter the year (0 to exit):\n>");
					selection = in.nextLine();
					if(selection.equals("0")) {
						break;
					}
					else{
						try {
							year = Integer.parseInt(selection);
							yearString = selection;
							break;
						}catch(NumberFormatException ex) {
							System.out.println(selection + " is not a valid year.");
							continue;
						}
					}
				}
			}
			else if(selection.equals("2")) {
				while(true) {
					System.out.print("Enter the month (0 to exit):\n>");
					selection = in.nextLine();
					if(selection.equals("0")) {
						break;
					}
					else if(selection.equalsIgnoreCase("January") || selection.equals("1")) {
						monthString = "January";
						month = 1;
					}
					else if(selection.equalsIgnoreCase("February") || selection.equals("2")){
						monthString = "February";
						month = 2;
					}
					else if(selection.equalsIgnoreCase("March") || selection.equals("3")){
						monthString = "March";
						month = 3;
					}
					else if(selection.equalsIgnoreCase("April") || selection.equals("4")){
						monthString = "April";
						month = 4;
					}
					else if(selection.equalsIgnoreCase("May") || selection.equals("5")){
						monthString = "May";
						month = 5;
					}
					else if(selection.equalsIgnoreCase("June") || selection.equals("6")){
						monthString = "June";
						month = 6;
					}
					else if(selection.equalsIgnoreCase("July") || selection.equals("7")){
						monthString = "July";
						month = 7;
					}
					else if(selection.equalsIgnoreCase("August") || selection.equals("8")){
						monthString = "August";
						month = 8;
					}
					else if(selection.equalsIgnoreCase("September") || selection.equals("9")){
						monthString = "September";
						month = 9;
					}
					else if(selection.equalsIgnoreCase("October") || selection.equals("10")){
						monthString = "October";
						month = 10;
					}
					else if(selection.equalsIgnoreCase("November") || selection.equals("11")){
						monthString = "November";
						month = 11;
					}
					else if(selection.equalsIgnoreCase("December") || selection.equals("12")){
						monthString = "December";
						month = 12;
					}
					else {
						System.out.println(selection + " is not a valid month.");
						continue;
					}
					break;
				}
			}
			else if(selection.equals("3")) {
				System.out.print("Enter the day of the month:\n>");
				selection = in.nextLine();
				try {
					day = Integer.parseInt(selection);
					dayString = selection;
				}catch(NumberFormatException ex) {
					System.out.println(selection + " is not a valid day value.");
				}
			}
			else if(selection.equals("4")) {
				while(true) {
					System.out.println("Enter a starting hour:\n>");
					selection = in.nextLine();
					try {
						int temp = Integer.parseInt(selection);
						if(temp < 0 || temp > 24) {
							System.out.println(selection + " is not a valid hour.");
						}
						else {
							startTimeHour = temp;
							startTimeHourString = selection;
							break;
						}
					}catch(NumberFormatException ex) {
						System.out.println(selection + " is not a valid hour.");
					}
				}
				while(true) {
					System.out.println("Enter a starting minute:\n>");
					selection = in.nextLine();
					try {
						int temp = Integer.parseInt(selection);
						if(temp < 0 || temp > 59) {
							System.out.println(selection + " is not a valid minute.");
						}
						else {
							startTimeMinute = temp;
							startTimeMinuteString = selection;
							break;
						}
					}catch(NumberFormatException ex) {
						System.out.println(selection + " is not a valid minute.");
					}
				}
				
			}
			else if(selection.equals("5")) {
				while(true) {
					System.out.println("Enter an ending hour:\n>");
					selection = in.nextLine();
					try {
						int temp = Integer.parseInt(selection);
						if(temp < 0 || temp > 24) {
							System.out.println(selection + " is not a valid hour.");
						}
						else {
							endTimeHour = temp;
							endTimeHourString = selection;
							break;
						}
					}catch(NumberFormatException ex) {
						System.out.println(selection + " is not a valid hour.");
					}
				}
				while(true) {
					System.out.println("Enter an ending minute:\n>");
					selection = in.nextLine();
					try {
						int temp = Integer.parseInt(selection);
						if(temp < 0 || temp > 59) {
							System.out.println(selection + " is not a valid minute.");
						}
						else {
							endTimeMinute = temp;
							endTimeMinuteString = selection;
							break;
						}
					}catch(NumberFormatException ex) {
						System.out.println(selection + " is not a valid minute.");
					}
				}
			}
			else if(selection.equals("6")) {
				System.out.print("Enter a description for the event:\n>");
				description = in.nextLine();
			}
			else if(selection.equals("7")) {
				System.out.print("Enter a location for the event:\n>");
				location = in.nextLine();
			}
			else if(selection.equals("8")){
				if(repeats) {
					repeats = false;
				}
				else {
					repeats = true;
				}
			}
			else if(selection.equals("9")) {
				try {
					LocalDateTime startTime = LocalDateTime.of(year,  month, day, startTimeHour, startTimeMinute);
					LocalDateTime endTime = LocalDateTime.of(year,  month, day, endTimeHour, endTimeMinute);
					this.addEvent(new Event(startTime, endTime, description, location, repeats));
					return;
				}catch(DateTimeException ex) {
					System.out.println("Selected day does not exist.");
				}
			}
			else {
				System.out.println("Please select 0 to exit, 1-5 for entries, or 6 to submit.");
			}
		}
	}
	
	public void viewDailyEvents(Scanner in) {
		String selection = "";
		int lengthOfMonth = this.getCurrentDate().getMonth().length(this.getCurrentDate().isLeapYear());
		while(true) {
			System.out.print("Please enter a day to view(0 to " + lengthOfMonth + "):\n>");
			selection = in.nextLine();
			try {
				int numericalSelection = Integer.parseInt(selection);
				if(numericalSelection > 0 && numericalSelection <= lengthOfMonth) {
					LocalDate selectedDate = LocalDate.of(this.getCurrentDate().getYear(), this.getCurrentDate().getMonth(), numericalSelection);
					for(int i = 0; i < this.events.size(); i++) {
						if(this.events.get(i).doesRepeat() && this.events.get(i).getStartTime().getDayOfWeek().equals(selectedDate.getDayOfWeek()) && selectedDate.compareTo(this.events.get(i).getStartTime().toLocalDate()) > 0) {
							this.events.get(i).printEvent();
						}
					}
					break;
				}
			}catch(NumberFormatException ex) {
				System.out.println(selection + " is not an available day.");
			}
		}
	}
	
	private void displayEventDetails(String year, String month, String day, String startHour, String startMinute, String endHour, String endMinute, String description, String location, boolean repeats) {
		String details = "1) Year: " + year + "\n2) Month: " + month + "\n3) Day: " + day + "\n4) Start Time: "+ startHour + ":" + startMinute + "\n5) End Time: " + endHour + ":" + endMinute + "\n6) Description: " + description + "\n7) Location: " + location + "\n8) Toggle Repeats:" + repeats;
		System.out.println(details);
	}
	
	public void displayLists(Scanner in) {
		String selection = "";
		while(true) {
			System.out.println("Select a list:");
			//System.out.println("Bugging line 1");
			for(int i = 0; i < this.lists.size(); i++) {
				System.out.println(this.lists.get(i).getName());
			}
			System.out.print("0) Exit\n1) Add list\n2) Delete list\n>");
			selection = in.nextLine();
			if(selection.equals("0")) {
				return;
			}
			else if(selection.equals("1")) {
				System.out.print("Enter the name of the list:\n>");
				selection = in.nextLine();
				if(listExists(selection)) {
					System.out.println("List " + selection + " already exists.");
					continue;
				}
				else {
					this.lists.add(new List(selection));
				}
			}
			else if(selection.equals("2")) {
				System.out.print("Enter the name of the list to delete:\n>");
				selection = in.nextLine();
				if(!listExists(selection)) {
					System.out.println(selection + " is not a current list.");
				}
				else {
					this.removeList(selection);
				}
			}
			else {
				if(!listExists(selection)) {
					System.out.println("List " + selection + "does not exist.");
				}
				else {
					this.getList(selection).display(in);
				}
			}
		}
	}
	
	public boolean listExists(String s) {
		for(int i = 0; i < this.lists.size(); i++) {
			if(this.lists.get(i).getName().equals(s)){
				return true;
			}
		}
		return false;
	}
	
	public List getList(String s) {
		int index = 0;
		for(int i = 0; i < this.lists.size(); i++) {
			if(this.lists.get(i).getName().equals(s)) {
				index = i;
			}
		}
		return this.lists.get(index);
	}
	
	public void viewAllEvents(Scanner in) {
		String selection = "";
		while(true) {
			for(int i = 1; i <= this.events.size(); i++) {
				System.out.println("Event: " + i);
				this.events.get(i - 1).printEvent();
				System.out.print("\n");
			}
			System.out.print("0) Exit\nD) Delete Event\n>");
			selection = in.nextLine();
			if(selection.equals("0")) {
				return;
			}
			else if(selection.equalsIgnoreCase("D")) {
				if(this.events.size() == 0) {
					System.out.println("There are no events to delete.");
				}
				else {
					System.out.println("Enter the number of the event to delete:\n>");
					selection = in.nextLine();
					try {
						int eventNumber = Integer.parseInt(selection);
						if(eventNumber < 1 || eventNumber > this.events.size()) {
							System.out.println("Events number from " + 1 + " to " + this.events.size());
							continue;
						}
						else {
							this.events.remove(eventNumber - 1);
						}
					}catch(NumberFormatException ex) {
						System.out.println(selection + "is not a valid selection.");
					}
				}
			}
			else {
				System.out.println(selection + " is not a valid selection.");
			}
		}
	}
}
