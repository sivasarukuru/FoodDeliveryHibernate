package com.fooddelivery.servlet;

import com.fooddelivery.dao.MenuDAO;
import com.fooddelivery.entity.MenuItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private final MenuDAO menuDAO = new MenuDAO();

    @SuppressWarnings("unchecked")
    private Map<Long, Integer> getCart(HttpSession session) {
        Map<Long, Integer> cart = (Map<Long, Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new LinkedHashMap<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();
        Map<Long, Integer> cart = getCart(session);

        String action = request.getParameter("action");
        try {
            Long itemId = Long.valueOf(request.getParameter("itemId"));

            if ("add".equals(action)) {
                cart.put(itemId, cart.getOrDefault(itemId, 0) + 1);
            } else if ("remove".equals(action)) {
                cart.remove(itemId);
            } else if ("decrease".equals(action)) {
                int qty = cart.getOrDefault(itemId, 0);
                if (qty <= 1) cart.remove(itemId);
                else cart.put(itemId, qty - 1);
            }
        } catch (Exception ignored) {}

        response.sendRedirect("cart");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<Long, Integer> cart = getCart(request.getSession());
        List<CartLine> lines = new ArrayList<>();
        double total = 0;

        for (Map.Entry<Long, Integer> e : cart.entrySet()) {
            MenuItem item = menuDAO.findById(e.getKey());
            if (item != null) {
                lines.add(new CartLine(item, e.getValue()));
                total += item.getPrice() * e.getValue();
            }
        }

        request.setAttribute("lines", lines);
        request.setAttribute("total", total);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    public static class CartLine {
        private final MenuItem item;
        private final int quantity;

        public CartLine(MenuItem item, int quantity) {
            this.item = item;
            this.quantity = quantity;
        }
        public MenuItem getItem() { return item; }
        public int getQuantity() { return quantity; }
        public double getLineTotal() { return item.getPrice() * quantity; }
    }
}
