package org.example.lk.ijse.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistrationDto {

    private Long id;

    private LocalDate enrollmentDate;

    private Double Payment;

    private Double DueAmount;

    private String studentName;

    private String ProgramName;

    private String duration;


    public RegistrationDto(Long id, Double dueAmount, Session session) {
        this.id = id;

    }
}
