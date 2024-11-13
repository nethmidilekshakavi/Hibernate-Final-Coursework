package org.example.lk.ijse;

import org.example.lk.ijse.DAO.SuperDao;
import org.example.lk.ijse.Entity.Student;

import java.io.IOException;

public interface CrudDao<T> extends SuperDao {

    boolean save(Student enitiy) throws IOException;

    boolean update(T entity) throws IOException;
    boolean delete(int id) throws IOException;



}
