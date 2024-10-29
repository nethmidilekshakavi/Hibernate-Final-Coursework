package org.example.lk.ijse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class WelcomePage{

    @FXML
    private Button adminbtn;

    @FXML
    private Text topic;

    @FXML
    private ImageView welcomepage2;

    @FXML
    private AnchorPane welocomepage;

    @FXML
    private ImageView welocomepagepic1;

    @FXML
    void AdmissionsOnAction(ActionEvent event) {

    }

    @FXML
    void adminOnAction(ActionEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage currentStage = (Stage) adminbtn.getScene().getWindow();
        currentStage.close();

    }

}
