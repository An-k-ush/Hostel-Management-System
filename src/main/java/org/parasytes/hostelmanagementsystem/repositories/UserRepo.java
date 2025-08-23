package org.parasytes.hostelmanagementsystem.repositories;

import org.parasytes.hostelmanagementsystem.entities.Role;
import org.parasytes.hostelmanagementsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

    List<User> findAllByRole(Role roleName);
}
