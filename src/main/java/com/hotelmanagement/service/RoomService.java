// Provides services related to room operations such as retrieving, adding, and deleting rooms.
package com.hotelmanagement.service;

import com.hotelmanagement.model.Room;
import com.hotelmanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

 // Retrieves all rooms from the database.
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

 // Retrieves a room by its ID.
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

 // Adds a new room to the database.
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

 // Deletes a room by its ID.
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
