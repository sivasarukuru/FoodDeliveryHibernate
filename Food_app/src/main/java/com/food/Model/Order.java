package com.food.Model;

public class Order {

	private int orderID;
	private int userID;
	private int restaurantID;
	private String orderDate;
	private double totalAmount;
	private String status;
	private String paymentMethod;

	public Order() {
	}

	public Order( int userID, int restaurantID,
			String orderDate, double totalAmount,
			String status, String paymentMethod) {


		this.userID = userID;
		this.restaurantID = restaurantID;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMethod = paymentMethod;
	}

	public int getOrderID() {
		return orderID;
	}

	public int getUserID() {
		return userID;
	}

	public int getRestaurantID() {
		return restaurantID;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", userID=" + userID + ", restaurantID=" + restaurantID + ", orderDate="
				+ orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMethod=" + paymentMethod
				+ "]";
	}
	
}