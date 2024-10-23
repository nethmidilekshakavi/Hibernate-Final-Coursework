package org.example.lk.ijse.BO.impl;
import org.example.lk.ijse.BO.custom.StudentBo;
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.cutom.StudentDao;
import org.example.lk.ijse.Entity.Student;

import java.util.List;

public class StudentBoImpl implements StudentBo {

    StudentDao studentDao = (StudentDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.STUDENT);

    @Override
    public boolean saveStudent(Student entity){
         return studentDao.save(new Student(entity.getId(),entity.getFirstName(),entity.getLastName(),entity.getAddress(),entity.getEmail(),entity.getPhoneNumber(),entity.getEnrollmentDate()));
    }


    @Override
    public boolean updateStudent(Student entity){
        return studentDao.update(new Student(entity.getId(),entity.getFirstName(),entity.getLastName(),entity.getAddress(),entity.getEmail(),entity.getPhoneNumber(),entity.getEnrollmentDate()));
    }

    @Override
    public boolean deleteStudent(int id){
        return studentDao.delete(id);
    }

    @Override
    public List<Student> getAllStudent(){

        List<Student> allStudent = studentDao.getaAll();

        return allStudent;

    }

    @Override
    public Student serachbyIDS(int sid) {
        Student student = studentDao.searchByCID(sid);

        return new Student(student.getId(),student.getFirstName(),student.getLastName(),student.getAddress(),student.getEmail(),student.getPhoneNumber(),student.getEnrollmentDate());
    }

}
