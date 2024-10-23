package org.example.lk.ijse.DAO.cutom;

import org.example.lk.ijse.CrudDao;
import org.example.lk.ijse.Entity.Student;

import java.util.List;

public interface StudentDao extends CrudDao<Student> {
    boolean save(Student enitiy);

    boolean update(Student dto);

    boolean delete(int entity);

    List<Student> getaAll();

    Student searchByCID(int id);
}
