package org.example.lk.ijse;
import com.sun.javafx.menu.MenuItemBase;
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
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.cutom.StudentDao;
import org.example.lk.ijse.DAO.cutom.UserDao;
import org.example.lk.ijse.DAO.impl.UserDaoImpl;
import org.example.lk.ijse.Entity.Payment;
import org.example.lk.ijse.Entity.User;
import org.example.lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;

import javax.management.relation.Role;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class MainForm implements Initializable {

    UserDao userDao = (UserDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DAOTypes.USER);
    @FXML
    private Button payment2btn;

    @FXML
    private Button paymentMangmentBTN;

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
        if (RegisterTheSystem.userRole.equals("admin")) {
            Parent parent = FXMLLoader.load(getClass().getResource("/View/CourseForm.fxml"));
            Emptypane.getChildren().setAll(parent);
        } else {
            new Alert(Alert.AlertType.ERROR, "Access Denied: You do not have the required permissions to access this feature 🤫.").show();
        }

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
        if (RegisterTheSystem.userRole.equals("admin")) {
            Parent parent = FXMLLoader.load(getClass().getResource("/View/Payment.fxml"));
            Emptypane.getChildren().setAll(parent);
        } else {
            new Alert(Alert.AlertType.ERROR, "Access Denied: You do not have the required permissions to access this feature 🤫.").show();
        }
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

        if (RegisterTheSystem.userRole.equals("admin")) {
            Parent parent = FXMLLoader.load(getClass().getResource("/View/UserForm.fxml"));
            Emptypane.getChildren().setAll(parent);
        } else {
            new Alert(Alert.AlertType.ERROR, "Access Denied: You do not have the required permissions to access this feature 🤫.").show();
        }

    }

    public void Payment2ManagmentOnAction(ActionEvent actionEvent) throws IOException {

        if (RegisterTheSystem.userRole.equals("admin")) {
            Parent parent = FXMLLoader.load(getClass().getResource("/View/paymentForm.fxml"));
            Emptypane.getChildren().setAll(parent);
        } else {
            new Alert(Alert.AlertType.ERROR, "Access Denied: You do not have the required permissions to access this feature 🤫.").show();
        }

    }

}

