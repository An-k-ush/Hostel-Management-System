package org.parasytes.hostelmanagementsystem.services;

import org.parasytes.hostelmanagementsystem.DTOs.RoomRequest;
import org.parasytes.hostelmanagementsystem.entities.Room;
import org.parasytes.hostelmanagementsystem.entities.RoomStatus;
import org.parasytes.hostelmanagementsystem.entities.RoomType;

import java.util.List;

public interface iRoomService {
    void addRoom(RoomRequest roomRequest);
    void updateRoom(RoomRequest roomRequest, Long roomId);
    void deleteRoom(Long roomId);

    Room getRoomById(Long roomId);
    Room getRoomByNumber(String roomNumber);
    List<Room> getAllRooms();
    List<Room> getRoomsByType(RoomType type);
    List<Room> getAvailableRooms();
    List<Room> getRoomsByStatus(RoomStatus status);
    List<Room> getRoomsByCapacity(Integer capacity);
}
