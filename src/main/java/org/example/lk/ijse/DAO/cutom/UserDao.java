package org.example.lk.ijse.DAO.cutom;
import org.example.lk.ijse.CrudDao;
import org.example.lk.ijse.Entity.User;

import java.io.IOException;
import java.util.List;

public interface UserDao extends CrudDao<User> {

    void saveUser(User user);

    User getUserByUsername(String username);

    List<User> getaAll() throws IOException;

    boolean delete(int entity) throws IOException;

    List<User> SearchUID(int uid) throws IOException;
}
