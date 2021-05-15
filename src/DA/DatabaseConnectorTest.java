package DA;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class DatabaseConnectorTest {
	  @InjectMocks private DatabaseConnector dbConnection;
	  @Mock private Connection mockConnection;
	  @Mock private Statement mockStatement;
	  String connectionURL = "jdbc:mysql://remotemysql.com/592U4BDIk7";
  
	  
	@Test
	void testSetConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		dbConnection = DatabaseConnector.getInstance();
		dbConnection.setConnection(mockConnection);
	}
	
	@Test
	void testSetConnection1() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		dbConnection = DatabaseConnector.getInstance();
		dbConnection.setConnection(null);
		dbConnection.openConnection();
	}

	@Test
	void testGetConnection() throws Exception{
		dbConnection = DatabaseConnector.getInstance();
		dbConnection.getConnection();
	}

	@Test
	void testOpenConnection() throws Exception{
		dbConnection = DatabaseConnector.getInstance();
		dbConnection.openConnection();
	}
	
	@Test
	void testCloseConnection() throws Exception{
		dbConnection = DatabaseConnector.getInstance();
		dbConnection.openConnection();
		dbConnection.closeConnection();
	}
	
	@Test
	void testOpenConnection1() throws Exception{
		dbConnection = DatabaseConnector.getInstance();
		dbConnection.setConnection(null);
		dbConnection.openConnection();
		dbConnection.closeConnection();
	}

}
