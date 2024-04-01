package com.hotelmanagement.controller;

import com.hotelmanagement.model.Room;
import com.hotelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    
    @GetMapping("/rooms")
    public String viewHomePage(Model model) {
        model.addAttribute("Rooms", roomService.getAllRooms());
        return "rooms";
    }

    
}