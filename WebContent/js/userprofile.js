$(document).ready(function() {

    $("#transactions").on("click", function() {
        loadtransactions(userid);
        $("#myprofile").css("background-color", "#ffffff")
        $("#transactions").css("background-color", "#f8bbd0");
        $(".main-card").hide();
        $(".main-card1").show();
    });

    $("#myprofile").on("click", function() {
        $("#transactions").css("background-color", "#ffffff")
        $("#myprofile").css("background-color", "#f8bbd0");
        $(".main-card1").hide();
        $(".main-card").show();
    });

    active = 0;
    $(".points").text("Reward Points : "+points);

    if(gender == "f")
        {
            $(".userphoto").attr("src", "images/woman.png");
        }
        else
        {
            $(".userphoto").attr("src", "images/man.png");
        }

    $.ajax({
        type:"POST",
        url:"./includes/edituserprofile.php",
        data: { userid : userid },
        success: function (data){
            $(".editform").children().addClass("is-dirty");
            var userdata = JSON.parse(data);
            console.log(userdata);
            var fname = userdata[0]['fname'];
            var lname = userdata[0]['lname'];
            var addr1 = userdata[0]['addr1'];
            var addr2 = userdata[0]['addr2'];
            var zip = userdata[0]['zip'];
            var city = userdata[0]['city'];
            var email = userdata[0]['email'];
            var points = userdata[0]['points'];

            if(userdata.length == 2)
            {
                var addr21 = userdata[1]['addr1'];
                var addr22 = userdata[1]['addr2'];
                var zip2 = userdata[1]['zip'];
                var city2 = userdata[1]['city'];

                $(".secaddr").children().addClass("is-dirty");
                $("#addr21").val(addr21);
                $("#addr22").val(addr22);
                $("#zip2").val(zip2);
                $("#city2").val(city2);
                active = 1;
                $(".cancelbtn").show();
                $(".secaddr").css("display","block");
                $(".addbtn").prop('disabled', true);
                $(".addbtn").css("cursor", "not-allowed");
            }
            else
            {
                $(".cancelbtn").hide();
                $(".secaddr").hide();
            }
            
            $("#fname").val(fname);
            $("#lname").val(lname);
            $("#addr11").val(addr1);
            $("#addr12").val(addr2);
            $("#zip").val(zip);
            $("#city").val(city);

            $(".addbtn").on("click", function() {
                active = 1;
                $(".cancelbtn").show();
                $(".secaddr").show();
                $(".addbtn").prop('disabled', true);
                $(".addbtn").css("cursor", "not-allowed");
            });

            $(".cancelbtn").on("click", function() {
                active = 0;
                $(".cancelbtn").hide();
                $(".secaddr").hide();
                $(".addbtn").prop('disabled', false);
                $(".addbtn").css("cursor", "pointer");
            });

            $(".savebtn").on("click", function() {
                updateuserprofile(userid, active);
            });

            $(".deletebtn").on("click", function() {
                deleteaddress(userid);
            });
        },
        error: function (data){
            console.log(data.message);
        }
    });


    function updateuserprofile(userid, active)
{
    if(active == 0 || ($("#addr21").val() != "" && $("#addr22").val() != "" && $("#zip2").val() != "" && $("#city2").val() != ""))
    {
        $.ajax({
            url: "./includes/updateuserprofile.php",
            data: { userid: userid,
                    active: active,
                    fname: $("#fname").val(),
                    lname: $("#lname").val(),
                    addr11: $("#addr11").val(),
                    addr12: $("#addr12").val(),
                    zip: $("#zip").val(),
                    city: $("#city").val(),
                    addr21: $("#addr21").val(),
                    addr22: $("#addr22").val(),
                    zip2: $("#zip2").val(),
                    city2: $("#city2").val()
                },
            success: function(data){
                alert("Address added Successfully!");
            },
            error: function (error){
                console.log(error);
            }
        });
    }
    else
    {
        alert("Please fill all the fields!");
    }
}

function deleteaddress(userid)
{
    $.ajax({
        url: "./includes/deleteaddress.php",
        data: { userid: userid,
                addr21: $("#addr21").val(),
                addr22: $("#addr22").val(),
                zip2: $("#zip2").val(),
                city2: $("#city2").val()},
        success: function(data){
            alert("Address deleted Successfully");
            location.reload();
        },
        error: function (error){
            console.log(error);
        }
    });
}


function loadtransactions(userid)
{
    $.ajax({
        url: "./includes/loadtransactions.php",
        data: { userid: userid},
        success: function(data){
            var transdata = JSON.parse(data);
            console.log(transdata);
            if(transdata.length > 0)
            {
                var t = `<table class="mdl-data-table mdl-js-data-table mdl-data-table mdl-shadow--2dp" style="margin: 2% auto 5%; border-collapse: collapse;" border = 1>
                        <h3 class="gotu" style="margin-left: 2%;">My Transactions:</h3>
                        <thead>
                            <tr>
                            <th class="mdl-data-table__cell--non-numeric" style="text-align:center;">Transaction Reference#</th>
                            <th class="mdl-data-table__cell--non-numeric" style="text-align:center;">Date & Time</th>
                            <th class="mdl-data-table__cell--non-numeric" style="text-align:center;">Product Details</th>
                            <th style="text-align:center;">Total Amount</th> 
                            </tr>
                        </thead>`;

                        for(i = 0; i < transdata.length; i++)
                        {
                            var fullname = username[0]+lname[0];
                            var userid = transdata[i]['t_uid'];
                            var timestamp = transdata[i]['time'];
                            timestamp = timestamp.split(' ');
                            var date = timestamp[0].replace("-","");
                            var finaldate = date.replace("-","");
                            var transid = fullname+userid+finaldate;

                            t += `<tr>
                                     <td class="mdl-data-table__cell--non-numeric" style="text-align:center;"><b>#`+transid+`</b></td>
                                     <td class="mdl-data-table__cell--non-numeric" style="text-align:center;">`+transdata[i]['time']+`</td>`;

                            orders = transdata[i]['orders'];
                            orderitems = "";
                            for(j = 0; j < orders.length; j++)
                            {
                                if(orders[j]['extras'] == false)
                                {
                                    orders[j]['extras'] = "No extras";
                                }
                                if(j == orders.length - 1)
                                    orderitems += orders[j]['category']+" - ("+orders[j]['quantity']+") <b>"+orders[j]['itemname']+"</b> <i>["+orders[j]['extras']+"]</i>";
                                else
                                    orderitems += orders[j]['category']+" - ("+orders[j]['quantity']+") <b>"+orders[j]['itemname']+" </b> <i>["+orders[j]['extras']+"]</i>, "+"<br>";
                            }

                            t += `
                                <td class="mdl-data-table__cell--non-numeric" style="text-align:center;">`+orderitems+`</td>
                                <td class="numeric" style="text-align:center;">$`+transdata[i]['price']+`</td></tr>`;
                        }

                        t += `</table>`;     
                        $(".main-card1").html(t);
            }
            else
            {
                $(".main-card1").html(`<h3>No Transaction history available!</h3>`);
            }
        },
        error: function (error){
            console.log(error);
        }
    });
}

});





