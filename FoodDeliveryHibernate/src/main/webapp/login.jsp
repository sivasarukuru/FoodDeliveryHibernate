<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Foodie</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="auth-card">
    <h1>Welcome Back</h1>
    <p>Login to continue.</p>
    <% if (request.getAttribute("error") != null) { %>
        <div class="error"><%= request.getAttribute("error") %></div>
    <% } %>
    <% if ("1".equals(request.getParameter("registered"))) { %>
        <div class="success">Registration successful. Please login.</div>
    <% } %>

    <form action="login" method="post">
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <button class="btn full" type="submit">Login</button>
    </form>
    <p>New user? <a href="register.jsp">Create account</a></p>
    <a href="index.jsp">← Home</a>
</div>
</body>
</html>
