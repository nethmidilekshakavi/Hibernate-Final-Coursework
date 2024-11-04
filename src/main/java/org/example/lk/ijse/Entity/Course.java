package org.example.lk.ijse.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "courses")
public class Course {

        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Id
        private String programId;

        private String programName;

        private String duration;

        private double fee;


      /*  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Registration> registrations = new HashSet<>();*/

}
