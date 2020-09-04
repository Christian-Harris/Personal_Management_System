package pmsPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {

	@Test
	public void testGetContents() {
		assertEquals("eggs", new Item("eggs").getContents());
		assertNotEquals("bread", new Item("toast").getContents());
		assertNotEquals("food", new Item().getContents());
	}
	
	@Test
	public void testToString() {
		Item myItem = new Item("bread");
		assertEquals("-eggs", new Item("eggs").toString());
		assertNotEquals("+bread", myItem.toString());
		myItem.setChecked(true);
		assertEquals("+bread", myItem.toString());
	}

}
