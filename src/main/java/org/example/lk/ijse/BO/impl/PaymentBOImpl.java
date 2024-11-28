package org.example.lk.ijse.BO.impl;

import javafx.scene.control.Alert;
import org.example.lk.ijse.BO.BOFactory;
import org.example.lk.ijse.BO.custom.PaymentBO;
import org.example.lk.ijse.BO.custom.RegistrationBO;
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.cutom.PaymentDao;
import org.example.lk.ijse.DAO.cutom.RegistrationDao;
import org.example.lk.ijse.Entity.Payment;
import org.example.lk.ijse.Entity.Registration;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.List;

public class PaymentBOImpl implements PaymentBO {

    RegistrationDao registrationDao = (RegistrationDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.REGISTRATION);
    PaymentDao paymentDao = (PaymentDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.PAYMENT);

    RegistrationBO registrationBO = (RegistrationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTRATION);

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
    public boolean savePayment(Payment entity, Registration registration) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Save payment entity
            boolean isPaymentSaved = paymentDao.save(new Payment(
                    entity.getId(),
                    entity.getEnrollmentDate(),
                    entity.getPayment(),
                    entity.getDueAmount(),
                    entity.getStudentName(),
                    entity.getProgramName(),
                    entity.getDuePayment(),
                    entity.getRegistration()
            ));

            if (isPaymentSaved) {
                transaction.rollback();
                new Alert(Alert.AlertType.ERROR, "Failed to save the payment!").show();
                return false;
            }

            // Calculate the new due amount after payment
            double newDueAmount = registration.getDueAmount() - entity.getPayment();

            // Update registration table's due amount
            boolean isRegistrationUpdated = registrationBO.updateRegistration(
                    new Registration(registration.getId(), newDueAmount)
            );

            if (isRegistrationUpdated) {
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                new Alert(Alert.AlertType.ERROR, "Failed to update the due amount!").show();
                return false;
            }

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "An error occurred while saving the transaction.").show();
            return false;
        } finally {
            session.close();
        }
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
