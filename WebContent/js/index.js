$(document).ready(function (){
	$(".products").empty();
    $(".spinner").css("display","none");
    var dialog = $("#dialog");
    var dialogDelivery = $("#dialog-delivery");
    var dialogNoDelivery = $("#dialog-no-delivery");
    var flag = [false,false];

	$("#email").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[0] = false;   
            $("#eEmail").text("Email can't by empty");
            $("#eEmail").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");  
        }
        else
        {
            if(!$(this).val().match(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/))
            {
                flag[0] = false;   
                $("#eEmail").text("Invalid Email");
                $("#eEmail").css("visibility","visible");
                $(this).addClass("invalid-field"); 
                $(this).removeClass("valid-field"); 
            }
            else
            {
                $("#eEmail").css("visibility","hidden");
                $(this).addClass("valid-field");
                $(this).removeClass("invalid-field");
                flag[0] = true;
            }
            
        }
    });

	$("#password").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[1] = false;   
            $("#ePassword").text("Password can't by empty");
            $("#ePassword").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");  
        }
        else
        {
            $("#ePassword").css("visibility","hidden");
            $(this).addClass("valid-field");
            $(this).removeClass("invalid-field");
            flag[1] = true;
        }
    });

    $("#login").click(function (){
        dialog.fadeIn(100);
        $(".mdl-layout__container").addClass("blur-filter");
    });

    $("#dialog-close-1").click(function (){
        dialog.hide();
        $(".mdl-layout__container").removeClass("blur-filter");
        clearTimeout(timeout);
    });

    $("#dialog-close-2").click(function (){
        dialogDelivery.hide();
        $(".mdl-layout__container").removeClass("blur-filter");
    });

	

    $("#dialog-close-3").click(function (){
        dialogNoDelivery.hide();
        $(".mdl-layout__container").removeClass("blur-filter");
    });

    $("#login-btn").on("click",function(){
		if(flag[0] == true && flag[1] == true){
	        $.ajax({
	            type:"POST",
	            url:"LoginServlet",
	            data: { 
						email: $("#email").val(),
	                    pwd: $("#password").val()
	                },
	            success: function (data){
	                if(data == "error"){
						$("#loginError").text("Invalid credentials");
                		$("#loginError").css("visibility","visible");
					}
					else{
						$("#loginError").css("visibility","hidden");
						dialog.hide();
						$(".mdl-layout__container").removeClass("blur-filter");
						location.reload(true);
					}
	            },
	            error: function (data){
	                console.log(data.message);
	            }
	        });
		}
    });

	$("#resetbtn").on("click",function(){
		$("#productResults").html("");
		$("#term")[0].selectedIndex = 0;
		$("#status")[0].selectedIndex = 0;
		$("#mode")[0].selectedIndex = 0;
		$("#level")[0].selectedIndex = 0;
	});
	
    $("#coursebtn").on("click",function(){
		$(".spinner").css("display","block");
		$("#productResults").html("");
		$.ajax({
            type:"POST",
            url:"CourseGetServlet",
            data: { 
					term: $("#term").val(),
                    status: $("#status").val(),
					mode: $("#mode").val(),
                    level: $("#level").val() 
                },
            success: function (data){
				$(".spinner").css("display","none");
				var courses = [];
				if(data!="error")
					courses = JSON.parse(data);
				if(courses == null || courses.length == 0)
	            {
	                $("#productResults").append("<div class = 'gotu' style = 'color:red;text-align: center;font-size: xx-large;padding: 20px 0px'>No courses found</div>");
	            }
				else
	            {
					var s = `<table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp" style="width:90%;">
					  <thead>
					    <tr>
						  <th>Course ID</th>
					      <th>Course Name</th>
					      <th>Term</th>
						  <th>Mode</th>
					      <th>Status</th>
						  <th>Level</th>
					    </tr>
					  </thead>
					  <tbody>`;
					for(var i = 0; i < courses.length ; i++) 
					{
						var courseID = courses[i]['course_id'];
						var term = courses[i]['term'];
						var status = courses[i]['status'];
						var mode = courses[i]['mode'];
						var level = courses[i]['level'];
						var course_name = courses[i]['course_name'];
						
						s += `<tr>
						<td><a href="CourseServlet?course_id=`+courseID+`">`+courseID+`</a></td>
						<td>`+course_name+`</td>
						<td>`+term+`</td>
						<td>`+mode+`</td>
						<td>`+status+`</td>
						<td>`+level+`</td>
						</tr>`;
					
					} //for loop ends here
					
					s += `</tbody>
						</table>`;
					var htmlObject = $(s); 
					$(htmlObject).appendTo("#productResults");
				}
            },
            error: function (data){
				$(".spinner").css("display","none");
                console.log(data.message);
            }
        });
    });
});
