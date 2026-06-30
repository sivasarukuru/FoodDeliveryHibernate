package com.food.DAOimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.food.DAO.OrderItemDAO;
import com.food.Model.OrderItem;
import com.food.Utility.DBconnection;

public class OrderItemDAOimp implements OrderItemDAO {

	private static final String INSERT =
	"INSERT INTO orderitem_table(OrderID,MenuID,Quantity,ItemTotal) VALUES(?,?,?,?)";

	@Override
	public int addOrderItem(OrderItem o) {

		try(Connection con = DBconnection.getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT)) {

			ps.setInt(1, o.getOrderID());
			ps.setInt(2, o.getMenuID());
			ps.setInt(3, o.getQuantity());
			ps.setDouble(4, o.getItemTotal());

			return ps.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public OrderItem getOrderItem(int orderItemID) {
		return null;
	}

	@Override
	public List<OrderItem> getAllOrderItems() {
		return null;
	}

	@Override
	public int updateOrderItem(OrderItem orderItem) {
		return 0;
	}

	@Override
	public int deleteOrderItem(int orderItemID) {
		return 0;
	}
}