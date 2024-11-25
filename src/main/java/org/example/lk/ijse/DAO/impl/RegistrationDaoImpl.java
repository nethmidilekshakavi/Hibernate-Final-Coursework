package org.example.lk.ijse.DAO.impl;

import org.example.lk.ijse.DAO.cutom.PaymentDao;
import org.example.lk.ijse.DAO.cutom.RegistrationDao;
import org.example.lk.ijse.Entity.Payment;
import org.example.lk.ijse.Entity.Registration;
import org.example.lk.ijse.Entity.Student;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;


public class RegistrationDaoImpl implements RegistrationDao {
    private PaymentDao paymentDao;
    private RegistrationDao registrationDao;
    @Override
    public boolean save(Registration Dto) throws IOException {

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
    public boolean update(Registration entity) throws IOException {
        return false;
    }

    @Override
    public boolean delete(int id) throws IOException {

        return false;
    }

    @Override
    public boolean delete(Long id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Load the Student entity
            Student student = session.get(Student.class, id);

            if (student != null) {
                // Delete the student; cascade will handle related entities
                session.delete(student);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return false;
    }


    @Override
    public List<Registration> getaAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Registration> list = session.createQuery("from Registration ", Registration.class).list();

        transaction.commit();
        session.close();

        return list;
    }

    @Override
    public Registration searchByRID(Long id) {
        Session session = FactoryConfiguration.getSessionFactory().openSession();
        Transaction transaction = null;
        Registration registration = null;

        try {
            transaction = session.beginTransaction();
            // find student
            String hql = "FROM Registration WHERE id = :id";
            Query<Registration> query = session.createQuery(hql, Registration.class);
            query.setParameter("id", id);
            registration = query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return registration;
    }



}
