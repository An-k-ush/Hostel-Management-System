package Entities;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
public class Complaints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDate date;
    private String status; // Open, Closed, InProgress

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
