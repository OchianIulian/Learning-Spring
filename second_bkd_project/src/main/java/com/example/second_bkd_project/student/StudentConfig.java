package com.example.second_bkd_project.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student student1 = new Student(
                    1L,
                    "Mariam",
                    "ochian_a@yahoo.ro",
                    LocalDate.of(2000, JANUARY, 5)
            );

            Student student2 = new Student(
                    2L,
                    "Adrian",
                    "lalabenz@yahoo.ro",
                    LocalDate.of(2003, JANUARY, 6)
            );

            repository.saveAll(List.of(student1, student2));
        };
    }
}
