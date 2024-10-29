package org.example.lk.ijse.DTO.TM;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.lk.ijse.Controller.StudentController;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentTM extends StudentController {

    private int id;
    private  String FirstName;
    private  String LastName;
    private  String PhoneNumber;
    private  String address;
    private String email;

    private JFXButton delete;
    private JFXButton update;



}
