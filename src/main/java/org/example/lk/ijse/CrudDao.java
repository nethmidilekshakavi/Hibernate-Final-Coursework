package org.example.lk.ijse;

import org.example.lk.ijse.DAO.SuperDao;

import java.util.List;

public interface CrudDao<T> extends SuperDao {

    boolean save(T entity);

    boolean update(T entity);
    boolean delete(int id);



}
