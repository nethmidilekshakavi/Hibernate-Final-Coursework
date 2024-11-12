package org.example.lk.ijse.DAO.impl;

import org.example.lk.ijse.Controller.Payment;
import org.example.lk.ijse.DAO.cutom.PaymentDao;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class PaymentDaoImpl implements PaymentDao {

    @Override
    public boolean save(Payment entity) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);


        transaction.commit();
        session.close();


        return false;
    }

    @Override
    public boolean update(Payment entity) throws IOException {
        return false;
    }

    @Override
    public boolean delete(int id) throws IOException {
        return false;
    }


}
