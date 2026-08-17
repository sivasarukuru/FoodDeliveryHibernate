package com.fooddelivery.servlet;

import com.fooddelivery.service.MenuService;
import com.fooddelivery.service.RestaurantService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    private final MenuService menuService = new MenuService();
    private final RestaurantService restaurantService = new RestaurantService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Long restaurantId = Long.valueOf(request.getParameter("restaurantId"));
            request.setAttribute("restaurant", restaurantService.getById(restaurantId));
            request.setAttribute("menuItems", menuService.getByRestaurant(restaurantId));
            request.getRequestDispatcher("menu.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("restaurants");
        }
    }
}
