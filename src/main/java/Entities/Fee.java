package Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private LocalDate dueDate;

    private LocalDate paidDate;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
