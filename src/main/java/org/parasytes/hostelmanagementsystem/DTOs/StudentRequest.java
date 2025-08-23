package org.parasytes.hostelmanagementsystem.DTOs;

import org.parasytes.hostelmanagementsystem.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentRequest {
    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String address;

    @NotNull
    private User user;
}
