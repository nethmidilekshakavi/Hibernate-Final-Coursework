package org.example.lk.ijse.DAO.impl;

import org.example.lk.ijse.DAO.cutom.PaymentDao;
import org.example.lk.ijse.DAO.cutom.StudentDao;
import org.example.lk.ijse.Entity.Payment;
import org.example.lk.ijse.Entity.Student;
import org.example.lk.ijse.Entity.User;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
private PaymentDao paymentDao;

    @Override
    public boolean save(Student dto) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(dto);

            transaction.commit();
            return true;  // Indicating success
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;  // Indicating failure
        } finally {
            session.close();
        }
    }


    @Override
    public boolean update(Student dto) throws IOException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(dto);

        transaction.commit();
        session.close();

        return false;
    }

    @Override
    public boolean delete(int entityId) throws IOException {

        Session session = FactoryConfiguration.getInstance().getSession();

        try {
            session.beginTransaction();
            Student student = session.get(Student.class,entityId);
            session.remove(student);
            session.getTransaction().commit();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }


    @Override
    public List<Student> getaAll() throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> list = session.createQuery("from Student ", Student.class).list();

        transaction.commit();
        session.close();


        return list;
    }


    @Override
    public List<Student> SearchSID(int sid) throws IOException {
        List<Student> studentModels = new ArrayList<>();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            studentModels = session.createQuery("FROM Student WHERE id = :sid", Student.class)
                    .setParameter("sid", sid)
                    .getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return studentModels;
    }


    @Override
    public Student searchById(int id) {
        Session session = FactoryConfiguration.getSessionFactory().openSession();
        Transaction transaction = null;
        Student student = null;

        try {
            transaction = session.beginTransaction();
            // find student
            String hql = "FROM Student WHERE id = :id";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("id", id);
            student = query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return student;
    }



}
