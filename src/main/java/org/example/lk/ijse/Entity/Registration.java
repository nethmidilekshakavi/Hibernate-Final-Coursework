package org.example.lk.ijse.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate enrollmentDate;

    private Double payment;

    private Double dueAmount;

    private String studentName;

    private String programName;

    private String duration;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "program_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "registration", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> paymentList = new ArrayList<>();


    public Registration(Long id, Double dueAmount) {
        this.id = id;
        this.dueAmount = dueAmount;
    }
    public void updateDueAmount(Double paymentAmount) {
        if (dueAmount != null) {
            this.dueAmount -= paymentAmount;
        }
    }
}



