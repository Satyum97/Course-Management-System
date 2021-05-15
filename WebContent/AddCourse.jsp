<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
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
<script type="text/javascript" src="./js/addCourse.js"></script>
<script type="text/javascript" src="./js/index.js"></script>
<title>AddCourse</title>
</head>
<body>
    <jsp:include page="header.jsp" />
        
        <main class="mdl-layout__content">
          <div class="page-content">
            <div>
            	<% if(session.getAttribute("role")==null || !session.getAttribute("role").equals("admin")){  %>
            	<br/> 
            	<span style="color:red"><b>You are not allowed to view this page. Please contact the system administrator to get access.</b></span>
            	<%} else{%>
            	<div>
            	<span class="mdl-layout-title" style="padding: 30px; text-align :center ; height : 40%;">Add Course</span>
            	</div>

            	<div style="justify-content: center; align-items: center; display: flex; padding : 80px;">
              
              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 100%; margin-left: 20px;">
                <form>
                      <input class="mdl-textfield__input" type="text" id="course_id">
                      <label class="mdl-textfield__label" for="course_id">Course Id</label>
                      <span id="ecourse_id" class="mdl-textfield__error"></span>
                </form> 
              </div>

              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 100%; margin-left: 20px;">
                <form>
                      <input class="mdl-textfield__input" type="text" id="course_name">
                      <label class="mdl-textfield__label" for="course_id">Course Name</label>
                      <span id="ecourse_name" class="mdl-textfield__error"></span>
                </form> 
              </div>

              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 100%; margin-left: 20px;">
				<select class="mdl-textfield__input" id="term" name="term">         
					<option value="fall20">Fall 2020</option>
					<option value="spring21">Spring 2021</option>
					<option value="fall21">Fall 2021</option>
					<option value="spring22">Spring 2022</option>
				</select>
                <label class="mdl-textfield__label" for="category" style="font-size:13px;">Course Term</label>
              </div> 

              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 100%; margin-left: 20px;">
				<select class="mdl-textfield__input" id="status" name="classStatus">    
					<option value="open">Open</option>
					<option value="close">Closed</option>
					<option value="cancelled">Cancelled</option>
				</select>
				<label class="mdl-textfield__label" for="category" style="font-size:13px;">Course Status</label>
              </div> 

              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 100%; margin-left: 20px;">
				<select class="mdl-textfield__input" id="mode" name="instructionMethod">        
					<option value="hybrid">Blended/ Hybrid</option>
					<option value="flexible">Flexible</option>
					<option value="remote">Remote/ Virtual</option>
					<option value="online">Online</option>
				</select>
                <label class="mdl-textfield__label" for="category" style="font-size:13px;">Instruction Method</label>
              </div>                               

              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 100%; margin-left: 20px;">
				<select class="mdl-textfield__input" id="level" name="courselevel">        
					<option value="5000">Under-Graduate</option>
					<option value="6000">Graduate</option>
					<option value="7000">Post Graduate</option>
				</select>
                <label class="mdl-textfield__label" for="category" style="font-size:13px;">Course Level</label>
              </div>

              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 100%; margin-left: 20px;">
                <form>
					<input class="mdl-textfield__input" type="number" id="credit">
					<label class="mdl-textfield__label" for="course_id">Credit</label>
					<span id="ecredit" class="mdl-textfield__error"></span>
                </form>                
              </div>

              <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 100%; margin-left: 20px;">
                <form>
                      <input class="mdl-textfield__input" type="number" id="cost">
                      <label class="mdl-textfield__label" for="course_id">Cost</label>
                      <span id="ecost" class="mdl-textfield__error"></span>
                </form>                
              </div>                                         
			</div> 
			<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 80%;margin-left:10%">
                <form>
                      <textarea class="mdl-textfield__input" type="text" rows="3" id="desc"></textarea>
  					  <label class="mdl-textfield__label" for="desc">Description</label>
                </form>                
              </div>                                         
			</div>  
              <div style="justify-content: center; align-items: center; display: flex;">
					<button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored coursebtn" id = "coursebtn" style="width: 30%;  margin-top: 30px;">
						Add Course
					</button>
              </div> 
              <%} %>    	
            </div>
            </div>
        </main>
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>