package org.example.lk.ijse.DAO.cutom;

import org.example.lk.ijse.Controller.PaymentController;
import org.example.lk.ijse.CrudDao;
import org.example.lk.ijse.Entity.Payment;

import java.io.IOException;
import java.util.List;

public interface PaymentDao extends CrudDao<Payment> {
    boolean save(Payment Dto) throws IOException;

    boolean update(Payment entity) throws IOException;

    boolean update(PaymentController entity) throws IOException;

    boolean delete(Long id) throws IOException;

    List<Payment> getaAll() throws IOException;
}
