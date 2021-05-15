<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://fonts.googleapis.com/css2?family=Spicy+Rice&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Gotu&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css" />
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="./css/base.css">
<link rel="stylesheet" href="./css/index.css">
<link rel="stylesheet" href="./css/signup.css">
<script type="text/javascript" src="./js/index.js"></script>
<script src="./js/signup.js"></script>
<title>Add User</title>
</head>
<body>
	<dialog id="dialog-registered">
	    <span class="material-icons close-icon dialog-close" style="position: relative;top: 0;left: 97%;" id="">close</span>
	    <div class = "">
	      <div style="float: left;width: 30%;text-align: center;">
	        <img src="./images/registered.png" alt="ice creams" width="120px;" id="images" style="text-align: center;">                
	      </div>
	      <div style = "float: right;width: 68%;border-left: 1px solid #e6e6e6;">
	        
	        <div class="dialog-content">
	          <div style="font-size: large;font-weight: bold;margin-bottom: 5px;line-height: 30px;" class = "gotu">You're Registered!</div>
	          <div style="font-size: large;"><a href = "homePage.jsp">Log in now to get started!</a></div>
	          
	        
	      </div>
	      </div> 
	      
	    </div> 
	  </dialog>
	  <dialog id="dialog-email">
	    <span class="material-icons close-icon dialog-close" style="position: relative;top: 0;left: 97%;" id="">close</span>
	    <div class = "">
	      <div style="float: left;width: 30%;text-align: center;">
	        <img src="./images/mail.png" alt="mail" width="120px;" id="images" style="text-align: center;">                
	      </div>
	      <div style = "float: right;width: 68%;border-left: 1px solid #e6e6e6;">
	        
	        <div class="dialog-content">
	          <div style="font-size: large;font-weight: bold;margin-bottom: 5px;line-height: 30px;" class = "gotu">Oops!</div>
	          <div style="font-size: large;">Looks like we have this Email already!</div>
	          
	        
	      </div>
	      </div> 
	      
	    </div> 
	  </dialog>
	
	    <jsp:include page="header.jsp" />
	        
	        <main class="mdl-layout__content">
	          <div class="page-content" style="height: 100%; position: relative;"><!-- Your content goes here -->
	            <div class = "bg" style="height: 100%;">
	              <div class = "signup-form">
	                <div class = "signup-title gotu">Add User</div>
	                <form action="#" class = " gotu form">
	                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 49%;margin-right: 5px;;">
	                    <input class="mdl-textfield__input" type="text" id="fname">
	                    <label class="mdl-textfield__label" for="fname">First Name</label>
	                    <span id="eFname" class="mdl-textfield__error"></span>
	                  </div>
	                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 49%;">
	                    <input class="mdl-textfield__input" type="text" id="lname">
	                    <label class="mdl-textfield__label" for="lname">Last Name</label>
	                    <span id="eLname" class="mdl-textfield__error"></span>
	                  </div>
	                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 100%;">
	                    <input class="mdl-textfield__input" type="text" id="addr1">
	                    <label class="mdl-textfield__label" for="addr1">Address Line 1</label>
	                    <span id="eAddr1" class="mdl-textfield__error"></span>
	                  </div>
	                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label"  style="width: 49%;">
	                    <input class="mdl-textfield__input" type="text" id="addr2">
	                    <label class="mdl-textfield__label" for="addr2">Address Line 2</label>
	                  </div>
	                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 49%;margin-right: 5px;;">
	                    <input class="mdl-textfield__input" type="number" id="phone">
	                    <label class="mdl-textfield__label" for="phone">Phone</label>
	                    <span id = "ePhone" class="mdl-textfield__error"></span>
	                  </div>
	                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 49%;margin-right: 5px;;">
	                    <input class="mdl-textfield__input" type="text" id="city">
	                    <label class="mdl-textfield__label" for="city">City</label>
	                    <span id = "eCity" class="mdl-textfield__error"></span>
	                  </div>
	                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 49%;">
	                    <input class="mdl-textfield__input" type="number" id="pin">
	                    <label class="mdl-textfield__label" for="pin">Pin Code</label>
	                    <span id = "ePin" class="mdl-textfield__error"></span>
	                  </div>
	                  <div style="width: 100%;padding:20px 0;">
	                    <span style = "width: 22%;font-size:16px;float: left;">Gender:</span>
	                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="male" style = "width:22%;margin-right: 10%;">
	                      <input type="radio" id="male" class="mdl-radio__button" name="gender" value="m">
	                      <span class="mdl-radio__label">Male</span>
	                    </label>
	                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="female" style = "width:22%">
	                      <input type="radio" id="female" class="mdl-radio__button" name="gender" value="f">
	                      <span class="mdl-radio__label">Female</span>
	                    </label>
	                  </div>
	                   <div style="width: 100%;padding:20px 0;">
	                    <span style = "width: 22%;font-size:16px;float: left;">Role:</span>
	                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="instructor" style = "width:22%;margin-right: 10%;">
	                      <input type="radio" id="instructor" class="mdl-radio__button" name="role" value="instructor">
	                      <span class="mdl-radio__label">Instructor</span>
	                    </label>
	                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="student" style = "width:22%">
	                      <input type="radio" id="student" class="mdl-radio__button" name="role" value="student">
	                      <span class="mdl-radio__label">Student</span>
	                    </label>
	                    <label class="mdl-radio mdl-js-radio mdl-js-ripple-effect" for="admin" style = "width:22%">
	                      <input type="radio" id="admin" class="mdl-radio__button" name="role" value="admin">
	                      <span class="mdl-radio__label">Admin</span>
	                    </label>
	                  </div>
	                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 49%;margin-right: 5px;;">
	                    <input class="mdl-textfield__input" type="email" id="emailF">
	                    <label class="mdl-textfield__label" for="email">Email</label>
	                    <span id = "eEmail" class="mdl-textfield__error"></span>
	                  </div>
	                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 49%;">
	                    <input class="mdl-textfield__input" type="password" id="pwd">
	                    <label class="mdl-textfield__label" for="pwd">Password</label>
	                  </div>
	                  <div id="pswd_info">
	                    <h4>Password must meet the following requirements:</h4>
	                    <ul style="margin-left: -25px;">
	                        <li id="letter" class="invalid">At least <strong>one letter</strong></li>
	                        <li id="capital" class="invalid">At least <strong>one capital letter</strong></li>
	                        <li id="number" class="invalid">At least <strong>one number</strong></li>
	                        <li id="length" class="invalid">Be at least <strong>8 characters</strong></li>
	                    </ul>
	                  </div>
	                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 48%;margin-right: 5px;;">
	                    <input class="mdl-textfield__input" type="email" id="email-conf">
	                    <label class="mdl-textfield__label" for="email-conf">Confirm Email</label>
	                    <span id = "eEmailC" class="mdl-textfield__error"></span>
	                  </div>
	                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 49%;">
	                    <input class="mdl-textfield__input" type="password" id="pwd-conf">
	                    <label class="mdl-textfield__label" for="pwd-conf">Confirm Password</label>
	                    <span id = "ePwdC" class="mdl-textfield__error"></span>
	                  </div>
	                  <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent" id = "addsubmit" style="width: 100%;" disabled>
	                    Sign Up
	                  </button>
	                  <div id="p2" class="mdl-progress mdl-js-progress mdl-progress__indeterminate mdl-progress-accent progress" style="width: 100%;visibility: hidden;"></div>
	                </form>
	              </div>
	            </div>
	
	            </div>
	        </main>
	      </div>
	      
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
</body>
</html>