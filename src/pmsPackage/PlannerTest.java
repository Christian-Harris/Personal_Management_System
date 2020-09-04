package pmsPackage;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class PlannerTest {
	private Planner myPlanner = new Planner();
	

	@Test
	public void testHasEvent() {
		myPlanner.addEvent(new Event("myEvent", LocalDate.of(2020, 9, 4), LocalTime.of(10, 0), LocalTime.of(18, 0)));
		assertEquals(myPlanner.hasEvent(LocalDate.of(2020, 9, 4)), true);
		assertEquals(myPlanner.hasEvent(LocalDate.of(2019, 9, 4)), false);
		assertEquals(myPlanner.hasEvent(LocalDate.of(2020, 9, 14)), false);
	}
	
	@Test
	public void testEventExists() {
		myPlanner.addEvent(new Event("myEvent", LocalDate.of(2020, 9, 4), LocalTime.of(10, 0), LocalTime.of(18, 0)));
		assertEquals(myPlanner.eventExists("myEvent"), true);
		assertEquals(myPlanner.eventExists(" myEvent"), false);
		assertEquals(myPlanner.eventExists("MyEvent"), false);
	}
	
	@Test
	public void testEventHasList() {
		myPlanner.addList("myList");
		myPlanner.addEvent(new Event("event with list", LocalDate.of(2020, 9, 4), LocalTime.of(12, 0), LocalTime.of(18, 30), "test", "school", "myList", false, ""));
		assertEquals(myPlanner.eventHasList("myEvent"), false);
		assertEquals(myPlanner.eventHasList("event with list"), true);
		assertEquals(myPlanner.eventHasList("event"), false);
	}
	
	@Test
	public void testGetEventListName() {
		myPlanner.addEvent(new Event("myEvent", LocalDate.of(2020, 9, 4), LocalTime.of(10, 0), LocalTime.of(18, 0)));
		myPlanner.addList("myList");
		myPlanner.addEvent(new Event("event with list", LocalDate.of(2020, 9, 4), LocalTime.of(12, 0), LocalTime.of(18, 30), "test", "school", "myList", false, ""));
		assertEquals(myPlanner.getEventListName("myEvent"), "");
		assertEquals(myPlanner.getEventListName("event with list"), "myList");
	}
	
	@Test
	public void testListExists() {
		myPlanner.addList("myList");
		assertEquals(myPlanner.listExists("myList"), true);
		assertEquals(myPlanner.listExists("list"), false);
		assertEquals(myPlanner.listExists("my List"), false);
	}

}
