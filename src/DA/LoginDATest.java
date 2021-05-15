package DA;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import Model.User;

class LoginDATest {
	@InjectMocks private LoginDA testLoginDA;
	@Mock private Connection mockConnection;
	@Mock private Statement mockStatement;
	String connectionURL = "jdbc:mysql://remotemysql.com/592U4BDIk7";
    
	@Test
	void testLoginDA() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		testLoginDA = new LoginDA(mockConnection);
		testLoginDA.conn = DriverManager.getConnection(connectionURL, "592U4BDIk7", "vlwxTrDLFb");
	}
	
	@Test
	void testLoginDA1() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		testLoginDA = new LoginDA(mockConnection);
		testLoginDA.conn = null;
	}
	
	@Test
	void testCheckUserLogin() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		DatabaseConnector dbcon = DatabaseConnector.getInstance();
        dbcon.openConnection();
		testLoginDA = new LoginDA(dbcon.getConnection());
		testLoginDA.checkUserLogin("tanuj.deria@gmail.com", "Test@123");
	}
	
	@Test
	void testCheckUserLogin1() {
		testLoginDA = new LoginDA(mockConnection);
		testLoginDA.checkUserLogin("jayant.bhopale@gmail.com", "testPassword");
		
	}
	/*@Test
	  public void testMockDBConnection() throws Exception {
		testLoginDA.conn = DriverManager.getConnection(connectionURL, "592U4BDIk7", "vlwxTrDLFb");
		Statement stmt = testLoginDA.conn.createStatement();
		
	    testLoginDA = new LoginDA(mockConnection);
		User value = testLoginDA.checkUserLogin("jayant.bhopale@gmail.com", "testPassword");
	    User test = new User();
	    test.setfName("Jayant");
		assertEquals(test.getfName(), value.getfName());
	    Mockito.verify(mockConnection.createStatement(), Mockito.times(1));
	  }
	*/
	@Test
	void testCheckUserLogin2() {
		testLoginDA = new LoginDA(mockConnection);
		testLoginDA.checkUserLogin(null, "testPassword");
	}

	@Test
	void testCheckUserLogin3() {
		testLoginDA = new LoginDA(mockConnection);
		testLoginDA.checkUserLogin("", "testPassword");
	}

}
