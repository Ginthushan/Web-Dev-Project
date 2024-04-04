package com.hotelmanagement.controller;

import com.hotelmanagement.model.Room;
import com.hotelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    
    @GetMapping("/rooms")
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms";
    }

    @PostMapping("/rooms/add")
    public String addRoom(@RequestParam("room_number") String room_number,
                              @RequestParam("type") String type,
                              @RequestParam("price") String price) {
        Room room = new Room();
        room.setRoomNumber(room_number);
        room.setType(type);
        room.setPrice(price);

        // Save the new room to the database
        roomService.addRoom(room);
        return "redirect:/rooms";
    }

    
}