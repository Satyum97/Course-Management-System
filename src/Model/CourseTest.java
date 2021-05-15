package Model;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import DA.CourseFetchDA;

class CourseTest {
	@InjectMocks private Course testCourse;
	 
	@Test
	void testGetCourse_id() {
		testCourse = new Course();
		testCourse.setCourse_id("cs6314");
		assertEquals("cs6314",testCourse.getCourse_id());
	}

	
	@Test
	void testGetTerm() {
		testCourse = new Course();
		testCourse.setTerm("fall20");
		assertEquals("fall20",testCourse.getTerm());
	}

	
	@Test
	void testGetStatus() {
		testCourse = new Course();
		testCourse.setStatus("open");
		assertEquals("open",testCourse.getStatus());
	}

	@Test
	void testGetMode() {
		testCourse = new Course();
		testCourse.setMode("offline");
		assertEquals("offline",testCourse.getMode());
	}

	

	@Test
	void testGetLevel() {
		testCourse = new Course();
		testCourse.setLevel(6000);
		assertEquals(6000,testCourse.getLevel());
	}

	

	@Test
	void testGetCredit() {
		testCourse = new Course();
		testCourse.setCredit(3);
		assertEquals(3,testCourse.getCredit());
	}

	

	@Test
	void testGetCost() {
		testCourse = new Course();
		testCourse.setCost(2500);
		assertEquals(2500,testCourse.getCost());
	}

	

	@Test
	void testGetCourse_name() {
		testCourse = new Course();
		testCourse.setCourse_name("OOAD");
		assertEquals("OOAD",testCourse.getCourse_name());
	}

	@Test
	void testCourseStringStringStringIntStringIntIntString() {
		testCourse = new Course(
					"spring20",
					"open",
					"offline",
					6000,
					"OOAD",
					3,
					2500,
					"cs6313", "Object oriented Design languages"
				);
		
	}

}
