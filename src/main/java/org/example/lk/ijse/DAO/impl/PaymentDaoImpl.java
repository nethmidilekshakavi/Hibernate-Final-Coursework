package org.example.lk.ijse.DAO.impl;
import org.example.lk.ijse.Controller.PaymentController;
import org.example.lk.ijse.DAO.cutom.PaymentDao;
import org.example.lk.ijse.DAO.cutom.RegistrationDao;
import org.example.lk.ijse.Entity.Course;
import org.example.lk.ijse.Entity.Payment;
import org.example.lk.ijse.Entity.Registration;
import org.example.lk.ijse.Entity.Student;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoImpl implements PaymentDao {

    private RegistrationDao registrationDao;
    @Override
    public boolean save(Payment entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }


    @Override
    public boolean save(Student enitiy) throws IOException {
        return false;
    }

    @Override
    public boolean update(Payment entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();



        session.update(entity);


        transaction.commit();
        session.close();


        return false;
    }

    @Override
    public boolean delete(int id) throws IOException {
        return false;
    }

    @Override
    public boolean update(PaymentController entity) throws IOException {
        return false;
    }

    @Override
    public boolean delete(Long id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;
        try {
            // Start transaction
            transaction = session.beginTransaction();

            // HQL Query to delete Payment by id
            String hql = "DELETE FROM Payment p WHERE p.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id); // Set the parameter for the id

            // Execute the delete operation
            int result = query.executeUpdate();

            // Commit the transaction
            if (result > 0) {
                transaction.commit();
                return true; // Deletion successful
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback(); // Rollback in case of error
            }
        }
        return false; // Deletion failed
    }



    @Override
    public List<Payment> getaAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Payment> list = session.createQuery("from Payment ", Payment.class).list();


        transaction.commit();
        session.close();


        return list;
    }
}
