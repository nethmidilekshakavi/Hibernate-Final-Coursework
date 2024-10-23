package org.example.lk.ijse.BO.custom;

import org.example.lk.ijse.BO.SuperBo;
import org.example.lk.ijse.DTO.StudentDto;
import org.example.lk.ijse.Entity.Student;

public interface StudentBo extends SuperBo {

    boolean saveStudent(Student entity);
}
