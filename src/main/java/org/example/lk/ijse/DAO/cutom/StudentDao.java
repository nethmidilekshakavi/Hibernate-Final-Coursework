package org.example.lk.ijse.DAO.cutom;

import org.example.lk.ijse.CrudDao;
import org.example.lk.ijse.Entity.Student;

public interface StudentDao extends CrudDao<Student> {
    boolean save(Student enitiy);
}
