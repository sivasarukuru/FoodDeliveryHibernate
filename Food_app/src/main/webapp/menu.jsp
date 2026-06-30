	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List,com.food.Model.Menu" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Menu</title>

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

.navbar{
    background:#e23744;
    color:white;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:15px 40px;
}

.logo{
    font-size:28px;
    font-weight:bold;
}

.nav-links a{
    text-decoration:none;
    color:white;
    margin-left:20px;
    font-weight:bold;
}

.restaurant-banner{
    background:linear-gradient(
    rgba(0,0,0,.5),
    rgba(0,0,0,.5)),
    url('https://images.unsplash.com/photo-1517248135467-4c7edcad34c4');
    background-size:cover;
    background-position:center;
    height:250px;

    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;

    color:white;
    text-align:center;
}

.restaurant-banner h1{
    font-size:45px;
    margin-bottom:10px;
}

.container{
    width:90%;
    max-width:1200px;
    margin:30px auto;
}

.menu-title{
    margin-bottom:25px;
    color:#333;
    font-size:32px;
}

.menu-grid{
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(350px,1fr));
    gap:20px;
}

.menu-card{
    background:white;
    border-radius:15px;
    padding:20px;
    box-shadow:0 5px 15px rgba(0,0,0,.1);
}

.category{
    display:inline-block;
    background:#ffe8e8;
    color:#e23744;
    padding:6px 12px;
    border-radius:20px;
    margin-bottom:10px;
}

.menu-name{
    font-size:22px;
    font-weight:bold;
    margin-bottom:10px;
}

.menu-description{
    color:gray;
    margin-bottom:10px;
}

.price{
    font-size:20px;
    font-weight:bold;
}

.available{
    color:green;
    font-weight:bold;
}

.unavailable{
    color:red;
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
}

.disabled{
    background:gray;
    cursor:not-allowed;
}

footer{
    background:#222;
    color:white;
    text-align:center;
    padding:20px;
    margin-top:40px;
}

</style>
</head>

<body>

<nav class="navbar">
    <div class="logo">FoodExpress</div>

    <div class="nav-links">
        <a href="home.jsp">Home</a>
        <a href="#">Cart</a>
        <a href="#">Orders</a>
        <a href="#">Profile</a>
    </div>
</nav>

<section class="restaurant-banner">
    <h1>Restaurant Menu</h1>
    <p>Delicious Food Delivered Fast</p>
</section>

<div class="container">

    <h2 class="menu-title">Available Dishes</h2>

    <div class="menu-grid">

    <%
    List<Menu> allMenusByRestaurant =
        (List<Menu>)request.getAttribute("allMenusByRestaurant");

    if(allMenusByRestaurant != null &&
       !allMenusByRestaurant.isEmpty()){

        for(Menu menu : allMenusByRestaurant){
    %>

        <div class="menu-card">

            <div class="category">
                <%= menu.getCategory() %>
            </div>

            <div class="menu-name">
                <%= menu.getItemName() %>
            </div>

            <div class="menu-description">
                <%= menu.getDescription() %>
            </div>

            <div class="price">
                ₹ <%= menu.getPrice() %>
            </div>

            <br>

            <%
            if(menu.isAvailable()){
            %>

                <span class="available">
                    Available
                </span>
                
                   <form action="CartServlet">
                   <input type="hidden" name="MenuId" value="<%=menu.getMenuID() %>">
                    <input type="hidden" name="RestaurantId" value="<%=menu.getRestaurantID() %>">
                     <input type="hidden" name="quantity" value="1">
                      <input type="hidden" name="action" value="add">
                    <button class="btn"> Add To Cart </button>               
                   </form>

            <%
            }else{
            %>

                <span class="unavailable">
                    Out Of Stock
                </span>

                <button class="btn disabled" disabled>
                    Not Available
                </button>

            <%
            }
            %>

        </div>

    <%
        }
    }else{
    %>

        <h2>No Menu Items Available</h2>

    <%
    }
    %>

    </div>

</div>

<footer>
    © 2026 FoodExpress | Fresh Food Delivered
</footer>

</body>
</html>