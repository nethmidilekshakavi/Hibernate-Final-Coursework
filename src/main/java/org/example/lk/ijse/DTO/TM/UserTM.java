package org.example.lk.ijse.DTO.TM;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.lk.ijse.Controller.UserController;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserTM extends UserController {

    private  int userID;
    private  String UserName;
    private String UserPassword;
    private  String UserRole;
    private JFXButton delete;
    private JFXButton update;
}
