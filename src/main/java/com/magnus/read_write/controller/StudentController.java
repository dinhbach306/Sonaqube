package com.magnus.read_write.controller;

import com.magnus.read_write.entity.Student;
import com.magnus.read_write.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<?> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(),
                null, HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(studentService.getStudentById(id),
                null, HttpStatus.OK);
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(Student student) {
        return new ResponseEntity<>(studentService.addStudent(student),
                null, HttpStatus.CREATED);
    }
}
