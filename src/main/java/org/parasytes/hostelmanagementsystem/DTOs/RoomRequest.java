package org.parasytes.hostelmanagementsystem.DTOs;

import org.parasytes.hostelmanagementsystem.entities.RoomStatus;
import org.parasytes.hostelmanagementsystem.entities.RoomType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoomRequest {
    @NotNull
    private String roomNumber;

    @NotNull
    private RoomType roomType;

    @NotNull
    @Min(value = 1, message = "Minimum capacity should be at least 1")
    @Max(value = 3, message = "Maximum capacity should not be greater than 3")
    private Integer capacity;

    @NotNull
    private RoomStatus roomStatus;
}
