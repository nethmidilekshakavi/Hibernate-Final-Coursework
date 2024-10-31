package org.example.lk.ijse.DAO.cutom;

import org.example.lk.ijse.CrudDao;
import org.example.lk.ijse.Entity.Student;

import java.io.IOException;
import java.util.List;

public interface StudentDao extends CrudDao<Student> {
    boolean save(Student enitiy) throws IOException;

    boolean update(Student dto) throws IOException;

    boolean delete(int entity) throws IOException;

    List<Student> getaAll() throws IOException;

    Student searchByCID(int id) throws IOException;
}
