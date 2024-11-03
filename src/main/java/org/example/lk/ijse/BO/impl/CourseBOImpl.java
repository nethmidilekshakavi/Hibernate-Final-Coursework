package org.example.lk.ijse.BO.impl;

import org.example.lk.ijse.BO.custom.CourseBO;
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.cutom.CourseDao;
import org.example.lk.ijse.Entity.Course;

import java.io.IOException;

public class CourseBOImpl implements CourseBO {

    CourseDao courseDao = (CourseDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.COURSE);

    @Override
    public boolean saveCourse(Course entity) throws IOException {
        return courseDao.save(new Course(entity.getProgramId(),entity.getProgramName(),entity.getDuration(),entity.getFee()));
    }
}
