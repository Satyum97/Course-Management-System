package DA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnector {
	private DatabaseConnector(){
		
	}
	Connection conn;
	Statement stmt;
	public static DatabaseConnector dbConnector;
	
	public static DatabaseConnector getInstance() {
		if(dbConnector == null)dbConnector = new DatabaseConnector();
		return dbConnector;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void openConnection() throws InstantiationException, IllegalAccessException{
        try {
        	String connectionURL = "jdbc:mysql://remotemysql.com/592U4BDIk7";
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            conn = DriverManager.getConnection(connectionURL, "592U4BDIk7", "vlwxTrDLFb");
        } 
        catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception ex) {
        	Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
		}
        
    }
    
    public void closeConnection(){
        try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
