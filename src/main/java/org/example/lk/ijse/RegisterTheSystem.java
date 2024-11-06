package org.example.lk.ijse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.lk.ijse.DAO.impl.UserDaoImpl;
import org.example.lk.ijse.Entity.User;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

public class RegisterTheSystem extends UserService {

    @FXML
    private Text SignUp;

    @FXML
    private Button login;

    @FXML
    private TextField loginUsername;

    @FXML
    private TextField loginpw;

    @FXML
    private TextField passwordtxt1;

    @FXML
    private TextField role1;

    @FXML
    private Button signUpbtn;

    @FXML
    private TextField usernametxt1;

    @FXML
    void SignUpOnAction(ActionEvent event) {
        String username = usernametxt1.getText();
        String password = passwordtxt1.getText();
        String role = role1.getText();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        UserService userService = new UserService();
        userService.registerUser(username, password, role);
    }

    @FXML
    void loginOnAction(ActionEvent event) throws IOException {
        User user = findUserByUsername(loginUsername.getText());





        if (user != null && new BCryptPasswordEncoder().matches(loginpw.getText(), user.getPassword())) {
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/View/MainForm.fxml"))));
            stage.show();
            stage.centerOnScreen();
            stage.setTitle("Dashboard");


        } else {
            System.out.println("Oops! Invalid username or password.");
        }

        Stage currentStage = (Stage) login.getScene().getWindow();
        currentStage.close();

    }

    private User findUserByUsername(String username) {
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.getUserByUsername(username);
    }





}
