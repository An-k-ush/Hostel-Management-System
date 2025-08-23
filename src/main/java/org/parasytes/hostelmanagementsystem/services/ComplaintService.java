package org.parasytes.hostelmanagementsystem.services;

import org.parasytes.hostelmanagementsystem.DTOs.ComplaintRequest;
import org.parasytes.hostelmanagementsystem.entities.Complaint;
import org.parasytes.hostelmanagementsystem.entities.ComplaintStatus;
import org.parasytes.hostelmanagementsystem.exceptions.ComplaintNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.parasytes.hostelmanagementsystem.repositories.ComplaintRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintService implements iComplaintService{

    private final ComplaintRepo complaintRepo;

    @Override
    public void addComplaint(Long studentId, ComplaintRequest complaintRequest) {

    }

    @Override
    public Complaint getComplaintById(Long complaintId) {
        return complaintRepo.findById(complaintId)
                .orElseThrow(
                () -> new ComplaintNotFoundException("Complaint with ID " + complaintId + " not found")
        );
    }

    @Override
    public Complaint updateComplaintStatus(Long complaintId, String status) {
        Complaint complaint = getComplaintById(complaintId);
        complaint.setStatus(status);
        return complaintRepo.save(complaint);
    }

    @Override
    public void deleteComplaint(Long complaintId) {
        complaintRepo.findById(complaintId)
                .ifPresentOrElse(complaintRepo::delete, () -> {
                    throw new ComplaintNotFoundException("Complaint with ID " + complaintId + " not found");}
                );
    }


    @Override
    public List<Complaint> getAllComplaintsByStudentId(Long studentId) {
        return complaintRepo.findAllByStudentId(studentId);
    }

    @Override
    public List<Complaint> getAllComplaintsByStatus(ComplaintStatus status) {
        return complaintRepo.findAllByComplaintStatus(status);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepo.findAll();
    }
}
