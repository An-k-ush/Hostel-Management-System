package org.parasytes.hostelmanagementsystem.services;

import org.parasytes.hostelmanagementsystem.entities.User;

import java.util.List;

public interface iUserService {

    User getUserById(Long id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    List<User> getAllStudent();
    List<User> getAllStaff();
}
