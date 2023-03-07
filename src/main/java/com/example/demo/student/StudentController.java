package com.example.demo.student;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/hello")
    @ResponseBody
    public List<Student> hello(){
        return List.of(
                new Student(
                        1L,
                        "Pratima Karki",
                        "Pratima.Karki.2014@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        21
                )
        );
    }

    @PostMapping(value = "/insert")
    @ResponseBody
    public String putStudent() {
        Student student = new Student("Apil Tamang", "apil.tamang@gmail.com", LocalDate.of(2000, Month.JANUARY, 5), 32);
        studentRepository.saveStudent(student);
        return "done!";
    }
}
