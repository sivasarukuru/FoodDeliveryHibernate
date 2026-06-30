package com.food.DAO;

import java.util.List;

import com.food.Model.OrderItem;

public interface OrderItemDAO {

	int addOrderItem(OrderItem orderItem);

	OrderItem getOrderItem(int orderItemID);

	List<OrderItem> getAllOrderItems();

	int updateOrderItem(OrderItem orderItem);

	int deleteOrderItem(int orderItemID);
}