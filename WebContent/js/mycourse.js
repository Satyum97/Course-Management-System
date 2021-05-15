$(document).ready(function (){
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
				var courses = JSON.parse(data);
				if(courses == null || courses.length == 0)
	            {
	                $("#productResults").append("<div class = 'gotu' style = 'text-align: center;font-size: xx-large;padding: 20px 0px'>No courses found</div>");
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