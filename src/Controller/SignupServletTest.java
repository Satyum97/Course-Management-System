package Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class SignupServletTest {
	@InjectMocks private SignupServlet testSignupServlet;
	 @Mock private Connection mockConnection;
	 @Mock private Statement mockStatement;
	 @Mock HttpServletRequest request;
	 @Mock HttpServletResponse response;
	@Test
	void testSignupServlet() {
		testSignupServlet = new SignupServlet();
	}

	@Test
	void testDoPostHttpServletRequestHttpServletResponse() throws Exception{
		testSignupServlet = new SignupServlet();
		testSignupServlet.doPost(request, response);
	}

}
