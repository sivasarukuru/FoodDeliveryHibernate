package com.food.DAO;

import java.util.List;

import com.food.Model.Restaurant;

public interface RestaurantDAO {

    int addRestaurant(Restaurant restaurant);

    Restaurant getRestaurant(int restaurantId);

    List<Restaurant> getAllRestaurants();

    int updateRestaurant(Restaurant restaurant);

    int deleteRestaurant(int restaurantId);
}