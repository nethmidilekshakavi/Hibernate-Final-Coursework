package org.example.lk.ijse.DAO.impl;

import org.example.lk.ijse.Entity.User;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDaoImpl {

    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Roll back if there was an error
            }
            e.printStackTrace(); // Consider logging this instead of printing
        }
    }

    public User getUserByUsername(String username) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            return session.createQuery("FROM User WHERE username = :username", User.class)
                    .setParameter("username", username)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*public User getUserByRole(String role) {
        try (Session session = FactoryConfiguration.getInstance().getSession()) {
            return session.createQuery("FROM User WHERE role = :role", User.class)
                    .setParameter("role", role)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/


}
