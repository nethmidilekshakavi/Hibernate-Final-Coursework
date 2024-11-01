package org.example.lk.ijse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

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
    void CourseManagmentOnAction(ActionEvent event) {

    }

    @FXML
    void LogOutOnAction(ActionEvent event) {

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
            root = FXMLLoader.load(getClass().getResource("/view/AdminDashBoard.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Emptypane.getChildren().clear();
        Emptypane.getChildren().add(root);
    }


    @FXML
    void DashBoradOnAction(ActionEvent event) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("/view/AdminDashBoard.fxml"));
        Emptypane.getChildren().setAll(parent);
    }

    public void PaymentManagmentOnAction(ActionEvent actionEvent) {
    }

    public void logOutTheSystem(ActionEvent actionEvent) {
    }
}