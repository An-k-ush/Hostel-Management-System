package org.parasytes.hostelmanagementsystem.mappers;

import org.parasytes.hostelmanagementsystem.DTOs.StudentRequest;
import org.parasytes.hostelmanagementsystem.entities.Student;

public class StudentMapper {
    public static Student mapToStudent(StudentRequest studentRequest) {
        if(studentRequest == null) return null;
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setAddress(studentRequest.getAddress());
        return student;
    }
}
