$(document).ready(function(){
    $(".dialog-close").on("click",function(){
        $(this).parent().hide();
        $(".mdl-layout__container").removeClass("blur-filter");
    })
    var flag = [false,false,false,false,false,false,false,false,false,false];
    var fname,lname,addr1, addr2, pin, phone, city, email, pwd;
    $("#fname").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[0] = false;   
            $("#eFname").text("First name can't by empty");
            $("#eFname").css("visibility","visible");
            $(this).addClass("invalid-field");  
        }
        else
        {
            $("#eFname").css("visibility","hidden");
            $(this).addClass("valid-field");
            flag[0] = true;
            enableButton(flag);
            fname = $(this).val();
        }
    });
    $("#lname").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[1] = false;   
            $("#eLname").text("Last name can't by empty");
            $("#eLname").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");  
            enableButton(flag); 
        }
        else
        {
            $("#eLname").css("visibility","hidden");
            $(this).addClass("valid-field");
            $(this).removeClass("invalid-field"); 
            flag[1] = true;
            enableButton(flag);
            lname = $(this).val();
        }
    });
    $("#addr1").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[2] = false; 
            $("#eAddr1").text("Address can't by empty");
            $("#eAddr1").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field"); 
            enableButton(flag);  
        }
        else
        {
            $("#eAddr1").css("visibility","hidden");
            $(this).addClass("valid-field");
            $(this).removeClass("invalid-field");
            flag[2] = true;
            enableButton(flag);
            addr1 = $(this).val();
        }
    });
    $("#addr2").on("blur",function(){
        addr2 = $("#addr2").val();
    });
    
    $("#phone").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[3] = false;   
            $("#ePhone").text("Phone number can't by empty");
            $("#ePhone").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field"); 
            enableButton(flag);  
        }
        else
        {
            if ($(this).val().length != 10)
            {
                console.log($(this).val().length)
                console.log("inval");
                flag[3] = false;   
                $("#ePhone").text("Phone number should have 10 digits");
                $("#ePhone").css("visibility","visible");
                $(this).addClass("invalid-field"); 
                $(this).removeClass("valid-field"); 
                enableButton(flag);  
            }
            else
            {
                console.log($(this).val().length)
                $("#ePhone").css("visibility","hidden");
                $(this).addClass("valid-field");
                $(this).removeClass("invalid-field");
                flag[3] = true;
                enableButton(flag);
                phone = $(this).val();
            }
        }
    });
    $("#city").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[4] = false;;   
            $("#eCity").text("City can't by empty");
            $("#eCity").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field"); 
            enableButton(flag);
              
        }
        else
        {
            $("#eCity").css("visibility","hidden");
            $(this).addClass("valid-field");
            $(this).removeClass("invalid-field");
            flag[4] = true;
            enableButton(flag);
            city = $(this).val();
        }
    });
    $("#pin").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[5] = false;   
            $("#ePin").text("Pin code can't by empty");
            $("#ePin").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");   
            enableButton(flag);
        }
        else
        {
            if ($(this).val().length != 5)
            {
                flag[5] = false;   
                $("#ePin").text("Pin code should have 5 digits");
                $("#ePin").css("visibility","visible");
                $(this).addClass("invalid-field"); 
                $(this).removeClass("valid-field"); 
                enableButton(flag);  
            }
            else
            {
                $("#ePin").css("visibility","hidden");
                $(this).addClass("valid-field");
                $(this).removeClass("invalid-field");
                flag[5] = true;
                enableButton(flag);
                pin = $(this).val();
            }
        }
        

    });
    $("#emailF").on("blur",function(){
        if ($(this).val() == "")
        {
            flag[6] = false;   
            $("#eEmail").text("Email can't by empty");
            $("#eEmail").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");  
            enableButton(flag); 
        }
        else
        {
            if(!$(this).val().match(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/))
            {
                flag[6] = false;   
                $("#eEmail").text("Invalid Email");
                $("#eEmail").css("visibility","visible");
                $(this).addClass("invalid-field"); 
                $(this).removeClass("valid-field"); 
                enableButton(flag);
            }
            else
            {
                $("#eEmail").css("visibility","hidden");
                $(this).addClass("valid-field");
                $(this).removeClass("invalid-field");
                flag[6] = true;
                enableButton(flag);
                email = $(this).val();
            }
            
        }
    });
    var flag1 = false;
    $('#pwd').keyup(function() {
        var pswd = $(this).val();
        
        //validate the length
        if ( pswd.length < 8 ) {
            $('#length').removeClass('valid').addClass('invalid');
            flag1 = false;
    
        } else {
            $('#length').removeClass('invalid').addClass('valid');
            flag1 = true;
        }
        //validate letter
        if ( pswd.match(/[A-z]/) ) {
            $('#letter').removeClass('invalid').addClass('valid');
            flag1 = true;
        } else {
            $('#letter').removeClass('valid').addClass('invalid');
            flag1 = false;
        }

        //validate capital letter
        if ( pswd.match(/[A-Z]/) ) {
            $('#capital').removeClass('invalid').addClass('valid');
            flag1 = true;
        } else {
            $('#capital').removeClass('valid').addClass('invalid');
            flag1 = false;
        }

        //validate number
        if ( pswd.match(/\d/) ) {
            $('#number').removeClass('invalid').addClass('valid');
            flag1 = true;
        } else {
            $('#number').removeClass('valid').addClass('invalid');
            flag1 = false;
        }
    });
    $('#pwd').focus(function() {
        $('#pswd_info').show();
    });
    $('#pwd').blur(function() {
        $('#pswd_info').hide();
        if(flag1)
        {
            $("#ePwd").css("visibility","hidden");
            $(this).addClass("valid-field");
            $(this).removeClass("invalid-field");
            flag[7] = true;
            enableButton(flag);
            pwd = $(this).val();
        }
        else
        {
            flag[7] = false;
            $("#ePwd").text("Invalid Email");
            $("#ePwd").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field"); 
            enableButton(flag);

        } 
    });
    $("#email-conf").on("blur",function(){
        if($(this).val() == "")
        {
            flag[8] = false;   
            $("#eEmailC").text("Confirmation Email can't by empty");
            $("#eEmailC").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");
            enableButton(flag);
        }
        else
        {
            if($(this).val() != $("#emailF").val())
            {
                flag[8] = false;   
                $("#eEmailC").text("Emails don't match");
                $("#eEmailC").css("visibility","visible");
                $(this).addClass("invalid-field"); 
                $(this).removeClass("valid-field");
                enableButton(flag);
            }
            else
            {
				$("#eEmailC").css("visibility","hidden");
                $(this).addClass("valid-field");
                $(this).removeClass("invalid-field");
                flag[8] = true;
                enableButton(flag);
            }
        }
    });
    $('#email-conf').bind("cut copy paste",function(e) {
        e.preventDefault();
    });
    $("#pwd-conf").on("blur",function(){
        if($(this).val() == "")
        {
            flag[9] = false;   
            $("#ePwdC").text("Confirmation Password can't by empty");
            $("#ePwdC").css("visibility","visible");
            $(this).addClass("invalid-field"); 
            $(this).removeClass("valid-field");
            enableButton(flag);
        }
        else
        {
            if($(this).val() != $("#pwd").val())
            {
                flag[9] = false;  

                $("#ePwdC").text("Passwords don't match");
                $("#ePwdC").css("visibility","visible");
                $(this).addClass("invalid-field"); 
                $(this).removeClass("valid-field");
                enableButton(flag);
            }
            else
            {
                $("#ePwdC").css("visibility","hidden");
                $(this).addClass("valid-field");
                $(this).removeClass("invalid-field");
                flag[9] = true;
                enableButton(flag);
            }
        }
    })


 function enableButton(flag)
    {
        var final = true;
        flag.forEach(function (item, index){
            final = final && item;
        })
        if(!final)
        {
            $("#addsubmit").prop('disabled', true);
			$("#submit").prop('disabled', true);
        }
        else
        {
            $("#addsubmit").prop('disabled', false);
			$("#submit").prop('disabled', false);
        }
    }

    $("#submit").on("click",function(e){
        $(".progress").css("visibility","visible");
        e.preventDefault();
		var role = "student";
		if($('input[type=radio][name=role]') != null){
			role =  $('input[type=radio][name=role]:checked').val();
			console.log(role);
		} 
        $.ajax({
            type:"POST",
            url:"SignupServlet",
            data: { fname: fname,
                    lname: lname,
                    addr1: addr1,
                    addr2: addr2,
                    pin: pin,
                    phone: phone,
                    city: city,
                    email: email,
                    pwd: pwd,
                    gender: $('input[type=radio][name=gender]:checked').val() ,
					role : "student"
			},
            success: function (data){
               	console.log(JSON.stringify(data));
                $(".progress").css("visibility","hidden");
                $(".mdl-layout__container").addClass("blur-filter");
                if(data == "user exists") $("#dialog-email").fadeIn(100);
                else if(data == "successfully registered") $("#dialog-registered").fadeIn(100);
            },
            error: function (data){
                alert(JSON.stringify(data));
            }
        });
    })
	
	$("#addsubmit").on("click",function(e){
        $(".progress").css("visibility","visible");
        e.preventDefault();
		$.ajax({
            type:"POST",
            url:"SignupServlet",
            data: { fname: fname,
                    lname: lname,
                    addr1: addr1,
                    addr2: addr2,
                    pin: pin,
                    phone: phone,
                    city: city,
                    email: email,
                    pwd: pwd,
                    gender: $('input[type=radio][name=gender]:checked').val() ,
					role : $('input[type=radio][name=role]:checked').val()
			},
            success: function (data){
               	console.log(JSON.stringify(data));
                $(".progress").css("visibility","hidden");
                $(".mdl-layout__container").addClass("blur-filter");
                if(data == "user exists") $("#dialog-email").fadeIn(100);
                else if(data == "successfully registered") $("#dialog-registered").fadeIn(100);
            },
            error: function (data){
                alert(JSON.stringify(data));
            }
        });
    })

})