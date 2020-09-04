package pmsPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {
	
	private User myUser = new User("admin", "password");

	@Test
	public void testGetUsername() {
		assertEquals(myUser.getUsername(), "admin");
		assertNotEquals(myUser.getUsername(), "ADMIN");
		assertNotEquals(myUser.getUsername(), " admin");
	}
	
	@Test
	public void testGetPassword() {
		assertEquals(myUser.getPassword(), "password");
		assertNotEquals(myUser.getPassword(), "Password ");
		assertNotEquals(myUser.getPassword(), "PASSWORD");
	}

}
