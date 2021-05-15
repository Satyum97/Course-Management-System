package DA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Course;
import Model.User;

public class MyCourseFetchDA {
	Connection conn;
	Statement stmt;
	
	public MyCourseFetchDA(Connection conn) {
		this.conn = conn;
	}
	
	public List<Course> getMyCourses(int username){
		
		List<Course> results = new ArrayList<>();
		try {
			String sql = "Select * from course c, course_student_mapping m"
					+ " where m.student_id = "
					+ username
					+ " and c.course_id = m.course_id" ;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            	results.add(new Course(rs.getString("term"),rs.getString("status"),rs.getString("mode"),rs.getInt("level"),rs.getString("course_name"),rs.getInt("credit"),rs.getInt("cost"),rs.getString("course_id"),rs.getString("description")));
            }
		}
		catch(Exception ex){
			System.out.println(ex);
			return null;
		}
		return results;
	}
	
public List<User> getStudentInCourse(String courseId){
		
		List<User> results = new ArrayList<>();
		try {
			String sql = "Select * from course c, course_student_mapping m"
					+ " where m.student_id = "
					+ courseId ;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            	results.add(new User(rs.getInt("userId"),rs.getString("email"),rs.getString("first_name"),rs.getString("last_name")
                		,rs.getString("address"),rs.getString("phone"),rs.getInt("pincode"),rs.getString("city"),rs.getString("gender"),rs.getString("role")));
            }
		}
		catch(Exception ex){
			System.out.println(ex);
			return null;
		}
		return results;
	}
	
public List<Course> getInstructorCourseList(String instructorId){
		
		List<Course> results = new ArrayList<>();
		try {
			String sql = "Select * from course c, course_instructor_mapping m"
					+ " where m.instructor_id = "
					+ instructorId
					+ " and c.course_id = m.course_id" ;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
            	results.add(new Course(rs.getString("term"),rs.getString("status"),rs.getString("mode"),rs.getInt("level"),rs.getString("course_name"),rs.getInt("credit"),rs.getInt("cost"),rs.getString("course_id"),rs.getString("description")));
            }
		}
		catch(Exception ex){
			System.out.println(ex);
			return null;
		}
		return results;
	}

	public User getUserDetails(String email) {
		User userObj = null;
		try {
			if(!email.isEmpty()) {
				String sql = "select * from users where email = '"
							 +email
							 +"'";
	            stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            while(rs.next()){
	                userObj = new User(rs.getInt("userId"),rs.getString("email"),rs.getString("first_name"),rs.getString("last_name")
	                		,rs.getString("address"),rs.getString("phone"),rs.getInt("pincode"),rs.getString("city"),rs.getString("gender"),rs.getString("role"));
	            }
			}
			return userObj;
		}
		catch(Exception ex){
			System.out.println(ex);
			return null;
		}
	}
	
	public User getUserDetailsByID(String userId) {
		User userObj = null;
		try {
				String sql = "select * from users where userid = '"
							 +userId
							 +"'";
	            stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            while(rs.next()){
	                userObj = new User(rs.getInt("userId"),rs.getString("email"),rs.getString("first_name"),rs.getString("last_name")
	                		,rs.getString("address"),rs.getString("phone"),rs.getInt("pincode"),rs.getString("city"),rs.getString("gender"),rs.getString("role"));
			}
			return userObj;
		}
		catch(Exception ex){
			System.out.println(ex);
			return null;
		}
	}
	
	public User getInstructorForCourse(String course_id) {
		User userObj = null;
		try {
			String sql = "Select email,first_name,last_name from users inner join course_instructor_mapping on userid = instructor_id and course_id = '"+course_id+"'";
			stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            	userObj = new User(rs.getString("email"),rs.getString("first_name"),rs.getString("last_name"));
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return userObj;
	}
	
	public boolean deleteCourse(String course_id, String student_id) {
		try{
			String sql = "Delete from course_student_mapping where course_id='"+course_id+"' and student_id ='"+student_id+"'";
            stmt = conn.createStatement();
            int numberOfRows = stmt.executeUpdate(sql);
            if(numberOfRows > 0)return true;
			return false;
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return false;
	}
	public boolean deleteCourseForInstructor(String course_id, String instructor_id) {
		try{
			String sql = "Delete from course_instructor_mapping where course_id='"+course_id+"' and instructor_id ='"+instructor_id+"'";
            stmt = conn.createStatement();
            int numberOfRows = stmt.executeUpdate(sql);
            if(numberOfRows > 0)return true;
			return false;
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return false;
	}
}