<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
String customerName = (String)session.getAttribute("customerName");
String mobile = (String)session.getAttribute("mobile");
String address = (String)session.getAttribute("address");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Success</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Arial,sans-serif;
}

body{
background:#f5f5f5;
display:flex;
justify-content:center;
align-items:center;
height:100vh;
}

.container{
width:500px;
background:#fff;
padding:40px;
border-radius:15px;
box-shadow:0 5px 20px rgba(0,0,0,.15);
text-align:center;
}

.success-icon{
font-size:80px;
color:#27ae60;
}

h1{
margin-top:15px;
color:#27ae60;
}

.message{
margin-top:15px;
font-size:18px;
color:#555;
}

.details{
margin-top:30px;
text-align:left;
background:#fafafa;
padding:20px;
border-radius:10px;
}

.details p{
margin:12px 0;
font-size:16px;
}

.btn{
margin-top:30px;
display:inline-block;
padding:14px 30px;
background:#e23744;
color:white;
text-decoration:none;
border-radius:8px;
font-size:18px;
transition:.3s;
}

.btn:hover{
background:#c62839;
}

</style>

</head>

<body>

<div class="container">

<div class="success-icon">
✔
</div>

<h1>Order Placed Successfully!</h1>

<p class="message">
Thank you for ordering with FoodExpress.
Your delicious food is being prepared.
</p>

<div class="details">

<p>
<b>Customer :</b>
<%=customerName %>
</p>

<p>
<b>Mobile :</b>
<%=mobile %>
</p>

<p>
<b>Delivery Address :</b><br>
<%=address %>
</p>

<p>
<b>Status :</b>
Pending
</p>

<p>
<b>Estimated Delivery :</b>
30 - 40 Minutes
</p>

</div>

<a href="index.jsp" class="btn">
Continue Shopping
</a>

</div>

</body>
</html>