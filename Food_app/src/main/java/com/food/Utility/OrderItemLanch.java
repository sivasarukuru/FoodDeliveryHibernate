package com.food.Utility;

import com.food.DAOimp.OrderItemDAOimp;
import com.food.Model.OrderItem;

public class OrderItemLanch {

	public static void main(String[] args) {

		OrderItem item = new OrderItem(
		        1,      // OrderID
		        1,      // MenuID
		        2,      // Quantity
		        598.00  // ItemTotal
		);

		OrderItemDAOimp dao = new OrderItemDAOimp();

		int result = dao.addOrderItem(item);

		if(result > 0) {
			System.out.println("Order Item Added Successfully");
		}
		else {
			System.out.println("Order Item Not Added");
		}
	}
}