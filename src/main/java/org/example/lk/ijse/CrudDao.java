package org.example.lk.ijse;

import org.example.lk.ijse.DAO.SuperDao;

import java.io.IOException;
import java.util.List;

public interface CrudDao<T> extends SuperDao {

    boolean save(T entity) throws IOException;

    boolean update(T entity) throws IOException;
    boolean delete(int id) throws IOException;



}
