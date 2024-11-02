package org.example.lk.ijse.DTO.TM;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserTM extends org.example.lk.ijse.Controller.UserForm {

    private  Long userID;
    private  String UserName;
    private  String UserRole;
    private String UserPassword;
    private JFXButton delete;
    private JFXButton update;
}
