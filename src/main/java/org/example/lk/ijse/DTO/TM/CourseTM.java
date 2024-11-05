package org.example.lk.ijse.DTO.TM;
import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.lk.ijse.Controller.CourseController;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseTM extends CourseController {
    private String ProgramID;
    private String ProgramName;
    private double fee;
    private String Duration;
    private JFXButton delete;
    private JFXButton update;


}
