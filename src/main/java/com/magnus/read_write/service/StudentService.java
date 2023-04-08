package com.magnus.read_write.service;

import com.magnus.read_write.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private static final Student[] students = {
            new Student(1, "Dinh Dinh", 22, "Viet Nam"),
            new Student(2, "Nguyễn Hữu Phúc", 18, "Viet Nam"),
            new Student(3, "Phạm Quang Đạt", 23, "UK")};

    public Student[] getStudents() {
        return students;
    }

    public Student getStudentById(Integer id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        throw new RuntimeException("Student not found");
    }

    public String addStudent(Student student) {
        for (Student student1 : students) {
            if (student1.getId().equals(student.getId())) {
                throw new RuntimeException("Student already exists");
            }
        }
        return "Student is created successfully";
    }
}
