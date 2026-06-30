package com.food.Servlet;

import java.io.IOException;
//import org.mindrot.jbcrypt.BCrypt;

import org.mindrot.jbcrypt.BCrypt;

import com.food.DAOimp.UserDAOimp;
import com.food.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/callLoginServlet")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		HttpSession session=req.getSession();
		
		UserDAOimp userDAOimp=new UserDAOimp();
		User user = userDAOimp.getUserByUserEmail(email);
		
		
		if(user == null) {
		    resp.getWriter().println("User not found");
		    return;
		}

	
    
		    String dbPassword = user.getPassword();

		   if(BCrypt.checkpw(password, dbPassword)) {
		   // if(password.equals(dbPassword)) {

		        session.setAttribute("UserEmail", email);
		        resp.sendRedirect("callRestaurantServlet");

		    } else {

		        resp.sendRedirect("login.html");
		    }

	
		}
	}
	
	

