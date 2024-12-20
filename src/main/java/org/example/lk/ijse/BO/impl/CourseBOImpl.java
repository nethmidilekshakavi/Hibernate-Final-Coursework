package org.example.lk.ijse.BO.impl;

import org.example.lk.ijse.BO.custom.CourseBO;
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.cutom.CourseDao;
import org.example.lk.ijse.Entity.Course;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CourseBOImpl implements CourseBO {

    CourseDao courseDao = (CourseDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.COURSE);

    @Override
    public boolean saveCourse(Course entity) throws IOException {
        return courseDao.save(
                new Course(entity.getId(),entity.getProgramId(),entity.getProgramName(),entity.getDuration(),entity.getFee(),entity.getRegistrations()));
    }

    @Override
    public boolean updateCourse(Course entity) throws IOException {
        return courseDao.update(new Course(entity.getId(),entity.getProgramId(),entity.getProgramName(),entity.getDuration(),entity.getFee(),entity.getRegistrations()));
    }

    @Override
    public boolean deleteCourse(String id) throws IOException {
        return courseDao.delete(id);
    }

    @Override
    public List<Course> getAllCourse() throws IOException {

        List<Course> allCourse = courseDao.getaAll();

        return allCourse;

    }

    @Override
    public List<Course> SearchCID(String cid) throws IOException {

        return courseDao.SearchCID(cid);

    }

    @Override
    public Course serachbyCIDs(String cid) throws SQLException, ClassNotFoundException {
        return courseDao.searchByCId(cid);
    }

}
