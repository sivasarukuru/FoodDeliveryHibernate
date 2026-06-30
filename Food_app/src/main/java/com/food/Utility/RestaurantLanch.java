package com.food.Utility;

import java.sql.SQLException;

import com.food.DAOimp.RestaurantDAOimp;
import com.food.Model.Restaurant;

public class RestaurantLanch {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

    	Restaurant r = new Restaurant(
    	        1,
    	        "Paradise",
    	        "Biryani",
    	        30,
    	        "Hyderabad",
    	        1,
    	        4.5f,
    	        true,
    	        "images/paradise.jpg"
    	);

        RestaurantDAOimp dao = new RestaurantDAOimp();

        int result = dao.addRestaurant(r);

        if(result > 0) {
            System.out.println("Restaurant Added Successfully");
        } else {
            System.out.println("Restaurant Not Added");
        }
    }
}