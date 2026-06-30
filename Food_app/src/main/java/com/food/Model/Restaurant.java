package com.food.Model;

public class Restaurant {

    private int restaurantID;
    private String restaurantName;
    private String cuisineType;
    private int deliveryTime;
    private String address;
    private int adminUserID;
    private float rating;
    private boolean isActive;
    private String imagePath;
   

    public Restaurant() {
    }

    public Restaurant(int restaurantID, String restaurantName, String cuisineType,
            int deliveryTime, String address,int adminUserID, float rating,
            boolean isActive,String imagePath ) {

        this.restaurantID = restaurantID;
        this.restaurantName = restaurantName;
        this.cuisineType = cuisineType;
        this.deliveryTime = deliveryTime;
        this.address = address;
        this.rating = rating;
        this.isActive = isActive;
        this.adminUserID = adminUserID;
        this.imagePath=imagePath;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String name) {
        this.restaurantName = name;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getAdminUserID() {
        return adminUserID;
    }
    public void setAdminUserID(int adminUserID) {
        this.adminUserID = adminUserID;
    }


    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

	@Override
	public String toString() {
		return "Restaurant [restaurantID=" + restaurantID + ", restaurantName=" + restaurantName + ", cuisineType=" + cuisineType
				+ ", deliveryTime=" + deliveryTime + ", address=" + address + ", adminUserID=" + adminUserID
				+ ", rating=" + rating + ", isActive=" + isActive + ", imagePath=" + imagePath + "]";
	}
    

   
   

    
    }
