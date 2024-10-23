package org.example.lk.ijse.BO.impl;
import org.example.lk.ijse.BO.custom.StudentBo;
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.cutom.StudentDao;
import org.example.lk.ijse.Entity.Student;

public class StudentBoImpl implements StudentBo {

    StudentDao studentDao = (StudentDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.STUDENT);

    @Override
    public boolean saveStudent(Student entity){
         return studentDao.save(new Student(entity.getId(),entity.getFirstName(),entity.getLastName(),entity.getAddress(),entity.getEmail(),entity.getPhoneNumber(),entity.getEnrollmentDate()));
    }

}
