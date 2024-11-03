package org.example.lk.ijse.BO.custom;

import org.example.lk.ijse.BO.SuperBo;
import org.example.lk.ijse.Entity.Course;

import java.io.IOException;

public interface CourseBO extends SuperBo {
    boolean saveCourse(Course entity) throws IOException;
}
