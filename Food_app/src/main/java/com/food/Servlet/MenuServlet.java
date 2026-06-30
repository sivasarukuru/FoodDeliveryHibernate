package com.food.Servlet;

import java.io.IOException;
import java.util.List;

import com.food.DAOimp.MenuDAOimp;
import com.food.Model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/menu")

public class MenuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuDAOimp menuDAOimp=new MenuDAOimp();
		
		//for(Menu menu: allMenusByRestaurant) {
			int restauratID=Integer.parseInt(req.getParameter("RestaurantID"));
			List<Menu> allMenusByRestaurant=menuDAOimp.getAllMenusByRestaurant(restauratID);
			req.setAttribute("allMenusByRestaurant", allMenusByRestaurant);
			RequestDispatcher rd=req.getRequestDispatcher("menu.jsp");
			rd.forward(req, resp);
			
		}
	}
	


