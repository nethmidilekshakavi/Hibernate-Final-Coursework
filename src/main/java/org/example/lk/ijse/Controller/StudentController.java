package org.example.lk.ijse.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
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

    StudentBo studentBo = (StudentBo) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);


    @FXML
    void clearOnActionStudent(ActionEvent event) {

    }

    @FXML
    void deleteOnActionStudent(ActionEvent event) {
        int id = Integer.parseInt(idtxt.getText());

        boolean s = false;

        s = studentBo.deleteStudent(id);


        if (s){
            new Alert(Alert.AlertType.ERROR,"Student not delete").show();
        }
        else {
            new Alert(Alert.AlertType.CONFIRMATION,"Student delete Success").show();

        }
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
            System.out.println(student.getId() + ": " + student.getFirstName() + " - " + student.getLastName() + " - " + student.getAddress() + " - " + student.getPhoneNumber() + " - " + student.getEmail() + " - " + student.getEnrollmentDate() );
        }


        ObservableList<StudentTM> observableList = FXCollections.observableArrayList();

        for (int i = 0; i < allstudent.size(); i++) {
            StudentTM studentTM = new StudentTM(
                    allstudent.get(i).getId(),
                    allstudent.get(i).getFirstName(),
                    allstudent.get(i).getLastName(),
                    allstudent.get(i).getAddress(),
                    allstudent.get(i).getPhoneNumber(),
                    allstudent.get(i).getEmail()
            );

            observableList.add(studentTM);
        }

        StudentTable.setItems(observableList);
    }


    public void setValues(){
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colfirstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        collastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colnumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));

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
