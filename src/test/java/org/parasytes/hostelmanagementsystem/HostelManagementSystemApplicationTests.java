package org.parasytes.hostelmanagementsystem;

import org.parasytes.hostelmanagementsystem.DTOs.StudentRequest;
import org.junit.jupiter.api.Test;
import org.parasytes.hostelmanagementsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.parasytes.hostelmanagementsystem.services.StudentService;


@SpringBootTest
class HostelManagementSystemApplicationTests {
    StudentService studentService;
    UserService userService;

    @Autowired
    public HostelManagementSystemApplicationTests(StudentService studentService, UserService userService) {
        this.studentService = studentService;
        this.userService = userService;
    }

    @Test
    void contextLoads() {
        StudentRequest s1 = new StudentRequest();
        s1.setName("John Doe");
        s1.setEmail("johndoe11@gmail.com");
        s1.setPhoneNumber("1234567890");
        s1.setAddress("123 Main St, Cityville");
        studentService.addStudent(s1, "johndoe11", "password123");
        studentService.getAllStudents().forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        System.out.println(userService.getUserById(1L).getStudent().getAddress());

    }

}
