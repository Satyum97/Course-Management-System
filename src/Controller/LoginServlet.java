package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.User;

import DA.DatabaseConnector;
import DA.LoginDA;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    public LoginServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			String username = request.getParameter("email");
	        String password = Base64.getEncoder().encodeToString(request.getParameter("pwd").getBytes());
	        HttpSession session = request.getSession(); // Retrieving session 
	        session.setAttribute("username", username);
	        
	        DatabaseConnector dbcon = DatabaseConnector.getInstance();
	        dbcon.openConnection();
	        
	        LoginDA logindb = new LoginDA(dbcon.getConnection());
	        User userObj = logindb.checkUserLogin(username, password);
	        if(userObj!=null) {
	        	session.setAttribute("user",userObj);
	        	session.setAttribute("role",userObj.getRole());
	        	session.setAttribute("userId",userObj.getUserId());
	        	out.write("success");
	        }
	        else {
	        	out.write("error");
	        }
	        dbcon.closeConnection(); 
		}
		catch(Exception ex) {
			Logger.getLogger(LoginServlet.class.getName()).log(Level.INFO, null, ex);
		}
        
	}

}
