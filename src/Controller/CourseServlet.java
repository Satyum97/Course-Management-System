package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DA.CourseFetchDA;
import DA.DatabaseConnector;
import Model.Course;
import Model.CourseMapping;
import Model.User;
import java.util.List;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mode = request.getParameter("mode");
			if(mode != null && mode.equalsIgnoreCase("enroll")) {
				RequestDispatcher rd;
				String role = request.getParameter("role");
				int userId = Integer.parseInt(request.getParameter("userId"));
				String courseId = request.getParameter("courseId");
				DatabaseConnector dbcon = DatabaseConnector.getInstance();
		        dbcon.openConnection();
				CourseFetchDA courseGetdb = new CourseFetchDA(dbcon.getConnection());
				int flag = courseGetdb.enrollCourse(userId,role,courseId);
				dbcon.closeConnection();
				response.sendRedirect("/CourseManagement/CourseServlet?course_id="+courseId+"&code="+flag);
			}
			else {
				RequestDispatcher rd;
				String course_id = request.getParameter("course_id");
				if(course_id!=null && !course_id.isEmpty()) {
					DatabaseConnector dbcon = DatabaseConnector.getInstance();
			        dbcon.openConnection();
			        CourseFetchDA courseGetdb = new CourseFetchDA(dbcon.getConnection());
			        CourseMapping courseMapping = new CourseMapping();
			        Course courseObj = courseGetdb.getCourseDetails(course_id);
			        User instructor = courseGetdb.getInstructorForCourse(course_id);
			        List<User> studentList = courseGetdb.getStudentsForCourse(course_id);
			        courseMapping.setCourseObj(courseObj);
			        courseMapping.setInstructor(instructor);
			        courseMapping.setStudentList(studentList);
			        request.setAttribute("courseMapping", courseMapping);
			        request.setAttribute("code", request.getParameter("code"));
			        rd = request.getRequestDispatcher("courseDetails.jsp");
		            rd.forward(request, response);
		            dbcon.closeConnection();
				}
			}
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.print("Inside Post method CourseServlet ");
			PrintWriter out = response.getWriter();
			String mode = request.getParameter("mode");
			if(mode.equalsIgnoreCase("delete")) {
				String course_id = request.getParameter("course_id");
				System.out.println("ID to be deleted"+course_id);
				if(course_id!=null && !course_id.isEmpty()) {
					DatabaseConnector dbcon = DatabaseConnector.getInstance();
			        dbcon.openConnection();
			        CourseFetchDA courseGetdb = new CourseFetchDA(dbcon.getConnection());
			        boolean flag = courseGetdb.deleteCourse(course_id);
			        out.print(flag);
		            dbcon.closeConnection();
				}
			}
			else if(mode.equalsIgnoreCase("edit")) {
				String course_id = request.getParameter("course_id");
				if(course_id!=null && !course_id.isEmpty()) {
					String course_name = request.getParameter("course_name");
					String level = request.getParameter("level");
					String credit = request.getParameter("credit");
					String cost = request.getParameter("cost");
					String term = request.getParameter("term");
					String course_mode = request.getParameter("course_mode");
					String status = request.getParameter("status");
					String desc = request.getParameter("desc");
					DatabaseConnector dbcon = DatabaseConnector.getInstance();
			        dbcon.openConnection();
			        CourseFetchDA courseGetdb = new CourseFetchDA(dbcon.getConnection());
			        boolean flag = courseGetdb.editCourse(course_id, course_name, term, course_mode, level, cost, credit, status,desc);
			        out.print(flag);
		            dbcon.closeConnection();
				}
			}
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}

}
