package org.example.lk.ijse.BO.impl;

import org.example.lk.ijse.BO.custom.RegistrationBO;
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.cutom.StudentDao;
import org.example.lk.ijse.Entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegistrationBOImpl implements RegistrationBO {


    StudentDao studentDao = (StudentDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.STUDENT);





}
