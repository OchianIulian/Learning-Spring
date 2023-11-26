package com.example.second_bkd_project.student;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name =  "student_sequence",
            sequenceName =  "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient//indicates that age field should not be persisted(saved) into database
    private Integer age;

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    @JsonIgnore
    public Integer getAge() {
        if (this.dob != null) {
            return Period.between(this.dob, LocalDate.now()).getYears();
        } else {
            // Handle the case when dob is null
            return null; // or return a default value, depending on your logic
        }
    }
}
