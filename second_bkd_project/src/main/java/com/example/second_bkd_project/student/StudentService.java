package com.example.second_bkd_project.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(new Student(
                1L,
                "Andrei",
                "ochian_a@yahoo.ro",
                LocalDate.of(2000, Month.JANUARY, 6),
                21
        ));
    }
}
