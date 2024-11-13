package org.example.lk.ijse.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.lk.ijse.Entity.Registration;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDto {


    private Long id;
    private Long rid;
    private LocalDate enrollmentDate;
    private Double payment;
    private Double dueAmount;
    private String studentName;
    private String programName;
    private Double duePayment;

}
