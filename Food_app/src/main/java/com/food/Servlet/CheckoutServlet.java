package com.food.Servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.food.DAOimp.OrderDAOimp;
import com.food.Model.Cart;
import com.food.Model.CartItem;
import com.food.Model.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null || cart.getItems().isEmpty()) {
            resp.sendRedirect("Cart.jsp");
            return;
        }

        // Customer Details
        String customerName = req.getParameter("customerName");
        String mobile = req.getParameter("mobile");

        // Delivery Address
        String houseNo = req.getParameter("houseNo");
        String street = req.getParameter("street");
        String landmark = req.getParameter("landmark");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String pincode = req.getParameter("pincode");

        // Payment Method
        String paymentMethod = req.getParameter("paymentMode");
        System.out.println("Payment Method = " + paymentMethod);

        // Build Full Address
        String address = houseNo + ", "
                + street + ", "
                + landmark + ", "
                + city + ", "
                + state + " - "
                + pincode;

        // Calculate Grand Total
        double totalAmount = 0;

        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {

            CartItem item = entry.getValue();

            totalAmount += item.getTotalPrice();
        }

        // Restaurant ID
        int restaurantID = 0;

        for (CartItem item : cart.getItems().values()) {
            restaurantID = item.getRestaurantID();
            break;
        }

        /*
         * Replace this later with Logged-in User ID
         */
        int userID = 16;

        String status = "Pending";

        String orderDate = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Order order = new Order(
                userID,
                restaurantID,
                orderDate,
                totalAmount,
                status,
                paymentMethod
        );

        OrderDAOimp orderDAO = new OrderDAOimp();

        int orderID = orderDAO.addOrder(order);

        if (orderID > 0) {

            // Continue in Part 2B
        	
        
            // Save Order Items

            com.food.DAOimp.OrderItemDAOimp orderItemDAO =
                    new com.food.DAOimp.OrderItemDAOimp();

            for (CartItem item : cart.getItems().values()) {

                com.food.Model.OrderItem orderItem =
                        new com.food.Model.OrderItem(
                                orderID,
                                item.getMenuId(),
                                item.getQuantity(),
                                item.getTotalPrice());

                orderItemDAO.addOrderItem(orderItem);
            }

            // Clear Cart

            session.removeAttribute("cart");
            session.removeAttribute("RestaurantID");

            // You can save customer details in session if required

            session.setAttribute("customerName", customerName);
            session.setAttribute("mobile", mobile);
            session.setAttribute("address", address);

            // Redirect to Success Page

            resp.sendRedirect("OrderSuccess.jsp");

        }
        else {

            req.setAttribute("error",
                    "Unable to Place Order!");

            req.getRequestDispatcher("checkout.jsp")
               .forward(req, resp);
        }
     
   

}
}




