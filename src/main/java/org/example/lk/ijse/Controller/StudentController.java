package org.example.lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lombok.Data;
import org.example.lk.ijse.BO.BOFactory;
import org.example.lk.ijse.BO.custom.StudentBo;
import org.example.lk.ijse.DTO.StudentDto;
import org.example.lk.ijse.Entity.Student;

import java.time.LocalDate;

public class StudentController {

    @FXML
    private TableView<?> StudentTable;

    @FXML
    private Text addresstext;

    @FXML
    private TextField addresstxt;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private TableColumn<?, ?> colfirstname;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> collastname;

    @FXML
    private TableColumn<?, ?> colnumber;

    @FXML
    private DatePicker datecombo;

    @FXML
    private Text emailtext;

    @FXML
    private TextField emailtxt;

    @FXML
    private TextField firstNametxt;

    @FXML
    private Text fntext;

    @FXML
    private TextField lastnametxt;

    @FXML
    private Text lntext;

    @FXML
    private TextField phonenumbertxt;

    @FXML
    private Text pntext;

    @FXML
    private AnchorPane studentForm;

    @FXML
    private Text topic;

    StudentBo studentBo = (StudentBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);


    @FXML
    void clearOnActionStudent(ActionEvent event) {

    }

    @FXML
    void deleteOnActionStudent(ActionEvent event) {

    }

    @FXML
    void saveOnActionStudent(ActionEvent event) {

        int id = 0;
        String fn = firstNametxt.getText();
        String ln = lastnametxt.getText();
        String address = addresstxt.getText();
        String email = emailtxt.getText();
        String number = phonenumbertxt.getText();
        LocalDate enrollmentDate = datecombo.getValue();


        Student student = new Student(id,fn,ln,address,email,number,enrollmentDate);

        boolean s = false;

       try{

           s = studentBo.saveStudent(student);

       } catch (Exception e) {
           e.printStackTrace();
       }

       if (s){
           new Alert(Alert.AlertType.CONFIRMATION,"Customer SAVE Success");
       }else {

           new Alert(Alert.AlertType.ERROR,"Student save UnSuccess");
       }


    }



    @FXML
    void updateOnActionStudent(ActionEvent event) {

    }

}
