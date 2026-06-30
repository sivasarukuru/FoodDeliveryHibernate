package com.food.DAOimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.MenuDAO;
import com.food.Model.Menu;
import com.food.Utility.DBconnection;

public class MenuDAOimp implements MenuDAO {

    private static final String INSERT =
            "INSERT INTO menu_table(MenuID, RestaurantID, ItemName, Description, Price, IsAvailable, Category) VALUES(?,?,?,?,?,?,?)";

    private static final String GET_MENU =
            "SELECT * FROM menu_table WHERE MenuID = ?";

    private static final String GET_ALL_MENUS =
            "SELECT * FROM menu_table";

    private static final String GET_MENUS_BY_RESTAURANT =
            "SELECT * FROM menu_table WHERE RestaurantID = ?";

    private static final String UPDATE =
            "UPDATE menu_table SET RestaurantID=?, ItemName=?, Description=?, Price=?, IsAvailable=?, Category=? WHERE MenuID=?";

    private static final String DELETE =
            "DELETE FROM menu_table WHERE MenuID=?";

    @Override
    public int addMenu(Menu m) {

        try(Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT)) {

            ps.setInt(1, m.getMenuID());
            ps.setInt(2, m.getRestaurantID());
            ps.setString(3, m.getItemName());
            ps.setString(4, m.getDescription());
            ps.setDouble(5, m.getPrice());
            ps.setBoolean(6, m.isAvailable());
            ps.setString(7, m.getCategory());

            return ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public Menu getMenu(int menuID) {

        Menu menu = null;

        try(Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_MENU)) {

            ps.setInt(1, menuID);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                menu = new Menu();

                menu.setMenuID(rs.getInt("MenuID"));
                menu.setRestaurantID(rs.getInt("RestaurantID"));
                menu.setItemName(rs.getString("ItemName"));
                menu.setDescription(rs.getString("Description"));
                menu.setPrice(rs.getDouble("Price"));
                menu.setAvailable(rs.getBoolean("IsAvailable"));
                menu.setCategory(rs.getString("Category"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return menu;
    }

    @Override
    public List<Menu> getAllMenus() {

        List<Menu> menuList = new ArrayList<>();

        try(Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL_MENUS)) {

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Menu menu = new Menu();

                menu.setMenuID(rs.getInt("MenuID"));
                menu.setRestaurantID(rs.getInt("RestaurantID"));
                menu.setItemName(rs.getString("ItemName"));
                menu.setDescription(rs.getString("Description"));
                menu.setPrice(rs.getDouble("Price"));
                menu.setAvailable(rs.getBoolean("IsAvailable"));
                menu.setCategory(rs.getString("Category"));

                menuList.add(menu);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return menuList;
    }

    public List<Menu> getAllMenusByRestaurant(int restaurantId) {

        List<Menu> menuList = new ArrayList<>();

        try(Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(GET_MENUS_BY_RESTAURANT)) {

            ps.setInt(1, restaurantId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Menu menu = new Menu();

                menu.setMenuID(rs.getInt("MenuID"));
                menu.setRestaurantID(rs.getInt("RestaurantID"));
                menu.setItemName(rs.getString("ItemName"));
                menu.setDescription(rs.getString("Description"));
                menu.setPrice(rs.getDouble("Price"));
                menu.setAvailable(rs.getBoolean("IsAvailable"));
                menu.setCategory(rs.getString("Category"));

                menuList.add(menu);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return menuList;
    }

    @Override
    public int updateMenu(Menu menu) {

        try(Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(UPDATE)) {

            ps.setInt(1, menu.getRestaurantID());
            ps.setString(2, menu.getItemName());
            ps.setString(3, menu.getDescription());
            ps.setDouble(4, menu.getPrice());
            ps.setBoolean(5, menu.isAvailable());
            ps.setString(6, menu.getCategory());
            ps.setInt(7, menu.getMenuID());

            return ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteMenu(int menuID) {

        try(Connection con = DBconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(DELETE)) {

            ps.setInt(1, menuID);

            return ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}