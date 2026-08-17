package com.fooddelivery.dao;

import com.fooddelivery.entity.MenuItem;
import com.fooddelivery.util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class MenuDAO {
    public List<MenuItem> findByRestaurant(Long restaurantId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "FROM MenuItem m WHERE m.restaurant.id = :rid ORDER BY m.name",
                    MenuItem.class)
                    .setParameter("rid", restaurantId)
                    .getResultList();
        }
    }

    public MenuItem findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(MenuItem.class, id);
        }
    }
}
