<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register - Foodie</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="auth-card">
    <h1>Create Account</h1>
    <p>Join Foodie today.</p>
    <% if (request.getAttribute("error") != null) { %>
        <div class="error"><%= request.getAttribute("error") %></div>
    <% } %>
    <form action="register" method="post">
        <input type="text" name="name" placeholder="Full name" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" minlength="6" required>
        <button class="btn full" type="submit">Register</button>
    </form>
    <p>Already registered? <a href="login.jsp">Login</a></p>
</div>
</body>
</html>
