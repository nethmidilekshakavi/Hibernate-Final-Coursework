package org.example.lk.ijse.Controller;

import com.jfoenix.controls.JFXButton;
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
import org.example.lk.ijse.BO.custom.RegistrationBO;
import org.example.lk.ijse.DTO.TM.RegistrationTM;
import org.example.lk.ijse.Entity.Course;
import org.example.lk.ijse.Entity.Registration;
import org.example.lk.ijse.Entity.Student;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

    @FXML
    private TableColumn<RegistrationTM, JFXButton> deleteBtn;
    @FXML
    private Text Amountduetxt;

    @FXML
    private Text CourseDuration;

    @FXML
    private TextField Paymenttxt;

    @FXML
    private AnchorPane RegistaionFome;

    @FXML
    private Text RegistationNumbertxt;

    @FXML
    private Text RegistertaionNumber;

    @FXML
    private ComboBox<Integer> StudentIDComboBox;

    @FXML
    private ComboBox<String> StudentIDComboCourseComboBox;

    @FXML
    private TableView<RegistrationTM> StudentTable;

    @FXML
    private TableColumn<Double, RegistrationTM> colPayment;

    @FXML
    private TableColumn<String, RegistrationTM> colcid;


    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<Double, RegistrationTM> coldueAmonut;

    @FXML
    private TableColumn<String, RegistrationTM> colduration;

    @FXML
    private TableColumn<Integer, RegistrationTM> colsid;

    @FXML
    private TableColumn<String, RegistrationTM> colsname;

    @FXML
    private Text courseName;

    @FXML
    private Text courseid;

    @FXML
    private DatePicker datecombo;

    @FXML
    private Text fee;

    @FXML
    private Text payment;

    @FXML
    private Text payment1;

    @FXML
    private Text registaionNOtxt;

    @FXML
    private Text studentMobile;

    @FXML
    private Text studentName;

    @FXML
    private Text studentdetails;

    @FXML
    private Text studentid;

    @FXML
    private Text topic;

    @FXML
    private TableColumn<String, RegistrationTM> colProgram;

    RegistrationBO registrationBO = (RegistrationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTRATION);

    @FXML
    void RegisterComfirmOnAction(ActionEvent event) {
        try {
            Long id = 0L;
            Integer studentId = StudentIDComboBox.getValue();
            String courseId = StudentIDComboCourseComboBox.getValue();
            String studentFName = studentName.getText();
            String courseFullName = courseName.getText();
            String courseDuration = CourseDuration.getText();
            double payment = Double.parseDouble(Paymenttxt.getText());
            double totalFee = Double.parseDouble(fee.getText());
            double dueAmount = totalFee - payment; //due Amount

            Amountduetxt.setText(String.valueOf(dueAmount));

            LocalDate date = datecombo.getValue();

            // Load  Student and Course entities from the database
            Student student = registrationBO.serachbyIDS(studentId);
            Course course = registrationBO.serachbyCIDs(courseId);

            if (student == null) {
                new Alert(Alert.AlertType.ERROR, "Student not found!").show();
                return;
            }
            if (course == null) {
                new Alert(Alert.AlertType.ERROR, "Course not found!").show();
                return;
            }


            Registration registration = new Registration(
                    id, date, payment, dueAmount, studentFName, courseFullName, courseDuration, student, course
            );

            //save
            boolean isSaved = registrationBO.saveRegistration(registration);

            if (!isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Registration saved successfully!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to save registration.").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void loadallvalues() throws SQLException, IOException {

        List<Registration> alldetails = registrationBO.getAllRegistrationDetails();


        for (Registration registration : alldetails) {
        }


        ObservableList<RegistrationTM> observableList = FXCollections.observableArrayList();

        for (int i = 0; i < alldetails.size(); i++) {
            RegistrationTM registrationTM = new RegistrationTM(
                    alldetails.get(i).getStudent().getId(),
                    alldetails.get(i).getStudentName(),
                    alldetails.get(i).getCourse().getProgramId(),
                    alldetails.get(i).getCourse().getProgramName(),
                    alldetails.get(i).getEnrollmentDate(),
                    alldetails.get(i).getDuration(),
                    alldetails.get(i).getPayment(),
                    alldetails.get(i).getDueAmount(),
                    new JFXButton("delete")
            );

            observableList.add(registrationTM);
        }

        StudentTable.setItems(observableList);

    }

    public void setValues(){
        colsid.setCellValueFactory(new PropertyValueFactory<>("sid"));
        colsname.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colcid.setCellValueFactory(new PropertyValueFactory<>("courseid"));
        colProgram.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colduration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colPayment.setCellValueFactory(new PropertyValueFactory<>("payment"));
        coldueAmonut.setCellValueFactory(new PropertyValueFactory<>("dueAmount"));
        deleteBtn.setCellValueFactory(new PropertyValueFactory<RegistrationTM, JFXButton>("Delete"));


    }



    @FXML
    void clearOnActionRegistaion(ActionEvent event) {

    }

    private void getStudentIds() {
        try {
            List<Student> allstu = registrationBO.getAllStudent();
            for (Student s : allstu) {

                boolean b = StudentIDComboBox.getItems().add(s.getId());
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getProgramID() {
        try {
            List<Course> allprogramID = registrationBO.getAllCourse();
            for (Course c : allprogramID) {

                boolean b = StudentIDComboCourseComboBox.getItems().add(c.getProgramId());
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getProgramID();
        getStudentIds();
        try {
            loadallvalues();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        setValues();

    }

    //set Customer Details
    public void comboStudetList(ActionEvent actionEvent) {

        Integer sid = StudentIDComboBox.getValue();
        try{
            Student student = registrationBO.serachbyIDS(sid);
                studentName.setText(student.getFirstName());
            System.out.printf(student.getFirstName());
                studentMobile.setText(student.getPhoneNumber());

        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    //set Course Details
    public void comboCourseList(ActionEvent actionEvent) {

        String cid = StudentIDComboCourseComboBox.getValue();
        try{
            Course course = registrationBO.serachbyCIDs(cid);
           courseName.setText(course.getProgramName());
           fee.setText(String.valueOf(course.getFee()));
           CourseDuration.setText(course.getDuration());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void clearTextFiled(){


    }
}