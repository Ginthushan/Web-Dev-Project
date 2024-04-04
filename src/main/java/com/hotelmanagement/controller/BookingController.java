package com.hotelmanagement.controller;

import com.hotelmanagement.model.Booking;
import com.hotelmanagement.model.Customer;
import com.hotelmanagement.service.BookingService;
import com.hotelmanagement.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookingController {

    private final BookingService bookingService;
    private final CustomerService customerService;

    @Autowired
    public BookingController(BookingService bookingService, CustomerService customerService) {
        this.bookingService = bookingService;
        this.customerService = customerService;
    }

    @GetMapping("/bookings")
    public String getAllBookings(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        // System.out.println("Bookings: " + bookings);
        return "bookings";
    }

    @GetMapping("/bookings/add")
    public String showAddBookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        return "add-booking";
    }

    @PostMapping("/bookings/add")
    public String addBooking(@ModelAttribute("booking") Booking booking, @RequestParam("customerId") Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        booking.setCustomer(customer);
        bookingService.addBooking(booking);
        return "redirect:/bookings";
    }
}
