package org.example.lk.ijse.BO.custom;

import org.example.lk.ijse.BO.SuperBo;
import org.example.lk.ijse.Entity.Registration;

import java.io.IOException;
import java.util.List;

public interface PaymentBO extends SuperBo {
    boolean saveRegistration(Registration entity) throws IOException;

    List<Registration> getAllRegistrationDetails() throws IOException;

    boolean deleteRegistration(Long id) throws IOException;
}
