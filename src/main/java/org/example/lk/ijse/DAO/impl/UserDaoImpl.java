package org.example.lk.ijse.DAO.impl;

import org.example.lk.ijse.Entity.User;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDaoImpl {

    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = FactoryConfiguration.getInstance().getSession()) { // Use getInstance() for singleton
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback if transaction is active
            }
            e.printStackTrace();
        }
    }
}
