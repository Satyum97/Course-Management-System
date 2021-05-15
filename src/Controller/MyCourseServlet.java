package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DA.CourseFetchDA;
import DA.DatabaseConnector;
import DA.MyCourseFetchDA;
import Model.Course;
import Model.CourseMapping;
import Model.User;

@WebServlet("/MyCourseServlet")
public class MyCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyCourseServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		String userId = request.getParameter("userId");
		String courseId = request.getParameter("courseId");
		
		try {
			//get Course List
			if(courseId == null) {
				DatabaseConnector dbcon = DatabaseConnector.getInstance();
				dbcon.openConnection();
				MyCourseFetchDA courseGetdb = new MyCourseFetchDA(dbcon.getConnection());
				
				User user = courseGetdb.getUserDetailsByID(userId);
				if(user.getRole().equals("student")) {
					
					List<Course> courseList = courseGetdb.getMyCourses(Integer.valueOf(userId));
					List<User> instructorList = new ArrayList<>();
		
					for (Course c : courseList) {
						instructorList.add(courseGetdb.getInstructorForCourse(c.getCourse_id()));
					}

					CourseMapping courseMapping = new CourseMapping();
					courseMapping.setCourseList(courseList);
					courseMapping.setInstructorList(instructorList);
			 
					request.setAttribute("courseMapping", courseMapping);
					rd = request.getRequestDispatcher("myCourses.jsp");
					rd.forward(request, response);
					
			}else if(user.getRole().equals("instructor")) {
					System.out.println("user is an instructor");
					List<Course> instructorCourseList = courseGetdb.getInstructorCourseList(userId);
					List<User> instructorList = new ArrayList<>();
					CourseMapping courseMapping = new CourseMapping();
					courseMapping.setCourseList(instructorCourseList);
					courseMapping.setInstructorList(instructorList);
					request.setAttribute("courseMapping", courseMapping);
					rd = request.getRequestDispatcher("myCourses.jsp");
					rd.forward(request, response);
				}
				dbcon.closeConnection();
			}
			//drop course
			else {
				
				DatabaseConnector dbcon = DatabaseConnector.getInstance();
				dbcon.openConnection();
				MyCourseFetchDA courseGetdb = new MyCourseFetchDA(dbcon.getConnection());
				
				User user = courseGetdb.getUserDetailsByID(userId);
				if(user.getRole().equals("student")) {
					MyCourseFetchDA mycourseGetdb = new MyCourseFetchDA(dbcon.getConnection());
					boolean isCourseDroppped = mycourseGetdb.deleteCourse(courseId ,userId);
				
					List<Course> courseList = mycourseGetdb.getMyCourses(Integer.valueOf(userId));
					List<User> instructorList = new ArrayList<>();
			
					for (Course c : courseList) {
						instructorList.add(mycourseGetdb.getInstructorForCourse(c.getCourse_id()));
					}

					CourseMapping courseMapping = new CourseMapping();
					courseMapping.setCourseList(courseList);
					courseMapping.setInstructorList(instructorList);
			 
					request.setAttribute("courseMapping", courseMapping);
					rd = request.getRequestDispatcher("myCourses.jsp");
					rd.forward(request, response);
					dbcon.closeConnection();
			}else  if(user.getRole().equals("instructor")) {
				MyCourseFetchDA mycourseGetdb = new MyCourseFetchDA(dbcon.getConnection());
				boolean isCourseDroppped = mycourseGetdb.deleteCourseForInstructor(courseId ,userId);
			
				List<Course> courseList = mycourseGetdb.getMyCourses(Integer.valueOf(userId));
				List<User> instructorList = new ArrayList<>();
		
				for (Course c : courseList) {
					instructorList.add(mycourseGetdb.getInstructorForCourse(c.getCourse_id()));
				}

				CourseMapping courseMapping = new CourseMapping();
				courseMapping.setCourseList(courseList);
				courseMapping.setInstructorList(instructorList);
		 
				request.setAttribute("courseMapping", courseMapping);
				rd = request.getRequestDispatcher("myCourses.jsp");
				rd.forward(request, response);
				dbcon.closeConnection();
			}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//System.out.print("Inside Post method MyCourseServlet ");
			PrintWriter out = response.getWriter();
			String mode = request.getParameter("mode");
			String course_id = request.getParameter("course_id");
			String student_id = request.getParameter("userId");
				if(course_id!=null && !course_id.isEmpty()) {
				DatabaseConnector dbcon = DatabaseConnector.getInstance();
		        dbcon.openConnection();
		        MyCourseFetchDA courseGetdb = new MyCourseFetchDA(dbcon.getConnection());
		        boolean flag = courseGetdb.deleteCourse(course_id, student_id);
			    out.print(flag);
		        dbcon.closeConnection();
		}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
