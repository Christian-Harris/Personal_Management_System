# Personal_Management_System
Personal Management System Application

## Synopsis
The Personal Management System is a personal calendar application which can track cutstom repeatable events. Also contains a checklist functionality.

## Motivation
I built this as a class project. I wanted a program that I could continue to work on and customize in the future.

## How to Run
The current version runs in a console. Simply run the main method of the PersonalManagementSystem class.

## Code Example
The following code constructs a string which when printed to the console displays a calendar. It is robust enough to account for leap years and will work for any date
allowable by the java.time.LocalDate API.

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

## Tests

## Contributors
