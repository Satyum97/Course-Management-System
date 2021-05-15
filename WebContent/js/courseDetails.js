$(document).ready(function (){
	$("#edit_level").val($("#level").val());
	$("#edit_mode").val($("#mode").val());
	$("#edit_status").val($("#status").val());
	$("#edit_term").val($("#term").val());
	
	/*$("#edit_level").attr("disabled","true");
	$("#edit_mode").attr("disabled","true");
	$("#edit_status").attr("disabled","true");
	$("#edit_term").attr("disabled","true");*/
	
	var flag = [false,false,false];
	$("#edit_course_name").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[0] = false;   
            $("#ecourse_name").text("Course name can't be blank");
            $("#ecourse_name").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");  
        }
        else
        {
            $("#ecourse_name").css("visibility","hidden");
            $(this).addClass("valid-field");
            $(this).removeClass("invalid-field");
            flag[0] = true;
        }
    });

	$("#edit_cost").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[1] = false;   
            $("#ecost").text("Course cost can't be blank");
            $("#ecost").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");  
        }
        else
        {
            $("#ecost").css("visibility","hidden");
            $(this).addClass("valid-field");
            $(this).removeClass("invalid-field");
            flag[1] = true;
        }
    });

	$("#edit_credit").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[2] = false;   
            $("#ecredit").text("Credit can't by empty");
            $("#ecredit").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");  
        }
        else
        {
            $("#ecredit").css("visibility","hidden");
            $(this).addClass("valid-field");
            $(this).removeClass("invalid-field");
            flag[2] = true;
        }
    });
	
	$("#editBtn").on("click",function(){
		$("#edit_course_name").attr("readonly",false);
		$("#edit_cost").attr("readonly",false);
		$("#edit_credit").attr("readonly",false);
		$("#desc").attr("readonly",false);
		$("#editBtn").toggle();
		$("#saveBtn").toggle();
		$("#deleteBtn").toggle();
	});
	
	$("#saveBtn").on("click",function(){
	    if ($("#edit_course_name").val() == "")
        {
            flag[0] = false;   
            $("#ecourse_name").text("Course name can't be blank");
            $("#ecourse_name").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");  
        }
        else
        {
            $("#ecourse_name").css("visibility","hidden");
            $(this).addClass("valid-field");
            $(this).removeClass("invalid-field");
            flag[0] = true;
        }
	
        if ($("#edit_cost").val() == "")
        {
            flag[1] = false;   
            $("#ecost").text("Course cost can't be blank");
            $("#ecost").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");  
        }
        else
        {
            $("#ecost").css("visibility","hidden");
            $(this).addClass("valid-field");
            $(this).removeClass("invalid-field");
            flag[1] = true;
        }
	
        if ($("#edit_credit").val() == "")
        {
            flag[2] = false;   
            $("#ecredit").text("Credit can't by empty");
            $("#ecredit").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");  
        }
        else
        {
            $("#ecredit").css("visibility","hidden");
            $(this).addClass("valid-field");
            $(this).removeClass("invalid-field");
            flag[2] = true;
        }

		if(flag[0] && flag[1] && flag[2]){
			$("#edit_course_name").attr("readonly",true);
			$("#edit_cost").attr("readonly",true);
			$("#edit_credit").attr("readonly",true);
			$("#desc").attr("readonly",true);
			$.ajax({
	            type:"POST",
	            url:"CourseServlet",
	            data: { 
					course_id: $("#edit_course_id").val(),
                    course_name: $("#edit_course_name").val(),
					term: $("#edit_term").val(),
					status: $("#edit_status").val(),
					course_mode: $("#edit_mode").val(),
					level: $("#edit_level").val(),
					credit: $("#edit_credit").val(),
					cost: $("#edit_cost").val(),
					desc: $("#desc").val(),
					mode: "edit"
	            },
	            success: function (data){
					alert("Course has been updated successfully");
	            },
	            error: function (data){
	                console.log(data);
	            }
	        });
			$("#editBtn").toggle();
			$("#saveBtn").toggle();
			$("#deleteBtn").toggle();
		}
		else{
			return;
		}
		
	});
	
	$("#deleteBtn").on("click",function(){
        $.ajax({
            type:"POST",
            url:"CourseServlet",
            data: { 
				course_id: $("#edit_course_id").val(),
				mode: "delete"
            },
            success: function (data){
				alert("Course has been deleted successfully");
				window.location = "/CourseManagement/homePage.jsp";
            },
            error: function (data){
                console.log(data);
            }
        });
    });

	$("#courseDropBtn").on("click",function(){
        $.ajax({
            type:"POST",
            url:"MyCourseServlet",
            data: { 
				course_id: $("#edit_course_id").val(),
            },
            success: function (data){
				alert("Course has been dropped successfully");
				window.location = "/CourseManagement/homePage.jsp";
            },
            error: function (data){
                console.log(data);
            }
        });
    });
});