package org.example.lk.ijse;
import org.example.lk.ijse.DAO.impl.UserDaoImpl;
import org.example.lk.ijse.Entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

public class UserService {
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(String username, String plainPassword, String role) {
        User user = new User();
        user.setUsername(username);

        // Encrypt the plain password using BCrypt
        String encryptedPassword = passwordEncoder.encode(plainPassword);
        user.setPassword(encryptedPassword);
        user.setRole(role);

        // Save user to the database
        UserDaoImpl userDAO = new UserDaoImpl();
        userDAO.saveUser(user);

        return user;
    }

    /*@Override
    public boolean update(Student dto) throws IOException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(dto);

        transaction.commit();
        session.close();

        return false;
    }*/

}
