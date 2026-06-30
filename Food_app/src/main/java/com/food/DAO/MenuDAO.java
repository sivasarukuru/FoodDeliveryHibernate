package com.food.DAO;

import java.util.List;
import com.food.Model.Menu;

public interface MenuDAO {

    int addMenu(Menu menu);

    Menu getMenu(int menuID);

    List<Menu> getAllMenus();

    // Get all menu items belonging to a specific restaurant
    List<Menu> getAllMenusByRestaurant(int restaurantId);

    int updateMenu(Menu menu);

    int deleteMenu(int menuID);
}