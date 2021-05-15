$(document).ready(function (){
	var flag = [false,false,false,false];
	$("#course_id").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[0] = false;   
            $("#ecourse_id").text("Course Id can't be blank");
            $("#ecourse_id").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");  
        }
        else
        {
            $("#ecourse_id").css("visibility","hidden");
            $(this).addClass("valid-field");
            $(this).removeClass("invalid-field");
            flag[0] = true;
        }
    });

	$("#course_name").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[1] = false;   
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
            flag[1] = true;
        }
    });

	$("#credit").on("blur",function(){
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

	$("#cost").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[3] = false;   
            $("#ecost").text("Cost can't by empty");
            $("#ecost").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");  
        }
        else
        {
            $("#ecost").css("visibility","hidden");
            $(this).addClass("valid-field");
            $(this).removeClass("invalid-field");
            flag[3] = true;
        }
    });

	$("#coursebtn").on("click",function(){
		if(flag[0] == true && flag[1] == true && flag[2] == true && flag[3] == true){
	        $.ajax({
	            type:"POST",
	            url:"CourseAddServlet",
	            data: { 
					course_id: $("#course_id").val(),
                    course_name: $("#course_name").val(),
					term: $("#term").val(),
					status: $("#status").val(),
					mode: $("#mode").val(),
					level: $("#level").val(),
					credit: $("#credit").val(),
					cost: $("#cost").val(),
					desc : $("#desc").val()
	            },
	            success: function (data){
					alert("Course has been created successfully");
	                window.location = "/CourseManagement/CourseServlet?course_id="+data;
	            },
	            error: function (data){
	                console.log(data);
	            }
	        });
		}
		else{
			
		}
    });
});