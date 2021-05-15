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
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Course;
import Model.User;
import DA.CourseFetchDA;
import DA.DatabaseConnector;
import com.google.gson.Gson;

/**
 * Servlet implementation class CourseGetServlet
 */
@WebServlet("/CourseGetServlet")
public class CourseGetServlet extends HttpServlet {
    
    public CourseGetServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			String level = request.getParameter("level");
			String term = request.getParameter("term");
			String mode = request.getParameter("mode");
			String status = request.getParameter("status");
			Gson gson = new Gson();
	        DatabaseConnector dbcon = DatabaseConnector.getInstance();
	        dbcon.openConnection();
	        
	       
	        CourseFetchDA courseGetdb = new CourseFetchDA(dbcon.getConnection());
	        List<Course> listOfCourses = courseGetdb.getCourses(term, status, mode, level);
	        
	        if(listOfCourses!=null && listOfCourses.size() > 0){
	        	out.write(gson.toJson(listOfCourses));
	        }
	        else {
	        	out.write("error");
	        }
	        dbcon.closeConnection(); 
		}
		catch(Exception ex) {
			System.out.println(ex);
			
			Logger.getLogger(LoginServlet.class.getName()).log(Level.INFO, null, ex);
		}
        
	}

}
