package org.example.lk.ijse.BO.custom;

import org.example.lk.ijse.BO.SuperBo;
import org.example.lk.ijse.Entity.Course;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CourseBO extends SuperBo {
    boolean saveCourse(Course entity) throws IOException;

    boolean updateCourse(Course entity) throws IOException;

    boolean deleteCourse(String id) throws IOException;

    List<Course> getAllCourse() throws IOException;

    List<Course> SearchCID(String cid) throws IOException;


    Course serachbyCIDs(String cid) throws SQLException, ClassNotFoundException;
}
