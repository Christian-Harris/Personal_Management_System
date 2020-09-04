package pmsPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.*;

class ListTest {

	@Test
	void testGetName() {
		assertEquals("Shopping", new List("Shopping").getName());
		assertNotEquals("Errands", new List("Shopping").getName());
		assertNotEquals("To Do", new List("Errands", new ArrayList<Item>()).getName());
	}

}
