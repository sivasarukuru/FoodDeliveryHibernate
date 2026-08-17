<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Orders - Foodie</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<nav class="nav">
    <a class="brand" href="index.jsp">Foodie</a>
    <div><a href="restaurants">Restaurants</a><a href="cart">Cart</a><a href="logout">Logout</a></div>
</nav>

<div class="container narrow">
    <h1>My Orders</h1>
    <c:if test="${param.success == '1'}">
        <div class="success">Order placed successfully!</div>
    </c:if>

    <c:choose>
        <c:when test="${empty orders}">
            <div class="empty"><h2>No orders yet.</h2><a class="btn" href="restaurants">Order Food</a></div>
        </c:when>
        <c:otherwise>
            <c:forEach var="order" items="${orders}">
                <div class="order-card">
                    <div class="row">
                        <h2>Order #${order.id}</h2>
                        <span class="status">${order.status}</span>
                    </div>
                    <p>${order.orderDate}</p>
                    <p>${order.deliveryAddress}</p>
                    <hr>
                    <c:forEach var="item" items="${order.items}">
                        <div class="row">
                            <span>${item.menuItem.name} × ${item.quantity}</span>
                            <span>₹${item.price * item.quantity}</span>
                        </div>
                    </c:forEach>
                    <h3 class="total">Total: ₹${order.totalAmount}</h3>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
