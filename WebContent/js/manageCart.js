$(document).ready(function() {
    $.ajax({
        url: "./manageCart.php",
        data: { 
        },
        success: function(data){
            loadCart(data);
        }
    });

    $("#dialog-close").click(function (){
        $("#customize").hide();
        $(".mdl-layout__content").removeClass("blur-filter");
    });

    $("#placeOrder").click(function(){
        addr = $('input[name=addr]:checked', '#myForm').val(); 
        $.ajax({
            url: "./manageCart.php",
            data: { 
                action: "placeOrder",
                uaid: addr
            },
            success: function(data){
                $("#customize").hide();
                $(".mdl-layout__content").removeClass("blur-filter");
                window.location.href = "./orderDetails.php?orderId="+data;
            }
        });
    });
});

function loadCart(data){
    console.log(data);
    var products = JSON.parse(data);
    if(products!=null && products!=undefined && products.length > 0){
        var s = `
        <div class="pb-5">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                        <div class="table-responsive" id="cartContent">
                            <table class="table">
                            <thead>
                                <tr>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="p-2 px-3 text-uppercase">Product</div>
                                </th>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Price</div>
                                </th>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Quantity</div>
                                </th>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Subtotal</div>
                                </th>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase"></div>
                                </th>
                                </tr>
                            </thead>
                            <tbody>`;
                            var disableCoupon = false;
                            var totalPrice = 0;
                            var totalQuantity = 0;
                            var couponApplied = products[0]['couponApplied'];
                            var couponCode = products[0]['couponCode'];
                            var couponMessage = products[0]['couponMessage'];
                            if(couponApplied){
                                
                                if(couponMessage === "" || couponMessage === "expired" || couponMessage === "invalid"){
                                    disableCoupon = false;
                                }
                                else{
                                    disableCoupon = true;
                                }
                            }
                            for(var i = 0; i < products.length ; i++){
                                totalPrice += parseFloat(products[i]['rate']) * parseInt(products[i]['quantity']);
                                totalQuantity +=parseInt(products[i]['quantity']);
                                s += `<tr>
                                    <th scope="row" class="border-0">
                                        <div class="p-2">
                                            <img src="`+products[i]['imagepath']+`" alt="" width="70" class="img-fluid rounded shadow-sm">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h5 class="mb-0">
                                                    <a href="#" class="text-dark d-inline-block align-middle">`+products[i]['itemname']+`</a>
                                                </h5>
                                                <span class="text-muted font-weight-normal font-italic d-block"></span>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="border-0 align-middle"><strong>$`+products[i]['rate']+`</strong></td>
                                    <td class="border-0 align-middle"><strong>
                                    <div class="input-group">
                                        <input type="button" value="-" class="button-minus red-button" data-field="quantity" onclick="subtractItem('`+products[i]["productId"]+`');">
                                        <input type="number" step="1" readonly="readonly" max="`+products[i]['invqty']+`" value="`+products[i]['quantity']+`" name="quantity" class="quantity-field">
                                        <input type="button" value="+" class="button-plus" data-field="quantity" onclick="addItem('`+products[i]["productId"]+`');">
                                    </div></strong></td>
                                    <td class="border-0 align-middle"><strong>$`+(parseFloat(products[i]['rate']) * parseInt(products[i]['quantity'])).toFixed(2)+`</strong></td>
                                    <td class="border-0 align-middle">
                                        <button class="btn btn-danger" onclick="removeItem('`+products[i]["productId"]+`');" ><i class="fa fa-trash"></i></button>
                                    </td>
                                </tr>`;
                            }
                            s += `</tbody>
                            <tfoot>
                                <tr>
                                    <td><a href="../menu.php" class="btn btn-warning rounded-pill "><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
                                    <td colspan="4" class="hidden-xs"></td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>

                <div class="row py-5 p-4 bg-white rounded shadow-sm">
                    <div class="col-lg-6">
                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Coupon code</div>
                        <div class="p-4">
                            <p class="font-italic mb-4">If you have a coupon code, please enter it in the box below</p>
                            <div class="input-group mb-4 border p-2">`;
                            if(disableCoupon){
                                s+=`<input type="text" placeholder="Apply coupon" id="couponCode" disabled aria-describedby="button-addon3" class="form-control border-0"  value="`+couponCode+`">`;
                            }
                            else{
                                s+=`<input type="text" placeholder="Apply coupon" onkeydown="hideMsg();" id="couponCode" aria-describedby="button-addon3" class="form-control border-0"  value="`+couponCode+`">`;
                            }
                            s+=`<div class="input-group-append border-0">`;
                            if(disableCoupon){
                                s+=`<button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill" id="coupon" onclick="removeCoupon();"><i class="fa fa-trash mr-2"></i>Remove coupon</button>`;
                            }
                            else{
                                s+=`<button id="button-addon3" type="button" class="btn btn-dark px-4 rounded-pill" id="coupon" onclick="applyCoupon();"><i class="fa fa-gift mr-2"></i>Apply coupon</button>`;
                            }
                            if(couponApplied){
                                if(disableCoupon){
                                    s += `<span style="color:green" id="msg">Coupon successfully applied!</span>`;
                                }
                                else{
                                    if(couponMessage != ""){
                                        s += `<span style="color:red" id="msg">Coupon is  `+couponMessage+`</span>`;
                                    }
                                }
                            }
                            s+=`</div>
                        </div>
                    </div>
                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Instructions for seller</div>
                    <div class="p-4">
                        <p class="font-italic mb-4">If you have some information for the seller you can leave them in the box below</p>
                        <textarea name="" cols="30" rows="2" class="form-control"></textarea>
                    </div>
                    </div>
                    <div class="col-lg-6">
                    <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Order summary </div>
                    <div class="p-4">
                        <p class="font-italic mb-4">Shipping and additional costs are calculated based on values you have entered.</p>
                        <ul class="list-unstyled mb-4">
                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Order Subtotal </strong><strong>$`+totalPrice.toFixed(2)+`</strong></li>
                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tax</strong><strong>$0.00</strong></li>`
                        if(disableCoupon){
                            s+=`<li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Coupon Discount</strong><strong>-$`+(totalPrice * parseInt(couponMessage) / 100).toFixed(2)+`</strong></li>`;
                        }                        
                        s+= `<li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Total</strong>
                            <h5 class="font-weight-bold">$`;
                        if(disableCoupon){
                            s+= (totalPrice - totalPrice * couponMessage / 100).toFixed(2);
                        }
                        else{
                            s+= totalPrice.toFixed(2);
                        }
                        s+=`</h5>
                        </li>
                        </ul><button class="btn btn-dark rounded-pill py-2 btn-block" onclick="checkout();">Proceed to checkout</button>
                    </div>
                    </div>
                </div>
            </div>
        </div>`;
        $("#results").html(s);
    }
    else{
        var s = `
        <div class="pb-5">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                        <div class="table-responsive" id="cartContent">
                            <script>
                                imageSources = ["Ice Cream Icons-01.png", "Ice Cream Icons-02.png",
                                "Ice Cream Icons-03.png","Ice Cream Icons-04.png","Ice Cream Icons-05.png",
                                "Ice Cream Icons-06.png","Ice Cream Icons-07.png","Ice Cream Icons-08.png",
                                "Ice Cream Icons-09.png","Ice Cream Icons-10.png","Ice Cream Icons-11.png",
                                "Ice Cream Icons-12.png","Ice Cream Icons-13.png","Ice Cream Icons-14.png",
                                "Ice Cream Icons-15.png","Ice Cream Icons-16.png"]
                                index = 0
                                timeout = setInterval(function(){ 
                                    if(index == imageSources.length)
                                        index = 0;
                                        $('#images').attr('src', '../images/'+imageSources[index]);
                                        index++;
                                    },
                                    1500);
                            </script>
                            <div class="mdl-grid">
                                <div class="mdl-layout-spacer"></div>
                                <div class="mdl-cell mdl-cell--4-col">
                                    <div class="img-switcher-cart ">
                                        <img src="../images/Ice Cream Icons-01.png" alt="ice creams" width="100%;" id="images"><br/>
                                        <div class ="product-title gotu" style="width:100%">Your Cart Is Currently Empty!</div>
                                        <br/><br/>
                                        <a href="../menu.php" class="btn btn-warning rounded-pill "> Return to Shop</a>             
                                    </div>
                                </div>
                                <div class="mdl-layout-spacer"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>`;
        $("#results").html(s);
    }
}

function removeItem(itemId){
    $.ajax({
        url: "./manageCart.php",
        data: { 
            action: "remove",
            productId: itemId
        },
        success: function(data){
            loadCart(data);
        }
    });
}

function addItem(itemId){
    $.ajax({
        url: "./manageCart.php",
        data: { 
            action: "add",
            productId: itemId
        },
        success: function(data){
            loadCart(data);
        }
    });
}

function subtractItem(itemId){
    $.ajax({
        url: "./manageCart.php",
        data: { 
            action: "subtract",
            productId: itemId
        },
        success: function(data){
            loadCart(data);
        }
    });
}

function checkout(){
    $.ajax({
        url: "./manageCart.php",
        data: { 
            action: "checkout"
        },
        success: function(data){
            if(data == 1){
                alert("Please sign in first");
            }
            else{
                if(data!=null && data!=undefined){
                    var addresses = JSON.parse(data);
                    if(addresses!=null && addresses.length > 0){
                        var s = ``;
                        for(var i = 0 ; i < addresses.length ; i++){
                            s+=`<form id="myForm"><label class="mdl-radio mdl-js-radio mdl-js-ripple-effect radio-block">`;
                            if(i == 0){
                                s+=`<input type="radio" class="mdl-radio__button" name="addr" checked value="`+addresses[i]['uaid']+`"></input>`;
                            }
                            else{
                                s+=`<input type="radio" class="mdl-radio__button" name="addr" value="`+addresses[i]['uaid']+`"></input>`;
                            }
                                    
                                s+= `<span class="mdl-radio__label">
                                        `+addresses[i]['addr1']+`, 
                                        `+addresses[i]['addr2']+`,
                                        `+addresses[i]['city']+`, 
                                        `+addresses[i]['zip']+`
                                </span>
                            </label></br>`;
                        }
                        s+= `</form>`;
                        $(".prod-desc").html(s);
                    }
                    else{

                    }
                }
                $("#customize").fadeIn();
                $(".mdl-layout__content").addClass("blur-filter");
            }
        }
    });
}

function applyCoupon(){
    var coupon = $("#couponCode").val().toUpperCase();
    if(coupon!=null && coupon!=undefined && coupon!=""){
        $.ajax({
            url: "./manageCart.php",
            data: { 
                action: "applyCoupon",
                coupon: coupon
            },
            success: function(data){
                loadCart(data);
                $("#msg").show();
            }
        });
    }
}

function removeCoupon(){
    $.ajax({
        url: "./manageCart.php",
        data: { 
            action: "removeCoupon"
        },
        success: function(data){
            loadCart(data);
        }
    });
}