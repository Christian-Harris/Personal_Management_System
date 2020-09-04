package pmsPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;

import org.junit.jupiter.api.Test;

class EventTest {
	
	Event eventOne = new Event("Event One", LocalDate.of(2020,  9,  4), LocalTime.of(12, 0), LocalTime.of(18, 30));
	Event eventTwo = new Event("Event Two", LocalDate.of(2020,  9,  1), LocalTime.of(8, 15), LocalTime.of(18, 0), "Home", "86 East 750 South", "myList", false, "");
	Event eventThree = new Event("Event Three", LocalDate.of(2020,  9,  1), LocalTime.of(20, 0), LocalTime.of(21, 0), "Home", "86 East 750 South", "", true, "MTWHF", LocalDate.of(2020, 10, 13));
	@Test
	public void testGetName() {
		assertEquals("Event One", eventOne.getName());
		assertNotEquals("Event One", eventTwo.getName());
		assertEquals("Event Three", eventThree.getName());
	}
	
	@Test
	public void testGetStartDate() {
		assertEquals(LocalDate.of(2020, 9, 4), eventOne.getStartDate());
		assertNotEquals(LocalDate.of(2019, 9, 4), eventOne.getStartDate());
		assertNotEquals(eventOne.getStartDate(), eventTwo.getStartDate());
	}
	
	@Test
	public void testGetStartTime() {
		assertEquals(LocalTime.of(12, 0), eventOne.getStartTime());
		assertNotEquals(LocalTime.of(6, 30), eventOne.getStartTime());
		assertNotEquals(eventTwo.getStartTime(), eventThree.getStartTime());
	}
	
	@Test
	public void testEndTime() {
		assertEquals(LocalTime.of(18, 0), eventTwo.getEndTime());
		assertNotEquals(eventOne.getEndTime(), eventTwo.getEndTime());
		assertNotEquals(eventTwo.getEndTime(), eventThree.getEndTime());
	}
	
	@Test
	public void testGetDescription() {
		assertEquals("", eventOne.getDescription());
		assertNotEquals(eventOne.getDescription(), eventTwo.getDescription());
		assertEquals(eventTwo.getDescription(), eventThree.getDescription());
	}
	
	@Test
	public void testGetLocation() {
		assertEquals("", eventOne.getLocation());
		assertEquals("86 East 750 South", eventTwo.getLocation());
		assertEquals(eventTwo.getLocation(), eventThree.getLocation());
	}
	
	@Test
	public void testGetListName() {
		assertEquals(eventOne.getListName(), eventThree.getListName());
		assertEquals(eventTwo.getListName(), "myList");
		assertNotEquals(eventOne.getListName(), "list");
	}
	
	@Test
	public void testToString() {
		assertEquals(eventOne.toString(), "Name: " + eventOne.getName() + "\nStart Date: " + eventOne.getStartDate().toString() + "\nStart: " + eventOne.getStartTime().getHour() + ":" + eventOne.getStartTime().getMinute() + "\nEnd: " + eventOne.getEndTime().getHour() + ":" + eventOne.getEndTime().getMinute() + "\nDescription: " + eventOne.getDescription() + "\nLocation: " + eventOne.getLocation() + "\nList: " + eventOne.getListName());
		assertEquals(eventTwo.toString(), "Name: " + eventTwo.getName() + "\nStart Date: " + eventTwo.getStartDate().toString() + "\nStart: " + eventTwo.getStartTime().getHour() + ":" + eventTwo.getStartTime().getMinute() + "\nEnd: " + eventTwo.getEndTime().getHour() + ":" + eventTwo.getEndTime().getMinute() + "\nDescription: " + eventTwo.getDescription() + "\nLocation: " + eventTwo.getLocation() + "\nList: " + eventTwo.getListName());
		assertEquals(eventThree.toString(), "Name: " + eventThree.getName() + "\nStart Date: " + eventThree.getStartDate().toString() + "\nStart: " + eventThree.getStartTime().getHour() + ":" + eventThree.getStartTime().getMinute() + "\nEnd: " + eventThree.getEndTime().getHour() + ":" + eventThree.getEndTime().getMinute() + "\nDescription: " + eventThree.getDescription() + "\nLocation: " + eventThree.getLocation() + "\nList: " + eventThree.getListName());
		
	}
	
	@Test
	public void testRepeats() {
		assertEquals(eventOne.repeats(), false);
		assertNotEquals(eventOne.repeats(), true);
		assertEquals(eventThree.repeats(), true);
	}
	
	@Test
	public void testGetEndDate() {
		assertEquals(eventOne.getStartDate(), eventOne.getEndDate());
		assertEquals(eventTwo.getStartDate(), eventTwo.getEndDate());
		assertNotEquals(eventThree.getStartDate(), eventThree.getEndDate());
	}
	
	@Test
	public void testRepeatsOn() {
		assertEquals(eventThree.repeatsOn(DayOfWeek.MONDAY), true);
		assertEquals(eventThree.repeatsOn(DayOfWeek.WEDNESDAY), true);
		assertEquals(eventThree.repeatsOn(DayOfWeek.SUNDAY), false);
	}
}
