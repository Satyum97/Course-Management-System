<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="Model.Course" %>
<%@ page import="Model.User" %>
<%@ page import="Model.CourseMapping" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css" />
		<link href="https://fonts.googleapis.com/css2?family=Spicy+Rice&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Gotu&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="./css/base.css">
		<link rel="stylesheet" href="./css/index.css">
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">
		<link href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css" rel="stylesheet">
		<script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
		  
		<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
		<script type="text/javascript" src="./js/courseDetails.js"></script>
		<script type="text/javascript" src="./js/index.js"></script>
		<title>My Courses</title>
	</head>
	<body>
	 	<jsp:include page="header.jsp" />
        <main class="mdl-layout__content">
        </br></br></br>
       		  	<div class="page-content scrollable">
					<%
					CourseMapping cm = (CourseMapping)request.getAttribute("courseMapping");
					List<Course> courseList = cm.getCourseList();
					List<User> instructorList = cm.getInstructorList();
					Course droppedCourse = (Course)request.getAttribute("DroppedCourse");
					for(int i = 0; i < courseList.size(); i++) { %>				
	        		<div class = "product-container">
					<div class="demo-card-wide mdl-card mdl-shadow--2dp" style="width:93%;margin:1%;margin-left:5%">
					  <div class="mdl-card__title">
					    <h2 class="mdl-card__title-text"> <a style="text-decoration: none;;" href="/CourseManagement/CourseServlet?course_id=<%= courseList.get(i).getCourse_id()%>"><%= courseList.get(i).getCourse_name() %></a></h2>
					  </div>
					  <div class="mdl-card__supporting-text">
					    <p>
					    	<form action="#">
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							    <input class="mdl-textfield__input" type="text" id="edit_course_id" value="<%= courseList.get(i).getCourse_id()%>" readonly>
							    <label class="mdl-textfield__label" for="edit_course_id">Course Number</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							    <input class="mdl-textfield__input" type="text" id="edit_course_name" value="<%= courseList.get(i).getCourse_name()%>" readonly>
							    <label class="mdl-textfield__label" for="edit_course_name">Course Name</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							  	<%
							  		String mode = courseList.get(i).getMode();
							  		String displayMode = "";
							  		switch(mode){
							  			case "hybrid" : displayMode = "Blended/ Hybrid";
							  			break;
							  			case "flexible" : displayMode = "Flexible";
							  			break;
							  			case "remote" : displayMode = "Remote/ Virtual";
							  			break;
							  			case "online" : displayMode = "Online";
							  			break;
							  		}
							  	%>
							  	<input class="mdl-textfield__input" type="text" id="mode" value="<%= displayMode %>" readonly/>
							    <label class="mdl-textfield__label" for="edit_mode">Mode</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							  <% 
							  		int level = courseList.get(i).getLevel();
							  		String displayLevel = "";
							  		switch(level){
							  			case 5000 : displayLevel = "Under-Graduate";
							  			break;
							  			case 6000 : displayLevel = "Graduate";
							  			break;
							  			case 7000 : displayLevel = "Post Graduate";
							  			break;
							  		}
							  	%>
							    <input class="mdl-textfield__input" type="text" id="level" value="<%= displayLevel %>" readonly/>
							    <label class="mdl-textfield__label" for="edit_level">Level</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							    <input class="mdl-textfield__input" type="number" id="edit_cost" value="<%= courseList.get(i).getCost() %>" readonly>
							    <span id="ecost" class="mdl-textfield__error"></span>
							    <label class="mdl-textfield__label" for="edit_cost">Cost</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							  <% 
							  		String status = courseList.get(i).getStatus();
							  		String displayStatus = "";
							  		switch(status){
							  			case "open" : displayStatus = "Open";
							  			break;
							  			case "close" : displayStatus = "Closed";
							  			break;
							  			case "cancelled" : displayStatus = "Cancelled";
							  			break;
							  		}
							  	%>
							    <input class="mdl-textfield__input" type="text" id="status" value="<%= displayStatus %>" readonly/>
							    <label class="mdl-textfield__label" for="edit_status">Status</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;" >
								  <% 
								  		String term = courseList.get(i).getTerm();
								  		String displayTerm = "";
								  		switch(term){
								  			case "fall20" : displayTerm = "Fall 2020";
								  			break;
								  			case "spring21" : displayTerm = "Spring 2021";
								  			break;
								  			case "fall21" : displayTerm = "Fall 2021";
								  			break;
								  			case "spring22" : displayTerm = "Spring 2022";
								  			break;
								  		}
								  	%>
								    <input class="mdl-textfield__input" type="text" id="term" value="<%= displayTerm %>" readonly/>
									<label class="mdl-textfield__label" for="edit_term">Term</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							    <input class="mdl-textfield__input" type="number" id="edit_credit" value="<%= courseList.get(i).getCredit()%>" readonly>
							    <span id="ecredit" class="mdl-textfield__error"></span>
							    <label class="mdl-textfield__label" for="edit_credit">Credit</label>
							  </div>
					  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;width:40%;">
							    <textarea class="mdl-textfield__input"  rows="3" id="desc" readonly><%= courseList.get(i).getDesc() %></textarea>
  					  			<label class="mdl-textfield__label" for="desc">Description</label>
							  </div>
							</form>
					  </div>
					  
					  <div class="mdl-card__actions mdl-card--border">
					    <% if(session.getAttribute("role").equals("student")){ %>
					    <div class="mdl-card__title">
					    	<h2 class="mdl-card__title-text">Instructor</h2>
					  	</div>
					  	<div>
					  	<% if(instructorList.get(i) != null) {%>
					  		<form action="#">
								<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
								    <input class="mdl-textfield__input" type="text" id="instructor_first_name" value="<%= instructorList.get(i).getfName() %>" readonly>
								    <label class="mdl-textfield__label" for="instructor_first_name">First Name</label>
								 </div>
								 <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
								    <input class="mdl-textfield__input" type="text" id="instructor_last_name" value="<%= instructorList.get(i).getlName() %>" readonly>
								    <label class="mdl-textfield__label" for="instructor_first_name">Last Name</label>
								 </div>
								 <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
								    <input class="mdl-textfield__input" type="text" id="instructor_email" value="<%= instructorList.get(i).getEmail() %>" readonly>
								    <label class="mdl-textfield__label" for="instructor_email">Email</label>
								 </div>
							</form>
					  	<%} %>
					  	</div>	
					  	<c:choose>
						    <c:when test="${instructor!=null}">
						    <br />
						    </c:when>
						</c:choose>
					  </div>
					<%} %>
					
					  <div class="mdl-card__menu">
					   <% if(session.getAttribute("role") != null && (session.getAttribute("role").equals("student") || session.getAttribute("role").equals("instructor"))){%>
					    <a class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect" href="MyCourseServlet?&courseId=<%= courseList.get(i).getCourse_id() %>&userId=<%= session.getAttribute("userId") %>">
					    <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect" id="courseDropBtn" onclick = "confirmDrop()">
					      	<i class="material-icons" style="color:red">delete</i>
					    </button>
					    </a>
					    <% } %>
					    
					  </div>
					</div>
	            <div>
	            </div>
	            </div>
	         <% } %>
	          </div>
	         </main>
        <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	</body>
</html>