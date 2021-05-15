package DA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Admin;
import Model.Instructor;
import Model.Student;
import Model.User;

public class LoginDA {
	Connection conn;
	Statement stmt;
	
	public LoginDA(Connection conn) {
		this.conn = conn;
	}
	
	public User checkUserLogin(String email, String password) {
		User userObj = null;
		try {
			if(!email.isEmpty() && !password.isEmpty()) {
				String sql = "select * from users where email = '"+email+"' and password='"+password+"'";
	            stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            while(rs.next()){
	            	if(rs.getString("role").equals("student")) {
	            		userObj = new Student(rs.getInt("userId"),rs.getString("email"),rs.getString("first_name"),rs.getString("last_name")
	                		,rs.getString("address"),rs.getString("phone"),rs.getInt("pincode"),rs.getString("city"),rs.getString("gender"),rs.getString("role"));
	            	}
	            	else if(rs.getString("role").equals("admin")) {
	            		userObj = new Admin(rs.getInt("userId"),rs.getString("email"),rs.getString("first_name"),rs.getString("last_name")
		                		,rs.getString("address"),rs.getString("phone"),rs.getInt("pincode"),rs.getString("city"),rs.getString("gender"),rs.getString("role"));
		            }
	            	else {
	            		userObj = new Instructor(rs.getInt("userId"),rs.getString("email"),rs.getString("first_name"),rs.getString("last_name")
		                		,rs.getString("address"),rs.getString("phone"),rs.getInt("pincode"),rs.getString("city"),rs.getString("gender"),rs.getString("role"));
	            	}
	            }
			}
			return userObj;
		}
		catch(Exception ex){
			return null;
		}
	}
}
