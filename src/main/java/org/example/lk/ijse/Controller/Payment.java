package org.example.lk.ijse.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.example.lk.ijse.BO.BOFactory;
import org.example.lk.ijse.BO.custom.RegistrationBO;
import org.example.lk.ijse.Entity.Registration;
import org.example.lk.ijse.Entity.Student;

import java.util.List;

public class Payment {

    RegistrationBO registrationBO = (RegistrationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTRATION);


    @FXML
    private Text Amountduetxt;

    @FXML
    private Text DuePaymenttxt;

    @FXML
    private Text Paidtxt;

    @FXML
    private TextField Paymenttxt;

    @FXML
    private AnchorPane RegistaionFome;

    @FXML
    private ComboBox<Long> RegistationList;

    @FXML
    private Text RegistationNumbertxt;

    @FXML
    private TableView<?> RegisterTable;

    @FXML
    private TableColumn<?, ?> colPayment;

    @FXML
    private TableColumn<?, ?> colProgram;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> coldueAmonut;

    @FXML
    private TableColumn<?, ?> colsid;

    @FXML
    private TableColumn<?, ?> colsname;

    @FXML
    private Text courseName;

    @FXML
    private DatePicker datecombo;

    @FXML
    private TableColumn<?, ?> deleteBtn;

    @FXML
    private Text dueammunttxtPayment;

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
    private Text text1;

    @FXML
    private Text text11;

    @FXML
    private Text text2;

    @FXML
    private Text text21;

    @FXML
    private Text topic;

    @FXML
    void PaymentCombo(ActionEvent event) {

            Long rid = RegistationList.getValue();
            try{
                Registration registration = registrationBO.serachbyRID(rid);
                studentName.setText(registration.getStudentName());
                System.out.printf(registration.getProgramName());
                dueammunttxtPayment.setText(String.valueOf(registration.getDueAmount()));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    @FXML
    void PaymentOnAction(ActionEvent event) {

    }

    @FXML
    void clearOnActionRegistaion(ActionEvent event) {

    }

    private void getRegistationIDS() {
        try {
            List<Registration> allRegistation = registrationBO.getAllRegistrationDetails();
            for (Registration r : allRegistation) {

                boolean b = RegistationList.getItems().add(r.getId());
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

}
