package org.parasytes.hostelmanagementsystem.repositories;

import org.parasytes.hostelmanagementsystem.entities.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeRepo extends JpaRepository<Fee, Long> {
}
