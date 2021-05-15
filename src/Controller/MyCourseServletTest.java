package Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class MyCourseServletTest {
	 @InjectMocks private MyCourseServlet testMyCourseServlet;
	 @Mock private Connection mockConnection;
	 @Mock private Statement mockStatement;
	 @Mock HttpServletRequest request;
	 @Mock HttpServletResponse response;
	 
	@Test
	void testCourseGetServlet() {
		testMyCourseServlet = new MyCourseServlet();
	}

	@Test
	void testMyCourseServlet() {
		testMyCourseServlet = new MyCourseServlet();
			
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() throws Exception{
		
		testMyCourseServlet = new MyCourseServlet();
		testMyCourseServlet.doPost(request,response);	
	}
	
	@Test
	void testDoGetHttpServletRequestHttpServletResponse() throws Exception{
		
		testMyCourseServlet = new MyCourseServlet();
		testMyCourseServlet.doPost(request,response);	
	}

}
