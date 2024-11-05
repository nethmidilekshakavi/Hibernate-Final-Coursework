package org.example.lk.ijse.DAO.impl;

import org.example.lk.ijse.DAO.cutom.RegistrationDao;
import org.example.lk.ijse.Entity.Registration;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.util.List;


public class RegistrationDaoImpl implements RegistrationDao {
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
        Transaction transaction = session.beginTransaction();

        NativeQuery nativeQuery = session.createNativeQuery("delete from Registration where id = ?1");
        nativeQuery.setParameter(1, id);

        nativeQuery.executeUpdate();

        transaction.commit();
        session.close();

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

}
