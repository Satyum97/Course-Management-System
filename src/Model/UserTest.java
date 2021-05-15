package Model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import DA.CourseFetchDA;

class UserTest {
	@InjectMocks private User testUser;
	 
	@Test
	void testGetUserId() {
		testUser = new User();
		testUser.setUserId(10);
		assertEquals(10,testUser.getUserId());
	}
	
	@Test
	void testGetEmail() {
		testUser = new User();
		testUser.setEmail("testmail@testmail.com");
		assertEquals("testmail@testmail.com",testUser.getEmail());
	}

	@Test
	void testGetfName() {
		testUser = new User();
		testUser.setfName("TestFirstName");
		assertEquals("TestFirstName", testUser.getfName());
	}

	@Test
	void testGetlName() {
		testUser = new User();
		testUser.setlName("TestLastName");
		assertEquals("TestLastName", testUser.getlName());
	}


	@Test
	void testGetAddress() {
		testUser = new User();
		testUser.setAddress("Dallas");
		assertEquals("Dallas", testUser.getAddress());
	}


	@Test
	void testGetPhone() {
		testUser = new User();
		testUser.setPhone("469280585");
		assertEquals("469280585", testUser.getPhone());
	}


	@Test
	void testGetPincode() {
		testUser = new User();
		testUser.setPincode(75252);
		assertEquals(75252, testUser.getPincode());
	}

	@Test
	void testGetCity() {
		testUser = new User();
		testUser.setCity("Dallas");
		assertEquals("Dallas", testUser.getCity());
	}


	@Test
	void testGetGender() {
		testUser = new User();
		testUser.setGender("Male");
		assertEquals("Male", testUser.getGender());
	}

	@Test
	void testGetRole() {
		testUser = new User();
		testUser.setRole("Student");
		assertEquals("Student", testUser.getRole());
	}
	
	@Test
	void setUser() {
		testUser = new User(1,
							"test@gmailc.com",
							"firstName",
							"LastName",
							"Address1",
							"4625847598",
							75252,
							"Dallas",
							"male",
							"student"
				);		
	}
	@Test
	void setUser3() {
		testUser = new User("test@gmailc.com",
							"firstName",
							"LastName"
				);		
	}

}
