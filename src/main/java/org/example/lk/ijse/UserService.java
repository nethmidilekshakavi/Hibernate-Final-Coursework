package org.example.lk.ijse;

import org.example.lk.ijse.DAO.impl.UserDaoImpl;
import org.example.lk.ijse.Entity.Student;
import org.example.lk.ijse.Entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(String username, String plainPassword, String role) {
        User user = new User();
        user.setUsername(username);

        String encryptedPassword = passwordEncoder.encode(plainPassword);
        user.setPassword(encryptedPassword);
        user.setRole(role);



        // Save user to the database
        UserDaoImpl userDAO = new UserDaoImpl();
        try {
            userDAO.saveUser(user);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null; // or handle the exception as needed
        }
    }
}
