package org.example.lk.ijse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.lk.ijse.DAO.impl.UserDaoImpl;
import org.example.lk.ijse.Entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

public class RegisterTheSystem extends UserService {

    @FXML
    private Text SignUp1;

    @FXML
    private Button login;

    @FXML
    private TextField loginUsername;

    @FXML
    private TextField loginpw;

    @FXML
    private AnchorPane page1;

    @FXML
    private ImageView pic1, pic2, pic3;

    @FXML
    private Button singupbtnOpen;

    @FXML
    private Text topic;

    public static String userRole = "";

    @FXML
    void loginOnAction(ActionEvent event) throws IOException {
        String username = loginUsername.getText();
        String password = loginpw.getText();

        User user = findUserByUsername(username);

        if (user != null && new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            // Check role and display appropriate message
            if ("admin".equals(user.getRole()) || "coordinator".equals(user.getRole())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Welcome back, " + user.getRole() + " " + username + "!").showAndWait();
                userRole = user.getRole();

                // Load dashboard
                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/View/MainForm.fxml"))));
                stage.show();
                stage.centerOnScreen();
                stage.setTitle("Dashboard");

                // Close the current stage
                Stage currentStage = (Stage) login.getScene().getWindow();
                currentStage.close();
            } else {
                new Alert(Alert.AlertType.ERROR, "You don't have the required permissions!").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid username or password!").show();
        }
    }

    @FXML
    void singuppageOpenBtn(ActionEvent event) throws IOException {
        // Load the signup page
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/View/LoginPage.fxml"))));
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Sign Up");
    }

    private User findUserByUsername(String username) {
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.getUserByUsername(username);
    }
}
