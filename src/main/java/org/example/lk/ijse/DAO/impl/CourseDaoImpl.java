package org.example.lk.ijse.DAO.impl;

import org.example.lk.ijse.DAO.cutom.CourseDao;
import org.example.lk.ijse.Entity.Course;
import org.example.lk.ijse.Entity.Student;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class CourseDaoImpl implements CourseDao {

    @Override
    public boolean save(Course Dto) throws IOException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(Dto);


        transaction.commit();
        session.close();


        return false;


    }

    @Override
    public boolean update(Course entity) throws IOException {
        return false;
    }

    @Override
    public boolean delete(int id) throws IOException {
        return false;
    }


}
