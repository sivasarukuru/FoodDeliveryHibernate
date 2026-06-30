package com.food.DAOimp;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.food.DAO.OrderDAO;
import com.food.Model.Order;
import com.food.Utility.DBconnection;

public class OrderDAOimp implements OrderDAO {

	private static final String INSERT =
			"INSERT INTO order_table(UserID,RestaurantID,OrderDate,TotalAmount,Status,PaymentMethod) VALUES(?,?,?,?,?,?)";
	@Override
	public int addOrder(Order o) {

		try(Connection con = DBconnection.getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT, java.sql.Statement.RETURN_GENERATED_KEYS)) {

			ps.setInt(1, o.getUserID());
			ps.setInt(2, o.getRestaurantID());
			ps.setString(3, o.getOrderDate());
			ps.setDouble(4, o.getTotalAmount());
			ps.setString(5, o.getStatus());
			ps.setString(6, o.getPaymentMethod());

			int rows = ps.executeUpdate();

			if (rows > 0) {

			    java.sql.ResultSet rs = ps.getGeneratedKeys();

			    if (rs.next()) {
			        return rs.getInt(1);
			    }
			}

			return 0;

		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Order getOrder(int orderID) {
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		return null;
	}

	@Override
	public int updateOrder(Order order) {
		return 0;
	}

	@Override
	public int deleteOrder(int orderID) {
		return 0;
	}
}