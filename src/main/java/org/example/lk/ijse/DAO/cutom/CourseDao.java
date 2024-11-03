package org.example.lk.ijse.DAO.cutom;

import org.example.lk.ijse.CrudDao;
import org.example.lk.ijse.Entity.Course;

import java.io.IOException;
import java.util.List;

public interface CourseDao extends CrudDao<Course> {

    boolean delete(String entity) throws IOException;

    List<Course> getaAll() throws IOException;

    List<Course> SearchCID(String cid) throws IOException;
}
