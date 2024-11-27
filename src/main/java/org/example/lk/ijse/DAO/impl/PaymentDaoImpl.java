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
    public boolean save(Payment Dto) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        session.save(Dto);
        transaction.commit();
        session.close();


        return false;

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
            session.beginTransaction();
            Payment payment = session.get(Payment.class,id);
            session.delete(payment);
            session.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
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
