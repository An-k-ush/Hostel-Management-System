package org.parasytes.hostelmanagementsystem.repositories;

import org.parasytes.hostelmanagementsystem.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepo extends JpaRepository<Staff, Long> {
}
