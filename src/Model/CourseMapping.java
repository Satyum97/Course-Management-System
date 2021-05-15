package Model;

import java.util.List;

public class CourseMapping {
	private Course courseObj;
	private List<User> studentList;
	private User instructor;
	private List<User> instructorList;
	private List<Course> courseList;
	public Course getCourseObj() {
		return courseObj;
	}
	public void setCourseObj(Course courseObj) {
		this.courseObj = courseObj;
	}
	public List<User> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<User> studentList) {
		this.studentList = studentList;
	}
	public User getInstructor() {
		return instructor;
	}
	public void setInstructor(User instructor) {
		this.instructor = instructor;
	}
	public List<User> getInstructorList() {
		return instructorList;
	}
	public void setInstructorList(List<User> instructorList) {
		this.instructorList = instructorList;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
}
