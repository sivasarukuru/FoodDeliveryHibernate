package com.fooddelivery.dao;

import com.fooddelivery.entity.Restaurant;
import com.fooddelivery.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class RestaurantDAO {
    public List<Restaurant> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Restaurant r ORDER BY r.rating DESC", Restaurant.class)
                    .getResultList();
        }
    }

    public Restaurant findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Restaurant.class, id);
        }
    }

    public void save(Restaurant restaurant) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(restaurant);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
