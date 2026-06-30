package com.food.DAOimp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.RestaurantDAO;
import com.food.Model.Restaurant;
import com.food.Utility.DBconnection;

public class RestaurantDAOimp implements RestaurantDAO {
	private Connection connection;
	public RestaurantDAOimp()throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/food_delivery_application","root","Siva@2004");
	}

    private static final String INSERT =
            "INSERT INTO restaurant_table (RestaurantID,RestaurantName,CuisineType,DeliveryTime,Address,Rating,IsActive,AdminUserID,ImagePath) VALUES(?,?,?,?,?,?,?,?,?)";

    private static final String GET_ONE =
            "SELECT * FROM restaurant_table WHERE RestaurantID=?";

    private static final String GET_ALL =
            "SELECT * FROM restaurant_table";

    @Override
    public int addRestaurant(Restaurant r) {

        try(Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {

            ps.setInt(1, r.getRestaurantID());
            ps.setString(2, r.getRestaurantName());
            ps.setString(3, r.getCuisineType());
            ps.setInt(4, r.getDeliveryTime());
            ps.setString(5, r.getAddress());
            ps.setInt(8, r.getAdminUserID());
            ps.setFloat(6, r.getRating());
            ps.setBoolean(7, r.isActive());
            ps.setString(8, r.getImagePath());
          

            return ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Restaurant getRestaurant(int restaurantId) {
        return null;
    }

//    @Override
//    public List<Restaurant> getAllRestaurants() {
//        return new ArrayList<>();
//    }
    
    @Override
    public List<Restaurant> getAllRestaurants() {

        List<Restaurant> restaurants = new ArrayList<>();

        try(Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery()) {

            System.out.println("Database Connected Successfully");

            while(rs.next()) {

                System.out.println("Restaurant Name = " + rs.getString("RestaurantName"));

                Restaurant restaurant = new Restaurant();

                restaurant.setRestaurantID(rs.getInt("RestaurantID"));
                restaurant.setRestaurantName(rs.getString("RestaurantName"));
                restaurant.setCuisineType(rs.getString("CuisineType"));
                restaurant.setDeliveryTime(rs.getInt("DeliveryTime"));
                restaurant.setAddress(rs.getString("Address"));
                restaurant.setAdminUserID(rs.getInt("AdminUserID"));
                restaurant.setRating(rs.getFloat("Rating"));
                restaurant.setActive(rs.getBoolean("IsActive"));
                restaurant.setImagePath(rs.getString("ImagePath"));
                        
                
                restaurants.add(restaurant);
            }

            System.out.println("Total Records = " + restaurants.size());

        } catch(Exception e) {
            e.printStackTrace();
        }

        return restaurants;
    }
    
        
    
    
    

    @Override
    public int updateRestaurant(Restaurant restaurant) {
        return 0;
    }

    @Override
    public int deleteRestaurant(int restaurantId) {
        return 0;
    }
}