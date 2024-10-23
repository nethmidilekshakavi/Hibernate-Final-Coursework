package org.example.lk.ijse.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String firstName;
        private String lastName;

        private String address;

        @Column(unique = true)
        private String email;

/*
        @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
*/
        private String phoneNumber;

        private LocalDate enrollmentDate;

/*
        @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
*/
       /* private Set<Enrollment> enrollments = new HashSet<>();*/


    }


