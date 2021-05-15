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
<script type="text/javascript" src="./js/index.js"></script>
<title>Course Management System</title>
</head>
<body>
	
        <jsp:include page="header.jsp" />
        <main class="mdl-layout__content">
          <div class="page-content">

            <div>
            	<div>
            	<span class="mdl-layout-title" style="padding: 30px; text-align :center ; height : 40%;">Browse Courses</span>
            	</div>

            	<div style="justify-content: center; align-items: center; display: flex; padding : 80px;">
            	<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 20%; margin-left: 20px;">
                       <select class="mdl-textfield__input" id="term" name="term">
                                        <option></option>               
                                        <option value="fall20">Fall 2020</option>
                                        <option value="spring21">Spring 2021</option>
                                        <option value="fall21">Fall 2021</option>
                                        <option value="spring22">Spring 2022</option>
                        </select>
                    <label class="mdl-textfield__label" for="category" style="font-size:13px;">Course Term</label>
             	</div>
             	
             	<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 20%; margin-left: 20px;">
                        <select class="mdl-textfield__input" id="level" name="courselevel">
                             <option></option>               
                             <option value="5000">Under-Graduate </option>
                             <option value="6000">Graduate</option>
                             <option value="7000">Post Graduate</option>
                        </select>
                    <label class="mdl-textfield__label" for="category" style="font-size:13px;">Course Level</label>
             	</div>
             	
             	
             	<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 20%; margin-left: 20px;">
                        <select class="mdl-textfield__input" id="mode" name="instructionMethod">
                                        <option></option>               
                                        <option value="hybrid">Blended/ Hybrid</option>
                                        <option value="flexible">Flexible</option>
                                        <option value="remote">Remote/ Virtual</option>
                                        <option value="online">Online</option>
                        </select>
                    <label class="mdl-textfield__label" for="category" style="font-size:13px;">Instruction Method</label>
             	</div>
             	<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 20%; margin-left: 20px;">
                        <select class="mdl-textfield__input" id="status" name="classStatus">
	                        <option></option>               
	                        <option value="open">Open</option>
	                        <option value="close">Closed</option>
	                        <option value="cancelled">Cancelled</option>
                        </select>
                    <label class="mdl-textfield__label" for="category" style="font-size:13px;">Course Status</label>
             	</div>
             	</div>   
            	
            	<div style="justify-content: center; align-items: center; display: flex;">
            		 <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored coursebtn" id = "coursebtn" style="width: 20%;  margin: 30px;">
                     	Get courses
                     </button>
                     <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored resetbtn" id = "resetbtn" style="width: 20%;  margin: 30px;">
                      	Reset filter
                     </button>
            	</div>   
            	<br/> 
                <div style="margin-left:15%;">
                     <div class="mdl-spinner mdl-spinner--single-color mdl-js-spinner is-active spinner" style = "display:block;margin-left:35%"></div>
                     <div id = "productResults" style="overflow: hidden;width:100%;margin-bottom:15px;">
                       
                     </div>
                </div>
            </div>
            </div>
        </main>
        </div>
    
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>