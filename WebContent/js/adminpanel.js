$(document).ready(function(){
    $(".nav").on("click",function(e)
    {  
        var redir = $(this).attr("redir");
        $(".container").load(redir);
    });

    
    $("#signout").on("click",function(){
        $.ajax({
            type:"POST",
            url:"includes/signout.php",
            success: function (data){
                console.log(data);
                window.location.replace("index.html");
            },
            error: function (data){
                alert(data.message);
            }
        });
    })


    document.getElementById("uploadBtn").onchange = function () {
        document.getElementById("uploadFile").value = this.files[0].name;
        $("#product-preview").remove();
        $(".centered").remove();
        $(".productimage").prepend('<img id="product-image" src="#" alt="Product-Image">');
        $("[for=uploadfile]").text(" ");
    };


    // To display the product image
    function readURL(input) {
        if(input.files && input.files[0]) {
          var reader = new FileReader();
          reader.onload = function(e) {
            $('#product-image').attr('src', e.target.result);
          }     
          reader.readAsDataURL(input.files[0]); // convert to base64 string
        }
      }
      $("#uploadBtn").change(function() {
        readURL(this);
      });

      spl = 0;

      $("#special").change(
        function(){
            if ($(this).is(':checked')) {
                 spl = 1;
            }
            else {
                 spl = 0;
            }
        });


    // Ajax call for adding new products
    $(".productbtn").on("click",function(e){
        $(".progress-inventory").css("visibility","visible");
        e.preventDefault();
        var file_data = $('#uploadBtn').prop('files')[0];
        var formData = new FormData();
        formData.append('file', file_data);
        formData.append('itemname', $("#itemname").val());
        formData.append('category', $("#category").val());
        formData.append('description', $("#description").val());
        formData.append('invqty', $("#invqty").val());
        formData.append('rate', $("#rate").val());
        formData.append('itemid', $("#itemid").val());
        formData.append('special', spl);
        $.ajax({
            type:"POST",
            url:"includes/addProduct.php",
            cache: false,
            contentType: false,
            processData: false,
            data: formData,
            success: function(data){
                if(data == "1")
                {
                    $(".productbtn").html("Product successfully added to inventory");
                    setTimeout(function(){
                        //fade back
                        $(".productbtn").html("Add to inventory");
                        $(".progress-inventory").css("visibility","hidden");
                        $(".productsform").trigger('reset');
                        $("[for=uploadfile]").text("Product Image");
                        $(".productsform").children().removeClass("is-dirty");
                        $("#product-image").remove();
                        $(".productimage").prepend('<img id="product-preview" src="./images/product-preview.png" alt="Product-Preview">');
                        $(".productimage").prepend('<div class="centered">Preview</div>');
                        document.querySelector('.mdl-js-checkbox').MaterialCheckbox.uncheck();
                        spl = 0;
                    }, 2000);
                }
                else
                {
                    console.log(data);
                }
            },
            error: function (data){
                alert(data.message);
            }
        });
    });


    // Ajax call for adding coupons
    $(".couponbtn").on("click",function(e){
        $(".progress-coupon").css("visibility","visible");
        e.preventDefault();
        $.ajax({
            type:"POST",
            url:"includes/addCoupon.php",
            data: { cname: $("#cname").val(),
                    amtoff: $("#amtoff").val(),
                    dateadded: $("#dateadded").val(),
                    duedate: $("#duedate").val(),
                    lmt: $("#lmt").val()},
            success: function(data){
                if(data == "1")
                {
                    $(".couponbtn").html("Coupon added successfully");
                    setTimeout(function(){
                        //fade back
                        $(".progress-coupon").css("visibility","hidden");
                        $(".couponbtn").html("Add Coupon");
                        $(".productsform1").trigger('reset');
                        $(".mdl-textfield").removeClass("is-dirty"); 
                    }, 2000);
                }
            },
            error: function (data){
                alert(data.message);
            }
        });
    });


    

    //Ajax call for adding extras
    $(".extrabtn").on("click",function(e){
        $(".progress-extra").css("visibility","visible");
        e.preventDefault();
        $.ajax({
            type:"POST",
            url:"includes/addExtra.php",
            data: { eid: $("#eid").val(),
                    ename: $("#ename").val(),
                    category1: $("#category1").val(),
                    rate: $("#rate1").val()},
            success: function(data){
                console.log(data);
                if(data == "1") 
                {
                    $(".extrabtn").html("Extra Item added successfully");
                    setTimeout(function(){
                        //fade back
                        $(".progress-extra").css("visibility","hidden");
                        $(".extrabtn").html("Add Extra");
                        $(".productsform2").trigger('reset');
                        $(".mdl-textfield").removeClass("is-dirty"); 
                    }, 2000);
                }
            },
            error: function (data){
                alert(data.message);
            }
        });
    });







});