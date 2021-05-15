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

public class CourseFetchDA {
	Connection conn;
	Statement stmt;
	
	public CourseFetchDA(Connection conn) {
		this.conn = conn;
	}
	
	public List<Course> getCourses(String term, String status, String mode, String level){
		List<Course> results = new ArrayList<>();
		try {
			String sql = "Select * from course";
			boolean flag = false;
			List<String> ls = new LinkedList<String>();
			if(!term.isEmpty() || !status.isEmpty() || !mode.isEmpty() || !level.isEmpty()) {
				sql += " where ";
				flag = true;
			}
			if(!status.isEmpty()) {
				ls.add("status='"+status+"'");
			}
			if(!term.isEmpty()) {
				ls.add("term = '"+term+"'");
			}
			if(!level.isEmpty()) {
				ls.add("level = '"+Integer.parseInt(level)+"'");
			}
			if(!mode.isEmpty()) {
				ls.add("mode = '"+mode+"'");
			}
			if(flag) {
				sql += String.join(" and ", ls);
			}
            sql += " order by course_id asc";
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
	
	public Course getCourseDetails(String term, String status, String mode, String level) {
		Course courseObj = null;
		try {
				String sql = "Select * from course";
				stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            while(rs.next()){
	            	courseObj = new Course(rs.getString("term"),rs.getString("status"),rs.getString("mode"),rs.getInt("level"),rs.getString("course_name"),rs.getInt("credit"),rs.getInt("cost"),rs.getString("course_id"),rs.getString("description"));
	       }
			
			return courseObj;
		}
		catch(Exception ex){
			System.out.println(ex);
			return null;
		}
	}
	
	public boolean addCourse(String course_name,String course_id,String term, String mode, String level,String status,String credit,String cost,String desc) {
		try{
			String sql = "Insert into course(course_name,course_id,term,mode,level,status,credit,cost,description) "
					+ "VALUES('"+course_name+"','"+course_id+"','"+term+"','"+mode+"','"+Integer.parseInt(level)+"','"+status+"','"+Integer.parseInt(credit)+"','"+Integer.parseInt(cost)+"','"+desc+"')";
			
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
	
	public Course getCourseDetails(String course_id) {
		Course courseObj = null;
		try {
			String sql = "Select * from course where course_id = '"+course_id+"'";
			stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            	courseObj = new Course(rs.getString("term"),rs.getString("status"),rs.getString("mode"),rs.getInt("level"),rs.getString("course_name"),rs.getInt("credit"),rs.getInt("cost"),rs.getString("course_id"),rs.getString("description"));
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return courseObj;
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
	
	public List<User> getStudentsForCourse(String course_id) {
		List<User> userList = new ArrayList<User>();
		try {
			String sql = "Select email,first_name,last_name from users inner join course_student_mapping on userid = student_id and course_id = '"+course_id+"'";
			stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
            	User userObj = new User();
            	userObj = new User(rs.getString("email"),rs.getString("first_name"),rs.getString("last_name"));
            	userList.add(userObj);
            }
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
		return userList;
	}
	
	public boolean deleteCourse(String course_id) {
		try{
			String sql = "Delete from course where course_id='"+course_id+"'";
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
	
	public boolean editCourse(String course_id,String course_name, String term, String mode, String level, String cost, String credit, String status,String desc) {
		try{
			String sql = "Update course set course_name ='"+course_name+"',term='"+term+"',mode='"+mode+"',status='"+status+"',cost='"+Integer.parseInt(cost)+"',credit='"+Integer.parseInt(credit)+"',level='"+Integer.parseInt(level)+"',description='"+desc+"' where course_id='"+course_id+"'";
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
	
	public int enrollCourse(int userId, String role, String courseId) {
		int result = 0;
		try{
			String sql = "";
			stmt = conn.createStatement();
			if(role.equalsIgnoreCase("student")) {
				sql = "Select * from course_student_mapping where student_id = '"+userId+"'";
				ResultSet rs = stmt.executeQuery(sql);
				int count = 0;
				while(rs.next()) {
					count++;
					if(rs.getString("course_id").equals(courseId))return 3;
				}
				System.out.println("Count is"+count);
				if(count >=3)return 2;
				sql = "Insert into course_student_mapping(student_id,course_id) "
						+ "VALUES('"+userId+"','"+courseId+"')";
			}
			else {
				sql = "Insert into course_instructor_mapping(instructor_id,course_id) "
						+ "VALUES('"+userId+"','"+courseId+"')";
			}
            int numberOfRows = stmt.executeUpdate(sql);
            if(numberOfRows > 0)return 1;
			return 4;
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return result;
	}
}