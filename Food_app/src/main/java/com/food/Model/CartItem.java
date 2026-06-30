package com.food.Model;

public class CartItem {

    private int MenuID;
    private String name;
    private double price;
    private int quantity;
    private int RestaurantID;

    public CartItem() {

    }

    public CartItem(int menuId,
                    String name,
                    double price,
                    int quantity,
                    int restaurantID) {

        this.MenuID = menuId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.RestaurantID = restaurantID;
    }

    public int getMenuId() {
        return MenuID;
    }

    public void setMenuId(int menuId) {
        MenuID = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRestaurantID() {
        return RestaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        RestaurantID = restaurantID;
    }

    public double getTotalPrice() {
        return quantity * price;
    }
}