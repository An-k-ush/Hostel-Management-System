package org.parasytes.hostelmanagementsystem.services;

import org.parasytes.hostelmanagementsystem.DTOs.RoomRequest;
import org.parasytes.hostelmanagementsystem.entities.Room;
import org.parasytes.hostelmanagementsystem.entities.RoomStatus;
import org.parasytes.hostelmanagementsystem.entities.RoomType;
import org.parasytes.hostelmanagementsystem.exceptions.RoomAlreadyExist;
import org.parasytes.hostelmanagementsystem.exceptions.RoomNotFoundException;
import lombok.RequiredArgsConstructor;
import org.parasytes.hostelmanagementsystem.mappers.RoomMapper;
import org.springframework.stereotype.Service;
import org.parasytes.hostelmanagementsystem.repositories.RoomRepo;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RoomService implements iRoomService {
    private final RoomRepo roomRepository;

    @Override
    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room with ID " + roomId + " not found"));
    }
    @Override
    public void updateRoom(RoomRequest roomRequest, Long roomId) {

    }

    @Override
    public void deleteRoom(Long roomId) {
        roomRepository.findById(roomId).ifPresentOrElse(roomRepository::delete, () -> {
            throw new RoomNotFoundException("Room with ID " + roomId + " not found.");
        });
    }

    @Override
    public Room getRoomByNumber(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    @Override
    public void addRoom(RoomRequest roomRequest) {
        if(roomRepository.findByRoomNumber(roomRequest.getRoomNumber()) != null)
            throw new RoomAlreadyExist("Room with RoomNumber "+ roomRequest.getRoomNumber() + "already exist.");
        roomRepository.save(RoomMapper.mapRoomRequest(roomRequest));
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public List<Room> getRoomsByType(RoomType type) {
        return roomRepository.findAllByType(type);
    }

    @Override
    public List<Room> getAvailableRooms() {
        return roomRepository.findAllByStatus(RoomStatus.AVAILABLE);
    }

    @Override
    public List<Room> getRoomsByStatus(RoomStatus status) {
        return roomRepository.findAllByStatus(status);
    }

    @Override
    public List<Room> getRoomsByCapacity(Integer capacity) {
        return roomRepository.findByCapacity(capacity);
    }
}
