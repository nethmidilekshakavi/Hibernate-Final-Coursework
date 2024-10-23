package org.example.lk.ijse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    @FXML
    private Text ForgotPW;

    @FXML
    private Text OR;

    @FXML
    private Button SignInBtn;

    @FXML
    private Button btnLogin;

    @FXML
    private ImageView loginPic;

    @FXML
    private AnchorPane loginpage;

    @FXML
    private ImageView passwordpic;

    @FXML
    private TextField passwordtxt;

    @FXML
    private Text topic;

    @FXML
    private ImageView usernamepic;

    @FXML
    private TextField usernametxt;

    @FXML
    void SigninOnAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/View/RegisterTheSystem.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Sign Up");
        stage.centerOnScreen();
    }

    @FXML
    void loginOnAction(ActionEvent event) throws IOException {

        String un = "hii";
        String pw = "1234";

        if (usernametxt.getText().equals(un) && passwordtxt.getText().equals(pw)){

            Parent parent = FXMLLoader.load(getClass().getResource("/View/StudentForm.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        }else {
            System.out.printf("Wrong");
        }




    }

}
