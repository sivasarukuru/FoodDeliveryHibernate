package com.fooddelivery.service;

import com.fooddelivery.dao.UserDAO;
import com.fooddelivery.entity.User;

public class UserService {
    private final UserDAO dao = new UserDAO();

    public void register(String name, String email, String password) {
        if (dao.findByEmail(email) != null) {
            throw new IllegalArgumentException("Email already registered.");
        }
        dao.save(new User(name, email, password));
    }

    public User login(String email, String password) {
        User user = dao.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
