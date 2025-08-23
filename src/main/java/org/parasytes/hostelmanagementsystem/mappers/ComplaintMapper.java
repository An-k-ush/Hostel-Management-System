package org.parasytes.hostelmanagementsystem.mappers;


import org.parasytes.hostelmanagementsystem.DTOs.ComplaintRequest;
import org.parasytes.hostelmanagementsystem.entities.Complaint;

public class ComplaintMapper {

    public static Complaint mapToComplaint(ComplaintRequest complaintRequest) {
        if (complaintRequest == null) return null;
        Complaint complaint = new Complaint();
        complaint.setDescription(complaintRequest.getDescription());
        complaint.setTitle(complaintRequest.getTitle());
        complaint.setDate(complaintRequest.getDate());
        complaint.setStatus(String.valueOf(complaintRequest.getComplaintStatus()));
        return complaint;
    }

}
