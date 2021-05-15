package DA;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class SignupDATest {
	 @InjectMocks private SignupDA testSignupDA;
	 @Mock private Connection mockConnection;
	 @Mock private Statement mockStatement;
	 String connectionURL = "jdbc:mysql://remotemysql.com/592U4BDIk7";
    
	@Test
	void testSignupDA() throws Exception{
		testSignupDA = new SignupDA(mockConnection);
	}

	@Test
	void testIsExistingUser() {
		testSignupDA = new SignupDA(mockConnection);
		testSignupDA.createUser("test1@gmail.com", "testPswd","male", "UTdallas", "Dallas", "4692580585", 75252, "Dallas", "TestFirstName", "TestLastName", "Student");
	}
	
	@Test
	void testIsExistingUserNull() {
		testSignupDA = new SignupDA(mockConnection);
		testSignupDA.createUser(null, "testPswd","male", "UTdallas", "Dallas", "4692580585", 75252, "Dallas", "TestFirstName", "TestLastName", "Student");
	}
	@Test
	void testIsExistingUser1() {
		testSignupDA = new SignupDA(mockConnection);
		testSignupDA.createUser(null, "testPswd","male", "UTdallas", "Dallas", "4692580585", 75252, "Dallas", "TestFirstName", "TestLastName", "Student");
	}
	@Test
	void testIsExistingUser2() {
		testSignupDA = new SignupDA(mockConnection);
		testSignupDA.createUser(null, "testPswd","male", null, "Dallas", "4692580585", 75252, "Dallas", "TestFirstName", "TestLastName", "Student");
	}
	@Test
	void testIsExistingUser3() {
		testSignupDA = new SignupDA(mockConnection);
		testSignupDA.createUser(null, "testPswd","male", "UTdallas", null, "4692580585", 75252, "Dallas", "TestFirstName", "TestLastName", "Student");
	}

	@Test
	void testIsExistingUser4() {
		testSignupDA = new SignupDA(mockConnection);
		testSignupDA.createUser("", "testPswd","male", "UTdallas", null, "4692580585", 75252, "Dallas", "TestFirstName", "TestLastName", "Student");
	}

	
	@Test
	void testExistingUser() {
		testSignupDA = new SignupDA(mockConnection);
		testSignupDA.isExistingUser("test1@gmail.com");
	}
	
	@Test
	void testExistingUser1() {
		testSignupDA = new SignupDA(mockConnection);
		testSignupDA.isExistingUser(null);
	}
	
	@Test
	void testExistingUser2() {
		testSignupDA = new SignupDA(mockConnection);
		testSignupDA.isExistingUser("");
	}
	
}
