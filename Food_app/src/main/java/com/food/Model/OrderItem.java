package com.food.Model;

public class OrderItem {

	private int orderItemID;
	private int orderID;
	private int menuID;
	private int quantity;
	private double itemTotal;

	public OrderItem() {
	}

	public OrderItem( int orderID,
			int menuID, int quantity,
			double itemTotal) {

		this.orderID = orderID;
		this.menuID = menuID;
		this.quantity = quantity;
		this.itemTotal = itemTotal;
	}

	public int getOrderItemID() {
		return orderItemID;
	}

	public int getOrderID() {
		return orderID;
	}

	public int getMenuID() {
		return menuID;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getItemTotal() {
		return itemTotal;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemID=" + orderItemID + ", orderID=" + orderID + ", menuID=" + menuID + ", quantity="
				+ quantity + ", itemTotal=" + itemTotal + "]";
	}
	
}