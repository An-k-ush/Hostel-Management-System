package Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String roomNumber;

    @Column(nullable = false)
    private String type; // Single, Double, Triple

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private int currentOccupancy;

    @Column(nullable = false)
    private String status; // Available, Occupied, Maintenance

    @OneToMany(mappedBy = "room")
    List<Student> students;

}
