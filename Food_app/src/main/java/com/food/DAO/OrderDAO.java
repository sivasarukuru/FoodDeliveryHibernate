package com.food.DAO;

import java.util.List;

import com.food.Model.Order;

public interface OrderDAO {

	int addOrder(Order order);

	Order getOrder(int orderID);

	List<Order> getAllOrders();

	int updateOrder(Order order);

	int deleteOrder(int orderID);
}