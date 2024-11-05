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
import org.example.lk.ijse.BO.custom.StudentBo;
import org.example.lk.ijse.DAO.DaoFactory;

public class PaymentForm {

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
    private ComboBox<?> StudentIDComboBox;

    @FXML
    private ComboBox<?> StudentIDComboCourseComboBox;

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




    @FXML
    void RegisterComfirmOnAction(ActionEvent event) {

    }

    @FXML
    void clearOnActionRegistaion(ActionEvent event) {

    }

    //getAllCustomerID
/*    private void getStudentIds() {
        try {
            ArrayList<Student> allstu = (ArrayList<Student>) studentBo.getAllIDs();
            for (CustomerModel c : allcus) {
                nicList.getItems().add(String.valueOf(c.getC_ID()));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }*/

}
