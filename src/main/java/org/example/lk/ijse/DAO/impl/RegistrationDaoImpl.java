package org.example.lk.ijse.DAO.impl;

import org.example.lk.ijse.DAO.cutom.RegistrationDao;
import org.example.lk.ijse.Entity.Registration;
import org.example.lk.ijse.Entity.Student;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;


public class RegistrationDaoImpl implements RegistrationDao {
    @Override
    public boolean save(Registration entity) throws IOException {
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



}