package org.example.lk.ijse.DAO.impl;

import org.example.lk.ijse.DAO.cutom.StudentDao;
import org.example.lk.ijse.Entity.Student;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {


    @Override
    public boolean save(Student Dto) throws IOException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(Dto);


        transaction.commit();
        session.close();


        return false;


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
    public boolean delete(int entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery nativeQuery = session.createNativeQuery("delete from Student where id = ?1");
        nativeQuery.setParameter(1, entity);

        nativeQuery.executeUpdate();

        transaction.commit();
        session.close();

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
        // Get the current session from Hibernate
        Session session = FactoryConfiguration.getSessionFactory().openSession();
        Transaction transaction = null;
        Student student = null;

        try {
            // Begin transaction
            transaction = session.beginTransaction();

            // Create HQL query to find Customer by ID
            String hql = "FROM Student WHERE id = :id";
            Query<Student> query = session.createQuery(hql, Student.class);
            query.setParameter("id", id);

            // Execute query and get the result
            student = query.uniqueResult();

            // Commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle the exception properly in your application
        } finally {
            session.close(); // Close the session
        }

        return student;
    }



}
