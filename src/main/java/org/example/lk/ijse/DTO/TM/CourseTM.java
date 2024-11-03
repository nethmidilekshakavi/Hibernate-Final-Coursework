package org.example.lk.ijse.DTO.TM;
import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseTM extends org.example.lk.ijse.Controller.CourseForm {

    private int id;
    private String ProgramID;
    private String ProgramName;
    private double fee;
    private String Duration;
    private JFXButton delete;
    private JFXButton update;


}
