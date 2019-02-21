package se.kth.iv1201.grupp13.recruiterapplication.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest {

	@Autowired
	private User user;

	@Test
	public void testUserStringStringStringStringStringRoleString() {
		String name = "John";
		String surname = "gg";
		String ssn = "111111111";
		String email = "aa@bb.com";
		String password = "abs123";
		Role role = null;
		String username = "Johnusername";
		user = new User(name, surname, ssn, email, password, role, username);
		assertEquals(name, user.getName());
		assertEquals(surname, user.getSurname());
		assertEquals(ssn, user.getSsn());
		assertEquals(email, user.getEmail());
		assertEquals(password, user.getPassword());
		assertEquals(role, null);
		assertEquals(username, user.getUsername());
	}
}
