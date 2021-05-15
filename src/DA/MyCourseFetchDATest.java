package DA;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class MyCourseFetchDATest {
	 @InjectMocks private MyCourseFetchDA testmyCourseFetch;
	 @Mock private Connection mockConnection;
	 @Mock private Statement mockStatement;
	 String connectionURL = "jdbc:mysql://remotemysql.com/592U4BDIk7";
	@Test
	void testMyCourseFetchDA() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testmyCourseFetch = new MyCourseFetchDA(mockConnection);
		try {
			testmyCourseFetch.conn = DriverManager.getConnection(connectionURL, "592U4BDIk7", "vlwxTrDLFb");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	void testGetMyCourses() {
		testmyCourseFetch = new MyCourseFetchDA(mockConnection);
		testmyCourseFetch.getMyCourses(3);
	}

	@Test
	void testGetStudentInCourse() {
		testmyCourseFetch = new MyCourseFetchDA(mockConnection);
		testmyCourseFetch.getStudentInCourse("CS6314");
	}

	@Test
	void testGetInstructorCourseList() {
		testmyCourseFetch = new MyCourseFetchDA(mockConnection);
		testmyCourseFetch.getInstructorCourseList("22");
	}

	@Test
	void testGetUserDetails() {
		testmyCourseFetch = new MyCourseFetchDA(mockConnection);
		testmyCourseFetch.getUserDetails("jayant.bhopale@gmail.com");
	}

	@Test
	void testGetUserDetailsByID() {
		testmyCourseFetch = new MyCourseFetchDA(mockConnection);
		testmyCourseFetch.getUserDetailsByID("3");
	}

	@Test
	void testGetInstructorForCourse() {
		testmyCourseFetch = new MyCourseFetchDA(mockConnection);
		testmyCourseFetch.getInstructorForCourse("CS6363");
	}

	@Test
	void testDeleteCourse() {
		testmyCourseFetch = new MyCourseFetchDA(mockConnection);
		testmyCourseFetch.deleteCourse("CS6359", "3");
	}

	@Test
	void testDeleteCourseForInstructor() {
		testmyCourseFetch = new MyCourseFetchDA(mockConnection);
		testmyCourseFetch.deleteCourseForInstructor("CS6359", "20");
	}

}
