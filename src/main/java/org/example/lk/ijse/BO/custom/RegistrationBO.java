package org.example.lk.ijse.BO.custom;

import org.example.lk.ijse.BO.SuperBo;
import org.example.lk.ijse.Entity.Course;
import org.example.lk.ijse.Entity.Payment;
import org.example.lk.ijse.Entity.Registration;
import org.example.lk.ijse.Entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface RegistrationBO extends SuperBo {

    boolean saveCourse(Course entity) throws IOException;

    boolean updateCourse(Course entity) throws IOException;

    boolean deleteCourse(String id) throws IOException;

    List<Course> getAllCourse() throws IOException;

    List<Course> SearchCID(String cid) throws IOException;


    boolean saveStudent(Student entity) throws IOException;

    boolean updateStudent(Student entity) throws IOException;

    boolean deleteStudent(int id) throws IOException;

    List<Student> getAllStudent() throws IOException;

    List<Student> SearchSID(int sid) throws IOException;

    Student serachbyIDS(int cid) throws SQLException, ClassNotFoundException;


    Course serachbyCIDs(String cid) throws SQLException, ClassNotFoundException;

    boolean saveRegistration(Registration registration, Payment payment) throws IOException;

    List<Registration> getAllRegistrationDetails() throws IOException;

    boolean deleteRegistration(Long id) throws IOException;

    Registration serachbyRID(Long rid) throws SQLException, ClassNotFoundException;

    boolean updateRegistration(Registration registration) throws SQLException;

/*
    boolean updateRegistration(Registration registration) throws SQLException;
*/
}
