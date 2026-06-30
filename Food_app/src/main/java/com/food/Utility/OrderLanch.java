package com.food.Utility;

import com.food.DAOimp.OrderDAOimp;
import com.food.Model.Order;

public class OrderLanch {

	public static void main(String[] args) {

		Order o = new Order(
		        1,                  // UserID
		        1,                  // RestaurantID
		        "2026-06-12 12:30:00",
		        599.00,
		        "Pending",
		        "UPI");

		OrderDAOimp dao = new OrderDAOimp();

		int result = dao.addOrder(o);

		if(result > 0) {
			System.out.println("Order Added Successfully");
		}
		else {
			System.out.println("Order Not Added");
		}
	}
}