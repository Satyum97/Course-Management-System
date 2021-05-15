package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import DA.CourseFetchDA;
import DA.DatabaseConnector;
import Model.Course;

/**
 * Servlet implementation class CourseAddServlet
 */
@WebServlet("/CourseAddServlet")
public class CourseAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			String course_name = request.getParameter("course_name");
			String course_id = request.getParameter("course_id");
			String level = request.getParameter("level");
			String credit = request.getParameter("credit");
			String cost = request.getParameter("cost");
			String term = request.getParameter("term");
			String mode = request.getParameter("mode");
			String status = request.getParameter("status");
			String desc = request.getParameter("desc");
	        DatabaseConnector dbcon = DatabaseConnector.getInstance();
	        dbcon.openConnection();
	        CourseFetchDA courseGetdb = new CourseFetchDA(dbcon.getConnection());
	        if(courseGetdb.addCourse(course_name, course_id, term, mode, level, status, credit, cost,desc)) {
	        	out.write(course_id);
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
