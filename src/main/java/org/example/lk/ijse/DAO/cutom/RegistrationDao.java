package org.example.lk.ijse.DAO.cutom;

import org.example.lk.ijse.CrudDao;
import org.example.lk.ijse.Entity.Course;
import org.example.lk.ijse.Entity.Registration;
import org.example.lk.ijse.Entity.Student;

import java.io.IOException;
import java.util.List;

public interface RegistrationDao extends CrudDao<Registration> {

    boolean save(Registration Dto) throws IOException;

    boolean delete(Long id) throws IOException;

    List<Registration> getaAll() throws IOException;

    Registration searchByRID(Long id);


}
