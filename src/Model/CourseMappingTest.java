package Model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class CourseMappingTest {
	@InjectMocks private CourseMapping testCourseMapping;
	@Test
	void testGetCourseObj() {
		testCourseMapping = new CourseMapping();
		Course testCourse = new Course();
		testCourse.setLevel(6000);
		testCourseMapping.setCourseObj(testCourse);
		assertEquals(6000,testCourseMapping.getCourseObj().getLevel());
	}

	@Test
	void testSetCourseObj() {
		testCourseMapping = new CourseMapping();
		Course testCourse = new Course();
		testCourse.setCourse_id("CS6104");
		testCourseMapping.setCourseObj(testCourse);
		Course test = new Course();
		test.setCourse_id("CS6104");
		testCourse.equals(test);
	}

	@Test
	void testGetStudentList() {
		List<User> testList = new ArrayList<>();
		testCourseMapping = new CourseMapping();
		testList.equals(testCourseMapping.getStudentList());
	}

	@Test
	void testSetStudentList() {
		List<User> testStudentList = new ArrayList<>();
		testCourseMapping = new CourseMapping();
		testCourseMapping.setStudentList(testStudentList);
		testStudentList.equals(testCourseMapping.getStudentList());
	}

	@Test
	void testGetInstructor() {
		testCourseMapping = new CourseMapping();
		User testInstructor = new User();
		testCourseMapping.setInstructor(testInstructor);
		testInstructor.equals(testCourseMapping.getInstructor());
	}

	@Test
	void testSetInstructor() {
		testCourseMapping = new CourseMapping();
		User testInstructor = new User();
		testCourseMapping.setInstructor(testInstructor);
	}

	@Test
	void testGetInstructorList() {
		testCourseMapping = new CourseMapping();
		List<User> testUserList = new ArrayList<>();
		testCourseMapping.setInstructorList(testUserList);
		testUserList.equals(testCourseMapping.getInstructorList());
	}

	@Test
	void testSetInstructorList() {
		testCourseMapping = new CourseMapping();
		List<User> testInstructorList = new ArrayList<>();
		testCourseMapping.setInstructorList(testInstructorList);
	}

	@Test
	void testGetCourseList() {
		testCourseMapping = new CourseMapping();
		List<Course> testCourseList = new ArrayList<>();
		testCourseMapping.setCourseList(testCourseList);
		testCourseList.equals(testCourseMapping.getCourseList());
	}

	@Test
	void testSetCourseList() {
		testCourseMapping = new CourseMapping();
		List<Course> testCourseList = new ArrayList<>();
		testCourseMapping.setCourseList(testCourseList);
	}

}
