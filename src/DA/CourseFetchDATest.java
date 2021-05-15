package DA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class CourseFetchDATest {
	  @InjectMocks private CourseFetchDA testCourseFetch;
	  @InjectMocks private DatabaseConnector dbConnection;
	  @Mock private Connection mockConnection;
	  @Mock private Statement mockStatement;
	  String connectionURL = "jdbc:mysql://remotemysql.com/592U4BDIk7";
      
	@Test
	void testCourseFetchDA() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.conn = DriverManager.getConnection(connectionURL, "592U4BDIk7", "vlwxTrDLFb");
	}

	@Test
	void testGetCourses() {
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.getCourses("fall20", "open", "online", "6000");
	}

	@Test
	void testGetCourseDetails() {
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.getCourseDetails("cs6360");
	}

	@Test
	void testAddCourse() {
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.getCourseDetails("fall20", "open", "online", "6000");
	}

	@Test
	void testGetCourseDetailsString() {
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.getCourseDetails("cs6363");
	}
	@Test
	void testEnrollCourse() {
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.enrollCourse(3, "student", "CS6202");
	}
	@Test
	void testEnrollCourseNull() {
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.enrollCourse(3, null, "CS6202");
	}


	@Test
	void testEditCourseNull() {
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.editCourse(null, null, "fall20", "online", "6000", "4000", "3", "open", null);
	}
	@Test
	void testEditCourse() {
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.editCourse("CS6360", "Stats for Data Science", "fall20", "online", "5000", "4500", "3", "closed", "Practical aspects covered and no exam");
	}
	@Test
	void testDeleteCourse() {
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.deleteCourse("CS6363");
	}
	@Test
	void testGetStudentsForCourse() {
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.getStudentsForCourse("CS6359");
	}
	
	@Test
	void testGetStudentsForCourseNull() {
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.getStudentsForCourse(null);
	}
	
	@Test
	void testGetInstructorForCourse() {
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.getInstructorForCourse("CS6041");
	}
	
	@Test
	void testGetInstructorForCourseNull() {
		dbConnection = DatabaseConnector.getInstance();
		dbConnection.setConnection(mockConnection);
		testCourseFetch = new CourseFetchDA(mockConnection);
		testCourseFetch.getInstructorForCourse(null);
	}
	
}
