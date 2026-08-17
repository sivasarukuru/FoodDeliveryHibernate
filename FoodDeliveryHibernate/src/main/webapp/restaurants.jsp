<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Restaurants - Foodie</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<nav class="nav">
    <a class="brand" href="index.jsp">Foodie</a>
    <div>
        <a href="restaurants">Restaurants</a>
        <a href="cart">Cart</a>
        <c:choose>
            <c:when test="${not empty sessionScope.loggedUser}">
                <a href="orders">My Orders</a>
                <a href="logout">Logout</a>
            </c:when>
            <c:otherwise><a href="login.jsp">Login</a></c:otherwise>
        </c:choose>
    </div>
</nav>

<div class="container">
    <div class="page-title">
        <div>
            <p class="eyebrow">EXPLORE</p>
            <h1>Popular Restaurants</h1>
        </div>
    </div>

    <div class="grid">
        <c:forEach var="r" items="${restaurants}">
            <div class="card">
                <img src="${r.imageUrl}" alt="${r.name}">
                <div class="card-body">
                    <div class="row"><h2>${r.name}</h2><span class="rating">★ ${r.rating}</span></div>
                    <p>${r.location}</p>
                    <p>${r.deliveryTime} min delivery</p>
                    <a class="btn full" href="menu?restaurantId=${r.id}">View Menu</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
