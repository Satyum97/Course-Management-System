package Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.manager.JMXProxyServlet;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import DA.DatabaseConnector;
import DA.SignupDA;

class CourseAddServletTest {
	 @InjectMocks private CourseAddServlet testCourseServlet;
	 @Mock private Connection mockConnection;
	 @Mock private Statement mockStatement;
	 @Mock HttpServletRequest request;
	 @Mock HttpServletResponse response;
	 
	@Test
	void testCourseAddServlet() {
		testCourseServlet = new CourseAddServlet();
	}

	@Test
	void testNullRespDoPostHttpServletRequestHttpServletResponse() throws Exception {
		testCourseServlet = new CourseAddServlet();
		testCourseServlet.doPost(request,response);
	}
	@Test
	void testRespDoPostHttpServletRequestHttpServletResponse() throws Exception {
		DatabaseConnector dbcon = DatabaseConnector.getInstance();
		testCourseServlet = new CourseAddServlet();
		testCourseServlet.doPost(request,response);
	}
	
}
