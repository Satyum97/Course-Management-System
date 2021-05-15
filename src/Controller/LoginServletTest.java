package Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class LoginServletTest {
	 @InjectMocks private LoginServlet testLoginServlet;
	 @Mock private Connection mockConnection;
	 @Mock private Statement mockStatement;
	 @Mock HttpServletRequest request;
	 @Mock HttpServletResponse response;
	 
	
	@Test
	void testLoginServlet() {
		testLoginServlet = new LoginServlet();
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() throws Exception {
		testLoginServlet = new LoginServlet();
		testLoginServlet.doPost(request, response);
	}

}
