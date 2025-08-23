package org.parasytes.hostelmanagementsystem.DTOs;


import org.parasytes.hostelmanagementsystem.entities.ComplaintStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class ComplaintRequest {
    @NotNull
    private String title;

    @NotNull
    private String description;

    private LocalDate date = LocalDate.now();

    private ComplaintStatus complaintStatus = ComplaintStatus.OPEN;

    public void setStatus(String status) {
        complaintStatus = ComplaintStatus.valueOf(status);
    }
}
