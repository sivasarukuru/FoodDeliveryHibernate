
package com.food.DAOimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.UserDAO;
import com.food.Model.User;
import com.food.Utility.DBconnection;

public class UserDAOimp implements UserDAO {

    private static final String INSERT_QUERY =
            "INSERT INTO user_table(UserName,password,email,address,role,createdDate,lastLoginDate) VALUES(?,?,?,?,?,?,?)";

    private static final String SELECT_QUERY =
            "SELECT * FROM user_table WHERE UserId=?";

    private static final String SELECT_BY_EMAIL_QUERY =
            "SELECT * FROM user_table WHERE email=?";

    private static final String UPDATE_QUERY =
            "UPDATE user_table SET UserName=?,password=?,email=?,address=?,lastLoginDate=? WHERE UserId=?";

    private static final String DELETE_QUERY =
            "DELETE FROM user_table WHERE UserId=?";

    private static final String SELECT_ALL_QUERY =
            "SELECT * FROM user_table";

    @Override
    public int addUser(User user) {

        Connection con = DBconnection.getConnection();

        try {

            PreparedStatement pstmt =
                    con.prepareStatement(INSERT_QUERY);

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getAddress());
            pstmt.setString(5, user.getRole());
            pstmt.setTimestamp(6,
                    new Timestamp(System.currentTimeMillis()));
            pstmt.setTimestamp(7,
                    new Timestamp(System.currentTimeMillis()));

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public User getUser(int userId) {

        User user = null;

        try {

            Connection connection =
                    DBconnection.getConnection();

            PreparedStatement pstmt =
                    connection.prepareStatement(SELECT_QUERY);

            pstmt.setInt(1, userId);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {

                String userName = res.getString("UserName");
                String password = res.getString("password");
                String email = res.getString("email");
                String address = res.getString("address");
                String role = res.getString("role");
                Timestamp createdDate =
                        res.getTimestamp("createdDate");
                Timestamp lastLoginDate =
                        res.getTimestamp("lastLoginDate");

                user = new User(
                        userId,
                        userName,
                        password,
                        email,
                        address,
                        role,
                        createdDate,
                        lastLoginDate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User getUserByUserEmail(String userEmail) {

        User user = null;

        try {

            Connection connection =
                    DBconnection.getConnection();
            
            System.out.println("Login Connection = " + connection);

            PreparedStatement pstmt =
                    connection.prepareStatement(SELECT_BY_EMAIL_QUERY);

            pstmt.setString(1, userEmail);

            ResultSet res = pstmt.executeQuery();

            if (res.next()) {

                int userId = res.getInt("UserId");
                String userName = res.getString("UserName");
                String password = res.getString("password");
                String email = res.getString("email");
                String address = res.getString("address");
                String role = res.getString("role");
                Timestamp createdDate =
                        res.getTimestamp("createdDate");
                Timestamp lastLoginDate =
                        res.getTimestamp("lastLoginDate");

                user = new User(
                        userId,
                        userName,
                        password,
                        email,
                        address,
                        role,
                        createdDate,
                        lastLoginDate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void updateUser(User user) {

        try {

            Connection connection =
                    DBconnection.getConnection();

            PreparedStatement pstmt =
                    connection.prepareStatement(UPDATE_QUERY);

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getAddress());
            pstmt.setTimestamp(5,
                    new Timestamp(System.currentTimeMillis()));
            pstmt.setInt(6, user.getUserId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {

        try {

            Connection connection =
                    DBconnection.getConnection();

            PreparedStatement pstmt =
                    connection.prepareStatement(DELETE_QUERY);

            pstmt.setInt(1, userId);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {

        List<User> list = new ArrayList<>();

        try {

            Connection connection =
                    DBconnection.getConnection();


            Statement stmt =
                    connection.createStatement();

            ResultSet res =
                    stmt.executeQuery(SELECT_ALL_QUERY);

            while (res.next()) {

                int userId = res.getInt("UserId");
                String userName = res.getString("UserName");
                String password = res.getString("password");
                String email = res.getString("email");
                String address = res.getString("address");
                String role = res.getString("role");
                Timestamp createdDate =
                        res.getTimestamp("createdDate");
                Timestamp lastLoginDate =
                        res.getTimestamp("lastLoginDate");

                User user = new User(
                        userId,
                        userName,
                        password,
                        email,
                        address,
                        role,
                        createdDate,
                        lastLoginDate);

                list.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}

