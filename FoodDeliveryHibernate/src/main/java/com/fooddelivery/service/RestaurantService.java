package com.fooddelivery.service;

import com.fooddelivery.dao.RestaurantDAO;
import com.fooddelivery.entity.Restaurant;
import java.util.List;

public class RestaurantService {
    private final RestaurantDAO dao = new RestaurantDAO();

    public List<Restaurant> getAll() { return dao.findAll(); }
    public Restaurant getById(Long id) { return dao.findById(id); }
}
