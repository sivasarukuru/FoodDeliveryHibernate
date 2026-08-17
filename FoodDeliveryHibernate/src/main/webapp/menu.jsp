<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${restaurant.name} - Menu</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<nav class="nav">
    <a class="brand" href="index.jsp">Foodie</a>
    <div><a href="restaurants">Restaurants</a><a href="cart">Cart</a><a href="orders">My Orders</a></div>
</nav>

<div class="container">
    <div class="restaurant-header">
        <div>
            <p class="eyebrow">MENU</p>
            <h1>${restaurant.name}</h1>
            <p>${restaurant.location} · ★ ${restaurant.rating} · ${restaurant.deliveryTime} min</p>
        </div>
    </div>

    <div class="menu-list">
        <c:forEach var="item" items="${menuItems}">
            <div class="menu-item">
                <img src="${item.imageUrl}" alt="${item.name}">
                <div class="menu-info">
                    <h2>${item.name}</h2>
                    <p>${item.description}</p>
                    <strong>₹${item.price}</strong>
                </div>
                <form action="cart" method="post">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="itemId" value="${item.id}">
                    <button class="btn" type="submit">Add</button>
                </form>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
