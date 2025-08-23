package org.parasytes.hostelmanagementsystem.services;


import lombok.RequiredArgsConstructor;
import org.parasytes.hostelmanagementsystem.entities.Role;
import org.parasytes.hostelmanagementsystem.entities.User;
import org.parasytes.hostelmanagementsystem.exceptions.UserNotFoundException;
import org.parasytes.hostelmanagementsystem.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements iUserService {
    private final UserRepo userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException("User not found with username: " + username));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllStudent() {
        return userRepository.findAllByRole(Role.STUDENT);
    }

    @Override
    public List<User> getAllStaff() {
        return userRepository.findAllByRole(Role.STAFF);
    }

}
