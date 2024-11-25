package org.example.lk.ijse.BO.impl;

import org.example.lk.ijse.BO.custom.PaymentBO;
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.cutom.PaymentDao;
import org.example.lk.ijse.DAO.cutom.RegistrationDao;
import org.example.lk.ijse.Entity.Payment;
import org.example.lk.ijse.Entity.Registration;

import java.io.IOException;
import java.util.List;

public class PaymentBOImpl implements PaymentBO {

    RegistrationDao registrationDao = (RegistrationDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.REGISTRATION);
    PaymentDao paymentDao = (PaymentDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.PAYMENT);

    @Override
    public boolean saveRegistration(Registration entity) throws IOException {
        return registrationDao.save(new Registration(entity.getId(),entity.getEnrollmentDate(),entity.getPayment(),entity.getDueAmount(),entity.getStudentName(),entity.getProgramName(),entity.getDuration(),entity.getStudent(),entity.getCourse(),entity.getPaymentList()));
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
    @Override
    public boolean savePayment(Payment entity) throws IOException {
        return paymentDao.save(new Payment(entity.getId(),entity.getEnrollmentDate(),entity.getPayment(),entity.getDueAmount(),entity.getStudentName(),entity.getProgramName(),entity.getDuePayment(),entity.getRegistration()));
    }
    @Override
    public List<Payment> getAllPayment() throws IOException {

        List<Payment> allpayment = paymentDao.getaAll();

        return  allpayment;

    }

    @Override
    public boolean UpdatePayment(Payment entity) throws IOException {
        return paymentDao.update(new Payment(entity.getId(),entity.getEnrollmentDate(),entity.getPayment(),entity.getDueAmount(),entity.getStudentName(),entity.getProgramName(),entity.getDuePayment(),entity.getRegistration()));
    }

    @Override
    public boolean deletePayment(Long id) throws IOException {
        return paymentDao.delete(id);
    }
}
