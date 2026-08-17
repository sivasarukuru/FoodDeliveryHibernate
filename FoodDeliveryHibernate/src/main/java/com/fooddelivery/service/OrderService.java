package com.fooddelivery.service;

import com.fooddelivery.dao.MenuDAO;
import com.fooddelivery.dao.OrderDAO;
import com.fooddelivery.dao.UserDAO;
import com.fooddelivery.entity.*;
import com.fooddelivery.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class OrderService {
    private final OrderDAO orderDAO = new OrderDAO();
    private final MenuDAO menuDAO = new MenuDAO();
    private final UserDAO userDAO = new UserDAO();

    public void placeOrder(Long userId, String address, Map<Long, Integer> cart) {
        if (cart == null || cart.isEmpty()) {
            throw new IllegalArgumentException("Your cart is empty.");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Delivery address is required.");
        }

        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            User user = session.find(User.class, userId);
            if (user == null) throw new IllegalArgumentException("User not found.");

            FoodOrder order = new FoodOrder();
            order.setUser(user);
            order.setStatus("PLACED");
            order.setOrderDate(LocalDateTime.now());
            order.setDeliveryAddress(address);

            double total = 0;

            for (Map.Entry<Long, Integer> entry : cart.entrySet()) {
                MenuItem item = session.find(MenuItem.class, entry.getKey());
                int quantity = entry.getValue();

                if (item == null || quantity <= 0) continue;

                double lineTotal = item.getPrice() * quantity;
                total += lineTotal;

                OrderItem orderItem =
                        new OrderItem(quantity, item.getPrice(), order, item);

                order.getItems().add(orderItem);
            }

            if (order.getItems().isEmpty()) {
                throw new IllegalArgumentException("No valid cart items.");
            }

            order.setTotalAmount(total);
            session.persist(order);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<FoodOrder> getOrders(Long userId) {
        return orderDAO.findByUser(userId);
    }
}
