package org.example.lk.ijse.DTO.TM;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserTM extends org.example.lk.ijse.Controller.UserForm {

    private  int userID;
    private  String UserName;
    private String UserPassword;
    private  String UserRole;
    private JFXButton delete;
    private JFXButton update;
}
