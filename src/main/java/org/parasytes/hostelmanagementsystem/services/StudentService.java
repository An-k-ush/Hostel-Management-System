package org.parasytes.hostelmanagementsystem.services;


import org.parasytes.hostelmanagementsystem.DTOs.StudentRequest;
import org.parasytes.hostelmanagementsystem.entities.Role;
import org.parasytes.hostelmanagementsystem.entities.Student;
import org.parasytes.hostelmanagementsystem.entities.User;
import org.parasytes.hostelmanagementsystem.exceptions.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.parasytes.hostelmanagementsystem.mappers.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.parasytes.hostelmanagementsystem.repositories.StudentRepo;
import org.parasytes.hostelmanagementsystem.repositories.UserRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements iStudentService {
    private final StudentRepo studentRepository;
    private final UserRepo userRepo;

    @Override
    @Transactional
    public void addStudent(StudentRequest student, String username, String password) {

        Student newStudent = StudentMapper.mapToStudent(student);
        if (newStudent == null)
            throw new IllegalArgumentException("Invalid student data");
        if (studentRepository.existsByEmail(newStudent.getEmail()))
            throw new IllegalArgumentException("Email already exists");
        if (studentRepository.existsByPhoneNumber(newStudent.getPhoneNumber()))
            throw new IllegalArgumentException("Phone number already exists");
        if(userRepo.existsByUsername(username))
            throw new IllegalArgumentException("Username already exists");
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(Role.STUDENT);
        newStudent.setUser(newUser);
        studentRepository.save(newStudent);
    }

    @Override
    public void updateStudent(Student student, Long studentId) {

    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.findById(studentId).ifPresentOrElse(studentRepository::delete, () -> {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found");
        });
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + studentId + " not found"));
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student getStudentByPhoneNumber(String phoneNumber) {
        return studentRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
