package org.parasytes.hostelmanagementsystem.mappers;

import org.parasytes.hostelmanagementsystem.DTOs.RoomRequest;
import org.parasytes.hostelmanagementsystem.entities.Room;

public class RoomMapper {
    public static Room mapRoomRequest(RoomRequest roomRequest) {
        Room room = new Room();
        room.setRoomNumber(roomRequest.getRoomNumber());
        room.setCapacity(roomRequest.getCapacity());
        room.setStatus(roomRequest.getRoomStatus());
        room.setType(roomRequest.getRoomType());
        return room;
    }
}
