package com.food.Servlet;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.food.DAOimp.UserDAOimp;
import com.food.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/callRegisterServlet")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		String role=req.getParameter("role");
		
		String hashpw=BCrypt.hashpw(password,BCrypt.gensalt(12));
		//String hashpw=password;
		

		
		User user=new User(name,hashpw,email, address,role);
		UserDAOimp userDAOimp=new UserDAOimp();
		int res=userDAOimp.addUser(user);
		System.out.println("Result = " + res);
		
		if(res>0) {
			resp.sendRedirect("login.html");
			
		}
		else {
			resp.sendRedirect("Register.html");
		}
		
		
	}
	

}
