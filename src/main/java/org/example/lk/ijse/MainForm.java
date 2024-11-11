package org.example.lk.ijse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.lk.ijse.Entity.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainForm implements Initializable {

    @FXML
    private AnchorPane ButtonPane;

    @FXML
    private Button CoourseManagmentbtn;

    @FXML
    private AnchorPane Emptypane;

    @FXML
    private Button StudentManagmentBtn;

    @FXML
    private Button logOutbtn;


    @FXML
    private Button DashBoardbtn;

    @FXML
    void CourseManagmentOnAction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/View/CourseForm.fxml"));
        Emptypane.getChildren().setAll(parent);
    }


    @FXML
    void StudentManageOnAction(ActionEvent event) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/StudentForm.fxml"));
        Emptypane.getChildren().setAll(parent);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Emptypane.getChildren().clear();
        Emptypane.getChildren().add(root);
    }


    @FXML
    void DashBoradOnAction(ActionEvent event) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/DashBoard.fxml"));
        Emptypane.getChildren().setAll(parent);
    }

    public void PaymentManagmentOnAction(ActionEvent actionEvent) throws IOException {

      /*  User user = new User();

        if (!user.getRole().equals("Admin")){
            Parent parent= FXMLLoader.load(getClass().getResource("/view/Payment.fxml"));
            Emptypane.getChildren().setAll(parent);
        }else {
            System.out.println("NOT OPEN");
        }
*/
        Parent parent= FXMLLoader.load(getClass().getResource("/view/Payment.fxml"));
        Emptypane.getChildren().setAll(parent);

    }


    @FXML
    void logOutTheSystem(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/View/RegisterTheSystem.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        stage.setTitle("Login");

        Stage currentStage = (Stage) ButtonPane.getScene().getWindow();
        currentStage.close();
    }

    public void UserManageOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/View/UserForm.fxml"));
        Emptypane.getChildren().setAll(parent);
    }
}

