package org.example.lk.ijse.DAO.impl;

import org.example.lk.ijse.DAO.cutom.StudentDao;
import org.example.lk.ijse.Entity.Student;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDaoImpl implements StudentDao {

    @Override
    public boolean save(Student Dto) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(Dto);


        transaction.commit();
        session.close();


        return false;
    }

}
