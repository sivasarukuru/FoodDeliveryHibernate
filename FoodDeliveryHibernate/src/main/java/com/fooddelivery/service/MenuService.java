package com.fooddelivery.service;

import com.fooddelivery.dao.MenuDAO;
import com.fooddelivery.entity.MenuItem;
import java.util.List;

public class MenuService {
    private final MenuDAO dao = new MenuDAO();

    public List<MenuItem> getByRestaurant(Long restaurantId) {
        return dao.findByRestaurant(restaurantId);
    }

    public MenuItem getById(Long id) {
        return dao.findById(id);
    }
}
