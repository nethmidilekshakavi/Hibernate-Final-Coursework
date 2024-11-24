package org.example.lk.ijse;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.lk.ijse.DAO.impl.UserDaoImpl;
import org.example.lk.ijse.Entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.imageio.IIOParam;
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
    private IIOParam loader;


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
    }


    @FXML
    void loginOnAction(ActionEvent event) throws IOException {
        User user = findUserByUsername(loginUsername.getText());

        if (user != null && new BCryptPasswordEncoder().matches(loginpw.getText(), user.getPassword())) {
            // Check role and display a message
            if (user.getRole().equals("admin") || user.getRole().equals("coordinator")) {
                new Alert(Alert.AlertType.CONFIRMATION, "Welcome back, " + user.getRole() + " " + user.getUsername() + "!").show();
                userRole = user.getRole();

                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/View/MainForm.fxml"))));
                stage.show();
                stage.centerOnScreen();
                stage.setTitle("Dashboard");
            } else {
                new Alert(Alert.AlertType.ERROR, "You don't have the required permissions!").show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Oops! Invalid username or password.").show();
            System.out.println("Oops! Invalid username or password.");
        }

        Stage currentStage = (Stage) login.getScene().getWindow();
        currentStage.close();
    }


    private User findUserByUsername(String username) {
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.getUserByUsername(username);
    }


    public void clearetextField(){
        usernametxt1.setText("");
        passwordtxt1.setText("");
        role1.setText("");
    }



}
