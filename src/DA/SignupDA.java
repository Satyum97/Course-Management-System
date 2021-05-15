package DA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignupDA {
	Connection conn;
	Statement stmt;
	
	public SignupDA(Connection conn){
		this.conn = conn;
	}
	
	public boolean isExistingUser(String email) {
		try{
			if(email == null || email == "")return true;
			boolean flag = false;
			String sql = "select userid from users where email = '"+email+"'";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                flag = true;
            }
			return flag;
		}
		catch(SQLException ex) {
			Logger.getLogger(SignupDA.class.getName()).log(Level.INFO, null, ex);
			return true;
		}
		catch(Exception ex) {
			Logger.getLogger(SignupDA.class.getName()).log(Level.INFO, null, ex);
			return true;
		}
	}
	
	public boolean createUser(String email,String password, String gender, String address1, 
			String address2, String phone, int pin, String city, String fname, String lname, String role) {
		try {
			String encryptedPass = Base64.getEncoder().encodeToString(password.getBytes());
			String address = "";
			
			if(address1 != null && address2!=null)address = address1+address2;
			else if(address1 != null)address = address1;
			else if(address2!=null)address = address2;
			
			String sql = "Insert into users(email,password,gender,address,first_name,last_name,city,pincode,phone,role) "
					+ "VALUES('"+email+"','"+encryptedPass+"','"+gender+"','"+address+"','"+fname+"','"+lname+"','"+city+"','"+pin+"','"+phone+"','"+role+"')";
			
            stmt = conn.createStatement();
            int numberOfRows = stmt.executeUpdate(sql);
            if(numberOfRows > 0)return true;
			return false;
		}
		catch(Exception ex) {
			Logger.getLogger(SignupDA.class.getName()).log(Level.INFO, null, ex);
			return false;
		}
	}
}
