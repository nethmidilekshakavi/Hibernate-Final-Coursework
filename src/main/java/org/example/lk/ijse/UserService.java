package org.example.lk.ijse;

import org.example.lk.ijse.DAO.impl.UserDaoImpl;
import org.example.lk.ijse.Entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.management.relation.Role;

public class UserService {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(String username, String plainPassword,String role) {
        User user = new User();
        user.setUsername(username);

       user.setRole(role);

        // Encrypt the plain password using BCrypt
        String encryptedPassword = passwordEncoder.encode(plainPassword);
        user.setPassword(encryptedPassword);

        // Save user to the database
        UserDaoImpl userDAO = new UserDaoImpl();
        userDAO.saveUser(user);

        return user;
    }
}
