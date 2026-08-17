<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cart - Foodie</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<nav class="nav">
    <a class="brand" href="index.jsp">Foodie</a>
    <div><a href="restaurants">Restaurants</a><a href="orders">My Orders</a></div>
</nav>

<div class="container narrow">
    <h1>Your Cart</h1>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>

    <c:choose>
        <c:when test="${empty lines}">
            <div class="empty"><h2>Your cart is empty.</h2><a class="btn" href="restaurants">Browse Restaurants</a></div>
        </c:when>
        <c:otherwise>
            <c:forEach var="line" items="${lines}">
                <div class="cart-row">
                    <img src="${line.item.imageUrl}" alt="${line.item.name}">
                    <div class="grow">
                        <h3>${line.item.name}</h3>
                        <p>₹${line.item.price} × ${line.quantity}</p>
                    </div>
                    <strong>₹${line.lineTotal}</strong>
                    <form action="cart" method="post">
                        <input type="hidden" name="itemId" value="${line.item.id}">
                        <input type="hidden" name="action" value="decrease">
                        <button class="small" type="submit">−</button>
                    </form>
                    <form action="cart" method="post">
                        <input type="hidden" name="itemId" value="${line.item.id}">
                        <input type="hidden" name="action" value="add">
                        <button class="small" type="submit">+</button>
                    </form>
                    <form action="cart" method="post">
                        <input type="hidden" name="itemId" value="${line.item.id}">
                        <input type="hidden" name="action" value="remove">
                        <button class="small danger" type="submit">Remove</button>
                    </form>
                </div>
            </c:forEach>

            <div class="checkout">
                <h2>Total: ₹${total}</h2>
                <c:choose>
                    <c:when test="${not empty sessionScope.loggedUser}">
                        <form action="orders" method="post">
                            <textarea name="address" placeholder="Delivery address" required></textarea>
                            <button class="btn full" type="submit">Place Order</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <p>Please <a href="login.jsp">login</a> to place your order.</p>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
