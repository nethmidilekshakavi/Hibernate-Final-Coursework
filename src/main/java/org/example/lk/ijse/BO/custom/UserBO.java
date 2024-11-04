package org.example.lk.ijse.BO.custom;

import org.example.lk.ijse.BO.SuperBo;
import org.example.lk.ijse.Entity.User;

import java.io.IOException;
import java.util.List;

public interface UserBO extends SuperBo {

    List<User> getAllUser() throws IOException;

    boolean updateUser(User entity) throws IOException;

    boolean deleteUser(int id) throws IOException;


    List<User> SearchUID(int uid) throws IOException;
}
