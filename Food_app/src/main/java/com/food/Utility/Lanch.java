package com.food.Utility;

import java.util.List;

import com.food.DAO.UserDAO;
import com.food.DAOimp.UserDAOimp;
import com.food.Model.User;

public class Lanch {
	public static void main(String[] args) {
//	Scanner scan=new Scanner(System.in);
//		System.out.println("enter the UserName");
//		String userName=scan.next();
//		System.out.println("enter the password");
//		String password=scan.next();
//		System.out.print("enter the email");
//		String email=scan.next();
//		System.out.println("enter the address");
//		String address=scan.next();
//		System.out.println("enter the role");
//		String role=scan.next();
//		
//		
//		
	//User u=new User(userName,password, email,address,role);
		 UserDAOimp userDAO=new UserDAOimp();
		// userDAO.addUser(u);
		 //System.out.println(u);
//		 
//		User u=userDAO.getUser(2);
//		System.out.println(u);
//		
//	User u=userDAO.getUser(1);
//	
//	u.setAddress("mico layout");
//	userDAO.updateUser(u);
//	System.out.println("user updated");
		 
//		 userDAO.deleteUser(1);
//		 System.out.println("user deleted");
		List<User> alluser=userDAO.getAllUsers();
		for(User user: alluser) {
			System.out.println(user);
		}
//		
	}

}
