package org.parasytes.hostelmanagementsystem.services;


import org.parasytes.hostelmanagementsystem.DTOs.StudentRequest;
import org.parasytes.hostelmanagementsystem.entities.Student;

import java.util.List;

public interface iStudentService {

    void addStudent(StudentRequest student, String username, String password);
    void updateStudent(Student student, Long studentId);
    void deleteStudent(Long studentId);

    Student getStudentById(Long studentId);
    Student getStudentByEmail(String email);
    Student getStudentByPhoneNumber(String phoneNumber);
    List<Student> getAllStudents();


}
