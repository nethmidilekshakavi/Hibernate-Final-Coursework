package org.example.lk.ijse.DAO.impl;

import org.example.lk.ijse.DAO.cutom.StudentDao;
import org.example.lk.ijse.Entity.Student;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

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


    @Override
    public boolean update(Student dto){

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(dto);

        transaction.commit();
        session.close();

        return false;
    }

    @Override
    public boolean delete(int entity){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery nativeQuery = session.createNativeQuery("delete from Student where id = ?1");
        nativeQuery.setParameter(1,entity);

        nativeQuery.executeUpdate();

        transaction.commit();
        session.close();

        return false;
    }

}
