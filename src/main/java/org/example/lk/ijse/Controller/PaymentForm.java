package org.example.lk.ijse.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.example.lk.ijse.BO.BOFactory;
import org.example.lk.ijse.BO.custom.CourseBO;
import org.example.lk.ijse.BO.custom.RegistrationBO;
import org.example.lk.ijse.BO.custom.StudentBo;
import org.example.lk.ijse.DAO.DaoFactory;
import org.example.lk.ijse.DAO.cutom.RegistrationDao;
import org.example.lk.ijse.DTO.TM.RegistrationTM;
import org.example.lk.ijse.Entity.Course;
import org.example.lk.ijse.Entity.Registration;
import org.example.lk.ijse.Entity.Student;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PaymentForm implements Initializable {

    @FXML
    private TableColumn<?, ?> deleteBtn;
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
    private TableView<?> StudentTable;

    @FXML
    private TableColumn<?, ?> colPayment;

    @FXML
    private TableColumn<?, ?> colcid;

    @FXML
    private TableColumn<?, ?> colcname;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> coldueAmonut;

    @FXML
    private TableColumn<?, ?> colduration;

    @FXML
    private TableColumn<?, ?> colsid;

    @FXML
    private TableColumn<?, ?> colsname;

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


    RegistrationBO registrationBO = (RegistrationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTRATION);



    @FXML
    void RegisterComfirmOnAction(ActionEvent event) {

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
}
