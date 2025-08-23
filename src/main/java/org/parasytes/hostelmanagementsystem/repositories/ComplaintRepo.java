package org.parasytes.hostelmanagementsystem.repositories;

import org.parasytes.hostelmanagementsystem.entities.Complaint;
import org.parasytes.hostelmanagementsystem.entities.ComplaintStatus;
import org.parasytes.hostelmanagementsystem.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepo extends JpaRepository<Complaint, Long> {

    List<Complaint> student(Student student);

    List<Complaint> findAllByStudentId(Long studentId);

    List<Complaint> findAllByComplaintStatus(ComplaintStatus complaintStatus);
}
