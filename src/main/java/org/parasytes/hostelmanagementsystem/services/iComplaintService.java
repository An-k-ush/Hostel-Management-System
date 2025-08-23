package org.parasytes.hostelmanagementsystem.services;

import org.parasytes.hostelmanagementsystem.DTOs.ComplaintRequest;
import org.parasytes.hostelmanagementsystem.entities.Complaint;
import org.parasytes.hostelmanagementsystem.entities.ComplaintStatus;

import java.util.List;

public interface iComplaintService {

    void addComplaint(Long studentId, ComplaintRequest complaintRequest);

    Complaint updateComplaintStatus(Long complaintId, String status);

    void deleteComplaint(Long complaintId);

    Complaint getComplaintById(Long complaintId);

    List<Complaint> getAllComplaintsByStudentId(Long studentId);

    List<Complaint> getAllComplaintsByStatus(ComplaintStatus status);

    List<Complaint> getAllComplaints();


}
