<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.food.Model.Cart" %>
<%@ page import="com.food.Model.CartItem" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>My Cart</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, sans-serif;
}

body{
    background:#f4f4f4;
}

.navbar{
    background:#e23744;
    color:white;
    padding:15px 40px;
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.logo{
    font-size:28px;
    font-weight:bold;
}

.cart-container{
    width:90%;
    max-width:1000px;
    margin:30px auto;
}

.cart-box{
    background:white;
    border-radius:10px;
    overflow:hidden;
    box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

.cart-header,
.cart-item{
    display:grid;
    grid-template-columns:2fr 1fr 1fr 1.5fr 1fr;
    align-items:center;
    padding:15px;
}

.cart-header{
    background:#e23744;
    color:white;
    font-weight:bold;
}

.cart-item{
    border-bottom:1px solid #ddd;
}

.quantity-box{
    display:flex;
    align-items:center;
    gap:10px;
}

.quantity-box form{
    display:inline;
}

.qty-btn{
    width:30px;
    height:30px;
    border:none;
    background:#e23744;
    color:white;
    font-size:18px;
    border-radius:5px;
    cursor:pointer;
}

.quantity{
    font-weight:bold;
}

.remove-btn{
    background:red;
    color:white;
    border:none;
    padding:8px 12px;
    border-radius:5px;
    cursor:pointer;
}

.total{
    text-align:right;
    margin:20px;
    font-size:24px;
    font-weight:bold;
}

.checkout-btn{
    display:block;
    margin:20px auto;
    padding:12px 25px;
    background:green;
    color:white;
    border:none;
    border-radius:8px;
    cursor:pointer;
    font-size:18px;
}

.empty-cart{
    text-align:center;
    margin-top:100px;
    font-size:30px;
    color:gray;
}

</style>

</head>
<body>

<nav class="navbar">
    <div class="logo">FoodExpress</div>


<div>
    <a href="index.jsp"
       style="color:white;text-decoration:none;">
        Home
    </a>
</div>


</nav>

<div class="cart-container">

<h1>Your Cart</h1>
<p>Review your selected food items</p>

<%
Cart cart = (Cart)session.getAttribute("cart");
Integer restaurantID =
(Integer)session.getAttribute("RestaurantID");

if(cart != null && !cart.getItems().isEmpty()) {

double grandTotal = 0;
%>

<div class="cart-box">


<div class="cart-header">
    <div>Item</div>
    <div>Price</div>
    <div>Total</div>
    <div>Quantity</div>
    <div>Action</div>
</div>


<%
for(CartItem item : cart.getItems().values()) {

grandTotal += item.getTotalPrice();
%>


<div class="cart-item">

    <div>
        <%= item.getName() %>
    </div>

    <div>
        ₹ <%= item.getPrice() %>
    </div>

    <div>
        ₹ <%= item.getTotalPrice() %>
    </div>

    <div class="quantity-box">

        <!-- Minus Button -->
        <form action="CartServlet" method="post">

            <input type="hidden"
                   name="MenuId"
                   value="<%= item.getMenuId() %>">

            <input type="hidden"
                   name="RestaurantID"
                   value="<%= restaurantID %>">

            <input type="hidden"
                   name="action"
                   value="update">

            <input type="hidden"
                   name="quantity"
                   value="<%= item.getQuantity()-1 %>">

            <button type="submit" class="qty-btn">
                -
            </button>

        </form>

        <span class="quantity">
            <%= item.getQuantity() %>
        </span>

        <!-- Plus Button -->
        <form action="CartServlet" method="post">

            <input type="hidden"
                   name="MenuId"
                   value="<%= item.getMenuId() %>">

            <input type="hidden"
                   name="RestaurantID"
                   value="<%= restaurantID %>">

            <input type="hidden"
                   name="action"
                   value="update">

            <input type="hidden"
                   name="quantity"
                   value="<%= item.getQuantity()+1 %>">

            <button type="submit" class="qty-btn">
                +
            </button>

        </form>

    </div>

    <div>

        <form action="CartServlet" method="post">

            <input type="hidden"
                   name="MenuId"
                   value="<%= item.getMenuId() %>">

            <input type="hidden"
                   name="RestaurantID"
                   value="<%= item.getRestaurantID() %>">

            <input type="hidden"
                   name="action"
                   value="delete">

            <button type="submit"
                    class="remove-btn">
                Remove
            </button>

        </form>

    </div>

</div>


<%
}
%>

</div>

<div class="total">
    Grand Total : ₹ <%= grandTotal %>
</div>

<form action="checkout.jsp" method="get">

    <button type="submit" class="checkout-btn">
        Proceed To Checkout
    </button>

</form>

<%
}
else{
%>

<div class="empty-cart">
    Your Cart Is Empty
</div>

<%
}
%>

</div>

</body>
</html>
