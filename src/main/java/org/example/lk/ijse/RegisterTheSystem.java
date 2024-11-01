package org.example.lk.ijse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.example.lk.ijse.Entity.User;

public class RegisterTheSystem extends UserService{

    @FXML
    private Text SignUp;

    @FXML
    private Text SignUp1;

    @FXML
    private Text SignUp2;

    @FXML
    private Button login;

    @FXML
    private TextField loginUsername;

    @FXML
    private TextField loginpw;

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
    private Text topic;

    @FXML
    private TextField usernametxt;

    @FXML
    private TextField usernametxt1;

    @FXML
    void SignUpOnAction(ActionEvent event) {


        String un = usernametxt1.getText();
        String pw = passwordtxt1.getText();
        String role = role1.getText();

        User user = new User();

        user.setUsername(un);
        user.setPassword(pw);
        user.setRole(role);

        UserService userService = new UserService();

        userService.registerUser(user.getUsername(), user.getPassword(), user.getRole());


    }

    @FXML
    void loginOnAction(ActionEvent event) {



    }

}
