package pmsPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonalManagementSystemTest {
	PersonalManagementSystem myPMS = new PersonalManagementSystem();

	@Test
	public void testUsernameExists() {
		assertEquals(myPMS.usernameExists("admin"), true);
		assertEquals(myPMS.usernameExists("cHarris"), false);
		assertEquals(myPMS.usernameExists(""), false);
	}
	
	@Test
	public void testCheckPassword() {
		assertEquals(myPMS.checkPassword("admin", "password"), true);
		assertEquals(myPMS.checkPassword("admin",  "Password"), false);
		assertEquals(myPMS.checkPassword("cHarris", "pswd"), false);
	}
}
