package com.food.Utility;

import com.food.DAOimp.MenuDAOimp;
import com.food.Model.Menu;

public class MenuLanch {

	public static void main(String[] args) {

		Menu m = new Menu(
				1,
				1,
				"Chicken Biryani",
				"Hyderabadi Dum Biryani",
				299.0,
				true,
				"Main Course");

		MenuDAOimp dao = new MenuDAOimp();

		int result = dao.addMenu(m);

		if(result > 0) {
			System.out.println("Menu Added Successfully");
		}
		else {
			System.out.println("Menu Not Added");
		}
	}
}