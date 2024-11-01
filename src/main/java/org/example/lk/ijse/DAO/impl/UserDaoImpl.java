package org.example.lk.ijse.DAO.impl;

import org.example.lk.ijse.Entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class UserDaoImpl {
     Session HibernateUtil;

    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
