package com.food.Servlet;

import java.io.IOException;

import com.food.DAOimp.MenuDAOimp;
import com.food.Model.Cart;
import com.food.Model.CartItem;
import com.food.Model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    HttpSession session = req.getSession();

	    Cart cart = (Cart) session.getAttribute("cart");
	    Integer restaurantID =
	            (Integer) session.getAttribute("RestaurantID");

	    String restaurantParam =
	            req.getParameter("RestaurantID");

	    Integer newRestaurantID = null;

	    if (restaurantParam != null &&
	        !restaurantParam.trim().isEmpty() && !"null".equalsIgnoreCase(restaurantParam)) {

	        newRestaurantID =
	                Integer.parseInt(restaurantParam);
	    }

//	    if (cart == null ||
//	        restaurantID == null ||
//	        (newRestaurantID != null &&
//	        !restaurantID.equals(newRestaurantID))) {
//
//	        cart = new Cart();
//
//	        session.setAttribute("cart", cart);
//
//	        if(newRestaurantID != null) {
//	            session.setAttribute(
//	                    "RestaurantID",
//	                    newRestaurantID);
//	        }
//	    }

	    String action = req.getParameter("action");
	    
	    if ("add".equals(action)) {

	        if (cart == null) {
	            cart = new Cart();
	            session.setAttribute("cart", cart);
	        }

	        if (restaurantID == null) {
	            session.setAttribute("RestaurantID", newRestaurantID);
	        } else if (newRestaurantID != null && !restaurantID.equals(newRestaurantID)) {
	            cart = new Cart();
	            session.setAttribute("cart", cart);
	            session.setAttribute("RestaurantID", newRestaurantID);
	        }

	    } else {

	        // For update/delete, use the existing cart only.
	        if (cart == null) {
	            resp.sendRedirect("Cart.jsp");
	            return;
	        }
	    }
	    
	    
	    

	    if ("add".equals(action)) {

	        addItemToCart(req, cart);

	    }
	    else if ("update".equals(action)) {

	        updateItemToCart(req, cart);

	    }
	    else if ("delete".equals(action)) {

	        deleteItemFromCart(req, cart);
	    }

	    resp.sendRedirect("Cart.jsp");
	}
	
	private void deleteItemFromCart(HttpServletRequest req, Cart cart) {

	    int menuId =
	            Integer.parseInt(req.getParameter("MenuId"));

	    cart.removeItem(menuId);
	}
		
	private void updateItemToCart(HttpServletRequest req, Cart cart) {
		   int menuId = Integer.parseInt(req.getParameter("MenuId"));

		    int quantity =Integer.parseInt(req.getParameter("quantity"));

		            
		    cart.updateItem(menuId, quantity);
		
			
	}

	private void addItemToCart(HttpServletRequest req, Cart cart) {
		int MenuId=Integer.parseInt(req.getParameter("MenuId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		MenuDAOimp menuDAOimp=new MenuDAOimp();
		Menu menu=menuDAOimp.getMenu(MenuId);
		CartItem cartItem=new CartItem(menu.getMenuID(),menu.getItemName(),menu.getPrice(),quantity,menu.getRestaurantID());
		cart.addItem(cartItem);
		
		
		
	}
	

}
