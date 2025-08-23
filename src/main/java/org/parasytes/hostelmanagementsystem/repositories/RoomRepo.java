package org.parasytes.hostelmanagementsystem.repositories;

import org.parasytes.hostelmanagementsystem.entities.Room;
import org.parasytes.hostelmanagementsystem.entities.RoomStatus;
import org.parasytes.hostelmanagementsystem.entities.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepo extends JpaRepository<Room, Long> {
    Room findByRoomNumber(String roomNumber);

    List<Room> findAllByStatus(RoomStatus status);

    List<Room> findByCapacity(Integer capacity);

    List<Room> findAllByType(RoomType type);
}
