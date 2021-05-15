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

class LogoutServletTest {
	 @InjectMocks private LogoutServlet testLogoutServlet;
	 @Mock private Connection mockConnection;
	 @Mock private Statement mockStatement;
	 @Mock HttpServletRequest request;
	 @Mock HttpServletResponse response;
	 
	@Test
	void testLogoutServlet() {
		testLogoutServlet = new LogoutServlet();
	}
	/*
	@Test
	void testDoGetHttpServletRequestHttpServletResponse() throws Exception{
		testLogoutServlet = new LogoutServlet();
		testLogoutServlet.doGet(request, response);
	}
	*/
}
