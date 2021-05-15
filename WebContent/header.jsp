<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="Model.Course" %>
<%@ page import="Model.User" %>
<%@ page import="Model.CourseMapping" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<dialog id="dialog">
      <span class="material-icons close-icon" style="position: relative;top: 0;left: 97%;" id="dialog-close-1">close</span>
      <div class = "">
        <div class="img-switcher ">
          <img src="./images/courseIcon.png" alt="course icon" width="100%;" id="images">                
        </div>
        <div class="login-form-container">
          
          <div class="login-form">
            <div style="font-size: xx-large;font-weight: bold;margin-bottom: 20px;" class = "gotu">Log In</div>
            <div style="margin-bottom: 10px;" class="">
            	Log in to view/register/drop courses
            	<p style="text-align:center"><span id="loginError" class="mdl-textfield__error" style="margin:5px;"></span></p>
            </div>
            <br/>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:5px;">
              <input class="mdl-textfield__input" type="email" id="email">
              <label class="mdl-textfield__label" for="email">Email Address</label>
              <span id="eEmail" class="mdl-textfield__error"></span>
            </div>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="margin:5px;">
              <input class="mdl-textfield__input" type="password" id="password">
              <label class="mdl-textfield__label" for="password">Password</label>
              <span id="ePassword" class="mdl-textfield__error"></span>
            </div>
            <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored login" id = "login-btn" style="margin:5px;">
              Log In
            </button>
        </div>
        </div> 
        
      </div> 
    </dialog>

    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
        <header class="mdl-layout__header">
          <div class="mdl-layout__header-row">
            <!-- Title -->
            <a href = "homePage.jsp" style = "color:white;"><span class="mdl-layout-title">Course Management</span></a>
            <!-- Add spacer, to align navigation to the right -->
            <div class="mdl-layout-spacer"></div>
            <!-- Navigation. We hide it in small screens. -->
            <nav class="mdl-navigation mdl-layout--large-screen-only" style="margin-right:4%;">
            	<% if(session.getAttribute("role")==null){%>
                <a class="mdl-button mdl-js-button gotu top-bar-btn" id = "login" >Login</a>
                <a class="mdl-button mdl-js-button gotu top-bar-btn" href = "signup.jsp">Sign Up</a>
               <%} else{  %> 
	            <div>    
                    <button id = "demo_menu-lower-left" 
                       class = "mdl-button mdl-js-button gotu top-bar-btn" 
                       data-upgraded = ",MaterialButton">
                       <% User userObj = (User)session.getAttribute("user"); %>
                       <%= userObj.getfName()%>
                       <i class = "material-icons">menu</i>
                    </button>
                    
                    <ul class = "mdl-menu mdl-menu--bottom-left mdl-js-menu mdl-js-ripple-effect"
                       for = "demo_menu-lower-left">
                       <% if(session.getAttribute("role").equals("student") || session.getAttribute("role").equals("instructor")) {%>
                       <li class = "mdl-menu__item mdl-button mdl-js-button"><a href="MyCourseServlet?userId=<%= session.getAttribute("userId") %>" >My courses</a></li>
                       <% } else{ %>
                       <li class = "mdl-menu__item mdl-button mdl-js-button"><a href="AddCourse.jsp" >Add course</a></li>
                       <li class = "mdl-menu__item mdl-button mdl-js-button"><a href="AddUser.jsp" >Add user</a></li>
                       <%} %>
                       <li class = "mdl-menu__item mdl-button mdl-js-button" ><a href="LogoutServlet">Logout</a></li> 
                    </ul>  
                 </div>
               <% } %>
            </nav>
        </header>