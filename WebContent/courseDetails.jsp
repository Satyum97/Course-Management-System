<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="Model.Course" %>
<%@ page import="Model.User" %>
<%@ page import="Model.CourseMapping" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<title>Course Details</title>
	</head>
	<body>
		<jsp:include page="header.jsp" />
	        
	        <main class="mdl-layout__content">
	          	<div class="page-content">
					<%
					CourseMapping cm = (CourseMapping)request.getAttribute("courseMapping");
					Course course = cm.getCourseObj();
					User instructor = (User)cm.getInstructor();
					List<User> studentList = (List<User>)cm.getStudentList();
					if(request.getAttribute("code")!=null){
						int code = Integer.parseInt((String)request.getAttribute("code"));
						switch(code){
							case 2 : %><script>window.alert("Error! You cannot enroll in more than 3 courses")</script><% break;
							case 3 : %><script>window.alert("Error! You are already enrolled in this course")</script><% break;
						}
					}
					%>
					<div class="demo-card-wide mdl-card mdl-shadow--2dp" style="width:93%;margin:1%;margin-left:5%">
					  <div class="mdl-card__title">
					    <h2 class="mdl-card__title-text"><%=course.getCourse_name()%></h2>
					  </div>
					  <div class="mdl-card__supporting-text">
					    <p>
					    	<form action="#">
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							    <input class="mdl-textfield__input" type="text" id="edit_course_id" value="<%= course.getCourse_id() %>" readonly>
							    <label class="mdl-textfield__label" for="edit_course_id">Course Number</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							    <input class="mdl-textfield__input" type="text" id="edit_course_name" value="<%= course.getCourse_name() %>" readonly>
							    <span id="ecourse_name" class="mdl-textfield__error"></span>
							    <label class="mdl-textfield__label" for="edit_course_name">Course Name</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							  	<select class="mdl-textfield__input" id="edit_mode" name="instructionMethod">        
									<option value="hybrid">Blended/ Hybrid</option>
									<option value="flexible">Flexible</option>
									<option value="remote">Remote/ Virtual</option>
									<option value="online">Online</option>
								</select>
							    <input type="hidden" id="mode" value="<%= course.getMode() %>" >
							    <label class="mdl-textfield__label" for="edit_mode">Mode</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							  	<select class="mdl-textfield__input" id="edit_level" name="courselevel">        
									<option value="5000">Under-Graduate</option>
									<option value="6000">Graduate</option>
									<option value="7000">Post Graduate</option>
								</select>
							    <input type="hidden" id="level" value="<%= course.getLevel() %>" readonly>
							    <label class="mdl-textfield__label" for="edit_level">Level</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							    <input class="mdl-textfield__input" type="number" id="edit_cost" value="<%= course.getCost() %>" readonly>
							    <span id="ecost" class="mdl-textfield__error"></span>
							    <label class="mdl-textfield__label" for="edit_cost">Cost</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							  	<select class="mdl-textfield__input" id="edit_status" name="classStatus">    
									<option value="open">Open</option>
									<option value="close">Closed</option>
									<option value="cancelled">Cancelled</option>
								</select>
							    <input type="hidden" id="status" value="<%= course.getStatus() %>" readonly>
							    <label class="mdl-textfield__label" for="edit_status">Status</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;" >
								 <select class="mdl-textfield__input" id="edit_term" name="term">         
									<option value="fall20">Fall 2020</option>
									<option value="spring21">Spring 2021</option>
									<option value="fall21">Fall 2021</option>
									<option value="spring22">Spring 2022</option>
								</select>
								<label class="mdl-textfield__label" for="edit_term">Term</label>
							    <input type="hidden" id="term" value="<%= course.getTerm() %>">
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
							    <input class="mdl-textfield__input" type="number" id="edit_credit" value="<%= course.getCredit() %>" readonly>
							    <span id="ecredit" class="mdl-textfield__error"></span>
							    <label class="mdl-textfield__label" for="edit_credit">Credit</label>
							  </div>
							  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;width:40%;">
							    <textarea class="mdl-textfield__input"  rows="3" id="desc" readonly><%= course.getDesc() %></textarea>
  					  			<label class="mdl-textfield__label" for="desc">Description</label>
							  </div>
							</form>
					  </div>
					  <div class="mdl-card__menu">
					  <% if(session.getAttribute("role")!=null && session.getAttribute("role").equals("student")){  %> 
					  	<a class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect" href="CourseServlet?mode=enroll&role=student&courseId=<%= course.getCourse_id() %>&userId=<%= session.getAttribute("userId")%>">
					      <i class="material-icons" style="color:blue">library_add</i>
					    </a>
					  <% } %>
					  <% if(session.getAttribute("role")!=null && session.getAttribute("role").equals("admin")){  %> 
					  	<button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect" id="saveBtn" style="display:none;">
					      <i class="material-icons" style="color:blue">save</i>
					    </button>
						<button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect" id="editBtn" style="display:visible;">
					      <i class="material-icons" style="color:green">edit</i>
					    </button>
					    <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect" id="deleteBtn">
					      <i class="material-icons" style="color:red">delete</i>
					    </button>
					    <% } %>
					  </div>
					</div>
	            <div>
	            </div>
	            <div class="demo-card-wide mdl-card mdl-shadow--2dp" style="width:93%;margin:1%;margin-left:5%">
					  <div class="mdl-card__title">
					    <h2 class="mdl-card__title-text">Instructor</h2>
					  </div>
					  <div class="mdl-card__supporting-text">
					  <% if(instructor!=null){ %>
					    	<form action="#">
								<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
								    <input class="mdl-textfield__input" type="text" id="instructor_first_name" value="<%= instructor.getfName() %>" readonly>
								    <label class="mdl-textfield__label" for="instructor_first_name">First Name</label>
								 </div>
								 <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
								    <input class="mdl-textfield__input" type="text" id="instructor_last_name" value="<%= instructor.getlName() %>" readonly>
								    <label class="mdl-textfield__label" for="instructor_first_name">Last Name</label>
								 </div>
								 <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:3px;">
								    <input class="mdl-textfield__input" type="text" id="instructor_email" value="<%= instructor.getEmail() %>" readonly>
								    <label class="mdl-textfield__label" for="instructor_email">Email</label>
								 </div>
							</form>
					  <% } %>
					  </div>
					  <div class="mdl-card__menu">
					  	<% if(instructor==null&&session.getAttribute("role")!=null && session.getAttribute("role").equals("instructor")){  %> 
						  	<a class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect" href="CourseServlet?mode=enroll&role=instructor&courseId=<%= course.getCourse_id() %>&userId=<%= session.getAttribute("userId")%>">
						      <i class="material-icons" style="color:blue">library_add</i>
						    </a>
						  <% } %>
					  </div>
				</div>
				<% if(session.getAttribute("role")!=null && !session.getAttribute("role").equals("student")){  %> 
				<div class="demo-card-wide mdl-card mdl-shadow--2dp" style="width:93%;margin:1%;margin-left:5%">
					  <div class="mdl-card__title">
					    <h2 class="mdl-card__title-text">Students</h2>
					  </div>
					  <div class="mdl-card__supporting-text">
					  <% if(studentList!=null && studentList.size() > 0){ %>
						  <% for(User student : studentList){%>
							  <ul class="demo-list-three mdl-list">
								  <li class="mdl-list__item mdl-list__item--three-line">
								    <span class="mdl-list__item-primary-content">
								      <i class="material-icons mdl-list__item-avatar">person</i>
								      <span><%=student.getfName()%>&nbsp;<%=student.getlName()%></span>
								      <span class="mdl-list__item-text-body">
								        <%=student.getEmail()%>
								      </span>
								    </span>
								  </li>
								</ul>
						  <%} %>
						  
					  <% } %>
					  </div>
					  <div class="mdl-card__menu">
					  	<span style="color:red">Count : </span><% if(studentList==null){ out.print(0); } else { out.print(studentList.size());}%>
					  </div>
				</div>
				<%} %>
	          </div>
	        </main>
        <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
	</body>
</html>