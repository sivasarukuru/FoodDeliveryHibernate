package com.food.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.food.DAOimp.RestaurantDAOimp;
import com.food.Model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/callRestaurantServlet")
public class RestaurantServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
System.out.println("RestaurantServlet Called");
		
		try {
	        RestaurantDAOimp restaurantDAOimp = new RestaurantDAOimp();

	        List<Restaurant> allRestaurants = restaurantDAOimp.getAllRestaurants();
	        for(Restaurant restaurant : allRestaurants) {
	           // System.out.println(restaurant.getName());
	        }
	        	
	        
	        req.setAttribute("allRestaurants",allRestaurants);
	        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
	        rd.forward(req, resp);
	        
	        
	        
	        
	        

	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}

		 
		 
			}
	

		 
		 
	

	
	
