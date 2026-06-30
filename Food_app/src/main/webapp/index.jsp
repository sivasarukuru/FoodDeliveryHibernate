<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List, com.food.Model.Restaurant" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Food Delivery App</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, Helvetica, sans-serif;
}

body{
    background:#f8f8f8;
}

/* NAVBAR */

.navbar{
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:15px 50px;
    background:#e23744;
    color:white;
    position:sticky;
    top:0;
    z-index:1000;
}

.logo{
    font-size:28px;
    font-weight:bold;
}

.nav-links{
    display:flex;
    gap:25px;
}

.nav-links a{
    text-decoration:none;
    color:white;
    font-size:17px;
    font-weight:bold;
    transition:.3s;
}

.nav-links a:hover{
    color:#ffd700;
}

/* HERO SECTION */

.hero{
    height:300px;
    background:linear-gradient(rgba(0,0,0,.5),
    rgba(0,0,0,.5)),
    url('https://images.unsplash.com/photo-1504674900247-0877df9cc836');
    background-size:cover;
    background-position:center;
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    color:white;
    text-align:center;
}

.hero h1{
    font-size:45px;
    margin-bottom:20px;
}

.search-box{
    width:60%;
    max-width:600px;
}

.search-box input{
    width:100%;
    padding:15px;
    border:none;
    border-radius:10px;
    font-size:16px;
}

/* RESTAURANTS */

.container{
    padding:40px;
}

.section-title{
    margin-bottom:25px;
    font-size:30px;
}

.restaurant-grid{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(280px,1fr));
    gap:25px;
}

.card{
    background:white;
    border-radius:15px;
    overflow:hidden;
    box-shadow:0 5px 15px rgba(0,0,0,.1);
    transition:.3s;
}

.card:hover{
    transform:translateY(-8px);
}

.card img{
    width:100%;
    height:200px;
    object-fit:cover;
}

.card-content{
    padding:15px;
}

.card-header{
    display:flex;
    justify-content:space-between;
    margin-bottom:10px;
}

.rating{
    background:green;
    color:white;
    padding:5px 10px;
    border-radius:6px;
    font-size:14px;
}

.location,
.time,
.cuisine{
    color:gray;
    margin-top:6px;
}

.offer{
    background:#ffe8e8;
    color:#e23744;
    padding:8px;
    margin-top:12px;
    border-radius:8px;
    font-weight:bold;
}

.btn{
    width:100%;
    margin-top:15px;
    padding:12px;
    border:none;
    background:#e23744;
    color:white;
    border-radius:8px;
    cursor:pointer;
    font-size:16px;
}

.btn:hover{
    background:#c91d2c;
}

/* FOOTER */

footer{
    text-align:center;
    padding:20px;
    background:#222;
    color:white;
    margin-top:40px;
}

/* MOBILE */

@media(max-width:768px){

.navbar{
    flex-direction:column;
    gap:10px;
}

.hero h1{
    font-size:28px;
}

.search-box{
    width:90%;
}

.container{
    padding:20px;
}

}

</style>
</head>
<body>

<!-- NAVBAR -->

<nav class="navbar">

<div class="logo">FoodExpress</div>

<div class="nav-links">
<a href="#">Home</a>
<a href="#">Restaurants</a>
<a href="login.html">Login</a>
<a href="Register.html">Sign Up</a>
<a href="#">Profile</a>
</div>

</nav>

<!-- HERO -->

<section class="hero">
<h1>Discover the Best Food Near You</h1>

<div class="search-box">
<input type="text" placeholder="Search for restaurants, cuisines...">
</div>

</section>

<!-- RESTAURANTS -->

<div class="container">

<h2 class="section-title">Popular Restaurants</h2>

<%
List<Restaurant> restaurantList =
(List<Restaurant>)request.getAttribute("allRestaurants");
%>


<div class="restaurant-grid">

<%
if(restaurantList != null && !restaurantList.isEmpty()){

    for(Restaurant restaurant : restaurantList){
%>

<a href="menu?RestaurantID=<%= restaurant.getRestaurantID() %>&RestaurantName=<%=restaurant.getRestaurantName()%>">
   <div class="restaurant-card">

        <img src="<%= restaurant.getImagePath() %>"
             alt="<%= restaurant.getRestaurantName() %>"
             width="250">

        <h3><%= restaurant.getRestaurantName() %></h3>

        <p>
            <strong>Cuisine:</strong>
            <%= restaurant.getCuisineType() %>
        </p>

        <p>
            <strong>Delivery Time:</strong>
            <%= restaurant.getDeliveryTime() %> mins
        </p>

        <p>
            <strong>Address:</strong>
            <%= restaurant.getAddress() %>
        </p>

        <p>
            <strong>Rating:</strong>
            ⭐ <%= restaurant.getRating() %>
        </p>

        <p>
            <strong>Status:</strong>
            <%= restaurant.isActive() ? "Open" : "Closed" %>
        </p>

    </div>
 
 
 </a>

<%
    }
}
else{
%>

    <h3>No Restaurants Available</h3>

<%
}
%>

</body>
</html>