package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DA.DatabaseConnector;
import DA.SignupDA;

import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	public SignupServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			String email = request.getParameter("email");
	        String pwd = request.getParameter("pwd");
	        String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String addr1 = request.getParameter("addr1");
            String addr2 = request.getParameter("addr2");
            int pin = Integer.parseInt(request.getParameter("pin"));
            String phone = request.getParameter("phone");
            String city = request.getParameter("city");
            String gender = request.getParameter("gender");
            String role = request.getParameter("role");
            
            DatabaseConnector dbcon = DatabaseConnector.getInstance();
	        dbcon.openConnection();
	        
	        SignupDA signupdb = new SignupDA(dbcon.getConnection());
	        if(signupdb.isExistingUser(email)) {
	        	out.write("user exists");
	        }
	        else {
	        	if(signupdb.createUser(email,pwd,gender,addr1,addr2,phone,pin,city,fname,lname,role)) {
	        		out.write("successfully registered");
	        	}
	        	else {
	        		out.write("error");
	        	}
	        }
	        dbcon.closeConnection(); 
		}
		catch(Exception ex) {
			Logger.getLogger(LoginServlet.class.getName()).log(Level.INFO, null, ex);
		}
	}

}
