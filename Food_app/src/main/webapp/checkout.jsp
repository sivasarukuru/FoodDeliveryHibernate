
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.food.Model.Cart"%>
<%@ page import="com.food.Model.CartItem"%>
<%@ page import="java.util.Map"%>

<%
Cart cart = (Cart)session.getAttribute("cart");

if(cart == null || cart.getItems().isEmpty()){
    response.sendRedirect("Cart.jsp");
    return;
}

double grandTotal = 0;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial,Helvetica,sans-serif;
}

body{
    background:#f8f8f8;
}

.navbar{
    background:#e23744;
    color:#fff;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:18px 60px;
}

.logo{
    font-size:30px;
    font-weight:bold;
}

.navbar a{
    color:white;
    text-decoration:none;
    font-size:18px;
}

.checkout-container{
    width:95%;
    max-width:1400px;
    margin:30px auto;
}

.checkout-title{
    font-size:32px;
    color:#333;
    margin-bottom:8px;
}

.checkout-subtitle{
    color:gray;
    margin-bottom:30px;
}

.checkout-wrapper{
    display:grid;
    grid-template-columns:2fr 1fr;
    gap:30px;
}

.left-panel{

}

.right-panel{

}

.card{
    background:white;
    border-radius:12px;
    padding:25px;
    margin-bottom:25px;
    box-shadow:0 2px 10px rgba(0,0,0,.12);
}

.card h2{
    margin-bottom:20px;
    color:#333;
}

.input-group{
    display:flex;
    flex-direction:column;
    margin-bottom:18px;
}

.input-group label{
    margin-bottom:6px;
    font-weight:bold;
    color:#444;
}

.input-group input,
.input-group textarea,
.input-group select{

    padding:12px;
    border:1px solid #ccc;
    border-radius:8px;
    outline:none;
    font-size:16px;
}

.input-group textarea{
    resize:none;
}

.row{
    display:grid;
    grid-template-columns:1fr 1fr;
    gap:20px;
}

.order-item{

    display:flex;
    justify-content:space-between;
    align-items:center;

    padding:15px 0;

    border-bottom:1px solid #eee;
}

.item-name{

    font-weight:bold;
    color:#333;
}

.item-details{

    color:gray;
    margin-top:5px;
}

.item-price{

    font-size:18px;
    font-weight:bold;
    color:#e23744;
}

.total-section{

    margin-top:20px;
}

.total-row{

    display:flex;
    justify-content:space-between;
    margin-bottom:12px;
}

.grand-total{

    border-top:2px solid #ddd;
    padding-top:15px;

    font-size:22px;
    font-weight:bold;
}

.payment-option{

    display:flex;
    align-items:center;

    gap:12px;

    padding:12px;

    border:1px solid #ddd;

    border-radius:8px;

    margin-bottom:15px;

    cursor:pointer;
}

.payment-option:hover{

    background:#fff3f3;
}

.payment-option input{

    transform:scale(1.2);
}

.place-order-btn{

    width:100%;

    padding:16px;

    background:#e23744;

    color:white;

    border:none;

    border-radius:10px;

    font-size:20px;

    font-weight:bold;

    cursor:pointer;

    transition:.3s;
}

.place-order-btn:hover{

    background:#c91e30;
}

.summary-title{

    margin-bottom:20px;
}

@media(max-width:992px){

.checkout-wrapper{

grid-template-columns:1fr;

}

.row{

grid-template-columns:1fr;

}

.navbar{

padding:20px;

}

}

</style>

</head>

<body>

<nav class="navbar">

<div class="logo">

FoodExpress

</div>

<div>

<a href="Cart.jsp">

← Back To Cart

</a>

</div>

</nav>

<div class="checkout-container">

<h1 class="checkout-title">

Checkout

</h1>

<p class="checkout-subtitle">

Complete your delivery details and place your order.

</p>

<form action="CheckoutServlet" method="post">

<div class="checkout-wrapper">

<div class="left-panel">


<!-- ========================= -->
<!-- LEFT PANEL -->
<!-- ========================= -->

<div class="card">

    <h2>Customer Details</h2>

    <div class="row">

        <div class="input-group">
            <label>Full Name</label>
            <input type="text"
                   name="customerName"
                   id="customerName"
                   placeholder="Enter Full Name"
                   required>
        </div>

        <div class="input-group">
            <label>Mobile Number</label>
            <input type="text"
                   name="mobile"
                   id="mobile"
                   maxlength="10"
                   placeholder="Enter Mobile Number"
                   required>
        </div>

    </div>

</div>

<!-- ========================= -->
<!-- DELIVERY ADDRESS -->
<!-- ========================= -->

<div class="card">

<h2>Delivery Address</h2>

<div class="input-group">

<label>House / Flat No</label>

<input type="text"
       name="houseNo"
       id="houseNo"
       placeholder="Flat No / House No"
       required>

</div>

<div class="input-group">

<label>Street / Area</label>

<input type="text"
       name="street"
       id="street"
       placeholder="Street / Area"
       required>

</div>

<div class="input-group">

<label>Landmark</label>

<input type="text"
       name="landmark"
       id="landmark"
       placeholder="Nearby Landmark">

</div>

<div class="row">

<div class="input-group">

<label>City</label>

<input type="text"
       name="city"
       id="city"
       placeholder="City"
       required>

</div>

<div class="input-group">

<label>State</label>

<input type="text"
       name="state"
       id="state"
       placeholder="State"
       required>

</div>

</div>

<div class="row">

<div class="input-group">

<label>Pincode</label>

<input type="text"
       name="pincode"
       id="pincode"
       maxlength="6"
       placeholder="Pincode"
       required>

</div>

<div class="input-group">

<label>Delivery Instructions</label>

<select name="instruction">

<option value="">Select</option>

<option>Leave at Door</option>

<option>Hand it to Me</option>

<option>Call on Arrival</option>

</select>

</div>

</div>

</div>

</div>

<!-- ========================= -->
<!-- RIGHT PANEL -->
<!-- ========================= -->

<div class="right-panel">

<div class="card">

<h2 class="summary-title">

Order Summary

</h2>

<%

for(CartItem item : cart.getItems().values()){

double total=item.getPrice()*item.getQuantity();

grandTotal+=total;

%>

<div class="order-item">

<div>

<div class="item-name">

<%= item.getName() %>

</div>

<div class="item-details">

Qty :
<%= item.getQuantity() %>

× ₹
<%= item.getPrice() %>

</div>

</div>

<div class="item-price">

₹ <%= total %>

</div>

</div>

<%
}
%>

<div class="total-section">

<div class="total-row">

<span>Item Total</span>

<span>

₹ <%= grandTotal %>

</span>

</div>

<div class="total-row">

<span>Delivery Fee</span>

<span>

₹ 40

</span>

</div>

<div class="total-row">

<span>GST (5%)</span>

<span>

₹ <%= String.format("%.2f",(grandTotal*0.05)) %>

</span>

</div>

<%

double finalAmount=grandTotal+40+(grandTotal*0.05);

%>

<div class="total-row grand-total">

<span>

Grand Total

</span>

<span>

₹ <%= String.format("%.2f",finalAmount) %>

</span>

</div>

<input type="hidden"
       name="totalAmount"
       value="<%= finalAmount %>">

</div>

</div>

<!-- ========================= -->
<!-- PAYMENT SECTION -->
<!-- ========================= -->

<div class="card">

<h2>

Payment Method

</h2>

<label class="payment-option">

<input type="radio"
       name="paymentMode"
       value="Cash"
       checked>

Cash On Delivery

</label>

<label class="payment-option">

<input type="radio"
       name="paymentMode"
       value="UPI">

UPI Payment

</label>

<label class="payment-option">

<input type="radio"
       name="paymentMode"
       value="Card">

Credit / Debit Card

</label>

<button
type="submit"
class="place-order-btn">

Place Order

</button>

</div>

</div>

</div>

</form>

</div>

<script>

document.querySelector("form").addEventListener("submit",function(e){

let customerName=document.getElementById("customerName").value.trim();

let mobile=document.getElementById("mobile").value.trim();

let houseNo=document.getElementById("houseNo").value.trim();

let street=document.getElementById("street").value.trim();

let city=document.getElementById("city").value.trim();

let state=document.getElementById("state").value.trim();

let pincode=document.getElementById("pincode").value.trim();

if(customerName==""){

alert("Please Enter Customer Name");

e.preventDefault();

return;

}

if(!/^[A-Za-z ]+$/.test(customerName)){

alert("Customer Name Should Contain Only Letters");

e.preventDefault();

return;

}

if(!/^[6-9][0-9]{9}$/.test(mobile)){

alert("Enter Valid Mobile Number");

e.preventDefault();

return;

}

if(houseNo==""){

alert("Enter House Number");

e.preventDefault();

return;

}

if(street==""){

alert("Enter Street");

e.preventDefault();

return;

}

if(city==""){

alert("Enter City");

e.preventDefault();

return;

}

if(state==""){

alert("Enter State");

e.preventDefault();

return;

}

if(!/^[0-9]{6}$/.test(pincode)){

alert("Enter Valid Pincode");

e.preventDefault();

return;

}

});

</script>

</body>

</html>


