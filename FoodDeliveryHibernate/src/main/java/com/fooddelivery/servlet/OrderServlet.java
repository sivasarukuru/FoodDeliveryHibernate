package com.fooddelivery.servlet;

import com.fooddelivery.entity.User;
import com.fooddelivery.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    private final OrderService service = new OrderService();

    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("loggedUser");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Map<Long, Integer> cart =
                (Map<Long, Integer>) request.getSession().getAttribute("cart");

        try {
            service.placeOrder(user.getId(), request.getParameter("address"), cart);
            request.getSession().removeAttribute("cart");
            response.sendRedirect("orders?success=1");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("loggedUser");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        request.setAttribute("orders", service.getOrders(user.getId()));
        request.getRequestDispatcher("orders.jsp").forward(request, response);
    }
}
