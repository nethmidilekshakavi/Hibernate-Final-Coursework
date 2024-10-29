package org.example.lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.example.lk.ijse.BO.BOFactory;
import org.example.lk.ijse.BO.custom.StudentBo;
import org.example.lk.ijse.DTO.TM.StudentTM;
import org.example.lk.ijse.Entity.Student;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    @FXML
    private TableView<StudentTM> StudentTable;

    @FXML
    private Text addresstext;

    @FXML
    private Text idtext;

    @FXML
    private TextField idtxt;

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
    @FXML
    private TableColumn<StudentTM, JFXButton> deletebtnrow;

    @FXML
    private TableColumn<StudentTM, JFXButton> updatebtnrow;

    StudentBo studentBo = (StudentBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);


    @FXML
    void clearOnActionStudent(ActionEvent event) {

    }

    @FXML
    void deleteOnActionStudent(ActionEvent event) {
      /*  int id = Integer.parseInt(idtxt.getText());

        boolean s = false;

        s = studentBo.deleteStudent(id);


        if (s){
            new Alert(Alert.AlertType.ERROR,"Student not delete").show();
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Student delete Success").show();

        }*/
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
        int id = Integer.parseInt(idtxt.getText());
        String fn = firstNametxt.getText();
        String ln = lastnametxt.getText();
        String address = addresstxt.getText();
        String email = emailtxt.getText();
        String number = phonenumbertxt.getText();
        LocalDate enrollmentDate = datecombo.getValue();


        Student student = new Student(id,fn,ln,address,email,number,enrollmentDate);

        boolean s = false;

        try{

            s = studentBo.updateStudent(student);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (s){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Update Success").show();
        }else {

            new Alert(Alert.AlertType.ERROR,"Student Update UnSuccess").show();
        }

    }

    public void loadallvalues() throws SQLException {

        List<Student> allstudent = studentBo.getAllStudent();


        for (Student student : allstudent) {
            System.out.println(student.getId() + ": " + student.getFirstName() + " - " + student.getLastName() + " - " + student.getAddress() + " - " + student.getPhoneNumber() + " - " + student.getEmail() + " - " + student.getEnrollmentDate());
        }


        ObservableList<StudentTM> observableList = FXCollections.observableArrayList();

        for (int i = 0; i < allstudent.size(); i++) {
            StudentTM studentTM = new StudentTM(
                    allstudent.get(i).getId(),
                    allstudent.get(i).getFirstName(),
                    allstudent.get(i).getLastName(),
                    allstudent.get(i).getAddress(),
                    allstudent.get(i).getPhoneNumber(),
                    allstudent.get(i).getEmail(),
                    new JFXButton("delete"), new JFXButton("update")
            );

            observableList.add(studentTM);
        }

        StudentTable.setItems(observableList);

        for (int i = 0; i < observableList.size(); i++) {
            observableList.get(i).getUpdate().setStyle("-fx-background-color: rgba(16, 176, 72)");
            observableList.get(i).getUpdate().setPrefWidth(130);
            observableList.get(i).getUpdate().setPrefHeight(30);
            observableList.get(i).getUpdate().setCursor(Cursor.HAND);
            observableList.get(i).getDelete().setStyle("-fx-background-color: rgba(166, 7, 33)");
            observableList.get(i).getDelete().setCursor(Cursor.HAND);
            observableList.get(i).getDelete().setPrefWidth(120);
            observableList.get(i).getDelete().setPrefHeight(30);
            observableList.get(i).getUpdate().setTextFill(Color.WHITE);
            observableList.get(i).getDelete().setTextFill(Color.WHITE);
        }
        for (int i = 0; i < observableList.size(); i++) {
            int id = observableList.get(i).getId();
            observableList.get(i).getDelete().setOnAction(actionEvent -> {

                Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
                confirmDialog.setTitle("Confirm Deletion");
                confirmDialog.setHeaderText("Are you sure you want to delete this customer?");
                confirmDialog.setContentText("Press OK to confirm or Cancel to abort.");

                confirmDialog.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        //deleteCustomer
                        boolean deleted = studentBo.deleteStudent(id);
                        if (deleted) {
                            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                            successAlert.setTitle("Success");
                            successAlert.setHeaderText(null);
                            successAlert.setContentText("Customer Deleted Successfully");
                            successAlert.showAndWait();
                            // Reload values after successful deletion
                        } else {
                            // Handle deletion failure
                            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                            errorAlert.setTitle("Error");
                            errorAlert.setHeaderText(null);
                            errorAlert.setContentText("Failed to delete customer.");
                            errorAlert.showAndWait();
                        }
                        try {
                            loadallvalues();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            });

        }

    }
    public void setValues(){
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colfirstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        collastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colnumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        deletebtnrow.setCellValueFactory(new PropertyValueFactory<StudentTM, JFXButton>("Delete"));
        updatebtnrow.setCellValueFactory(new PropertyValueFactory<StudentTM, JFXButton>("Update"));

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setValues();
        try {
            loadallvalues();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
