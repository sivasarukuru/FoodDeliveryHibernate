package com.fooddelivery.servlet;

import com.fooddelivery.service.RestaurantService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/restaurants")
public class RestaurantServlet extends HttpServlet {
    private final RestaurantService service = new RestaurantService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("restaurants", service.getAll());
        request.getRequestDispatcher("restaurants.jsp").forward(request, response);
    }
}
