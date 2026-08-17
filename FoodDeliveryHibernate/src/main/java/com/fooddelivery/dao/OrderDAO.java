package com.fooddelivery.dao;

import com.fooddelivery.entity.FoodOrder;
import com.fooddelivery.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class OrderDAO {
    public void save(FoodOrder order) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(order);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<FoodOrder> findByUser(Long userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT DISTINCT o FROM FoodOrder o " +
                    "LEFT JOIN FETCH o.items i " +
                    "LEFT JOIN FETCH i.menuItem " +
                    "WHERE o.user.id = :uid ORDER BY o.orderDate DESC",
                    FoodOrder.class)
                    .setParameter("uid", userId)
                    .getResultList();
        }
    }
}
