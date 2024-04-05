package com.hotelmanagement.controller;

import com.hotelmanagement.model.Room;
import com.hotelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms";
    }

    @PostMapping("/rooms/add")
    public String addRoom(@RequestParam("room_number") String roomNumber,
                          @RequestParam("type") String type,
                          @RequestParam("price") double price) {
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setType(type);
        room.setPrice(price);
        roomService.addRoom(room);
        return "redirect:/rooms";
    }

    @PostMapping("/rooms/delete")
    public String deleteRoom(@RequestParam("roomId") long roomId) {
        roomService.deleteRoom(roomId);
        return "redirect:/rooms";
    }
}
