package org.example.lk.ijse.BO.custom;

import org.example.lk.ijse.BO.SuperBo;
import org.example.lk.ijse.Entity.Student;

public interface StudentBo extends SuperBo {

    boolean saveStudent(Student entity);

    boolean updateStudent(Student entity);

    boolean deleteStudent(int id);
}
