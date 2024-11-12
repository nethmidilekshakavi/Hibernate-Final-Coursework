package org.example.lk.ijse.BO.impl;

import org.example.lk.ijse.BO.custom.PaymentBO;
import org.example.lk.ijse.Controller.Payment;
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.cutom.CourseDao;
import org.example.lk.ijse.DAO.cutom.PaymentDao;
import org.example.lk.ijse.DAO.cutom.RegistrationDao;
import org.example.lk.ijse.DAO.cutom.StudentDao;
import org.example.lk.ijse.Entity.Registration;
import org.example.lk.ijse.Entity.Student;

import java.io.IOException;
import java.util.List;

public class PaymentBOImpl implements PaymentBO {

    RegistrationDao registrationDao = (RegistrationDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.REGISTRATION);
    PaymentDao paymentDao = (PaymentDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.PAYMENT);

    @Override
    public boolean saveRegistration(Registration entity) throws IOException {
        return registrationDao.save(new Registration(entity.getId(),entity.getEnrollmentDate(),entity.getPayment(),entity.getDueAmount(),entity.getStudentName(),entity.getProgramName(),entity.getDuration(),entity.getStudent(),entity.getCourse()));
    }

    @Override
    public List<Registration> getAllRegistrationDetails() throws IOException {

        List<Registration> alldetails = registrationDao.getaAll();

        return alldetails;

    }

    @Override
    public boolean deleteRegistration(Long id) throws IOException {
        return registrationDao.delete(id);
    }



   /* public boolean savePayment(Registration entity) throws IOException {
      //  return paymentDao.save(new Payment(entity.getId(),entity));
    }*/
}
