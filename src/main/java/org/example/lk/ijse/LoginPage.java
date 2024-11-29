package org.example.lk.ijse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.lk.ijse.DAO.impl.UserDaoImpl;
import org.example.lk.ijse.Entity.User;

public class LoginPage extends UserService{

    @FXML
    private Text SignUp;

    @FXML
    private Text SignUp2;

    @FXML
    private TextField passwordtxt;

    @FXML
    private TextField passwordtxt1;

    @FXML
    private TextField role;

    @FXML
    private TextField role1;

    @FXML
    private Button signUpbtn;

    @FXML
    private Button signUpbtn1;

    @FXML
    private TextField usernametxt;

    @FXML
    private TextField usernametxt1;

    public static String userRole = "";

    @FXML
    void SignUpOnAction(ActionEvent event) {
        String username = usernametxt1.getText();
        String password = passwordtxt1.getText();
        String role = role1.getText();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        RegisterTheSystem registerTheSystem = new RegisterTheSystem();
        registerTheSystem.registerUser(username,password,role);

        if (role != null && role.equals("admin")) {
            new Alert(Alert.AlertType.CONFIRMATION, "Welcome Admin!  " + username).show();
            userRole = "admin";
        } else if (role != null && role.equals("coordinator")) {
            userRole = "coordinator";
            new Alert(Alert.AlertType.CONFIRMATION, "Welcome coordinator!  " + username).show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Invalid role!").show();
        }

        clearetextField();

        Stage currentStage = (Stage) signUpbtn1.getScene().getWindow();
        currentStage.close();
    }


    public void clearetextField(){
        usernametxt1.setText("");
        passwordtxt1.setText("");
        role1.setText("");
    }

    private User findUserByUsername(String username) {
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.getUserByUsername(username);
    }


}
