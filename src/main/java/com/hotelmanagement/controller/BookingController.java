package com.hotelmanagement.controller;

import com.hotelmanagement.model.Booking;
import com.hotelmanagement.model.Customer;
import com.hotelmanagement.model.Room;
import com.hotelmanagement.service.BookingService;
import com.hotelmanagement.service.CustomerService;
import com.hotelmanagement.service.RoomService;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final CustomerService customerService;
    private final RoomService roomService;

    @Autowired
    public BookingController(BookingService bookingService, CustomerService customerService, RoomService roomService) {
        this.bookingService = bookingService;
        this.customerService = customerService;
        this.roomService = roomService;
    }

    @GetMapping("/bookings")
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        System.out.println("Bookings: " + bookingService.getAllBookings());
        return "bookings";
    }

    // @GetMapping("/bookings/add")
    // public String showAddBookingForm(Model model) {
    //     model.addAttribute("booking", new Booking());
    //     return "add-booking";
    // }

    @PostMapping("/bookings/add")
    public String addBooking(@RequestParam("customerId") Long customerId,
                         @RequestParam("roomId") Long roomId,
                         @RequestParam("startDate") LocalDate startDate,
                         @RequestParam("endDate") LocalDate endDate) {
    Booking booking = new Booking();
    Customer customer = customerService.getCustomerById(customerId);
    Room room = roomService.getRoomById(roomId);

    booking.setCustomer(customer);
    booking.setRoom(room);
    booking.setStartDate(startDate);
    booking.setEndDate(endDate);

    bookingService.addBooking(booking);
    return "redirect:/bookings";
}

}
