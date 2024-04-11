package com.hotelmanagement.controller;

import com.hotelmanagement.model.Booking;
import com.hotelmanagement.model.Customer;
import com.hotelmanagement.model.ProvidedService;
import com.hotelmanagement.model.Room;
import com.hotelmanagement.service.BookingService;
import com.hotelmanagement.service.CustomerService;
import com.hotelmanagement.service.RoomService;
import com.hotelmanagement.service.ProvidedServiceService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private final ProvidedServiceService providedServiceService;

    @Autowired
    public BookingController(BookingService bookingService, CustomerService customerService, RoomService roomService, ProvidedServiceService providedServiceService) {
        this.bookingService = bookingService;
        this.customerService = customerService;
        this.roomService = roomService;
        this.providedServiceService = providedServiceService;
    }

    @GetMapping("/bookings")
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "bookings";
    }

    @PostMapping("/bookings/add")
    public String addBooking(@RequestParam("customerId") Long customerId,
                         @RequestParam("roomId") Long roomId,
                         @RequestParam("startDate") LocalDate startDate,
                         @RequestParam("endDate") LocalDate endDate,
                         @RequestParam(value = "provServiceId", required = false) String provServiceIds){
    Booking booking = new Booking();
    Customer customer = customerService.getCustomerById(customerId);
    Room room = roomService.getRoomById(roomId);

    booking.setCustomer(customer);
    booking.setRoom(room);
    booking.setStartDate(startDate);
    booking.setEndDate(endDate);

    // Process provided service IDs
    List<Long> providedServiceIds = Arrays.asList(provServiceIds.split(",")).stream()
                                    .map(Long::parseLong)
                                    .collect(Collectors.toList());

    List<ProvidedService> providedServices = new ArrayList<>();

    // Fetch provided services by IDs and add them to the list
    for (Long id : providedServiceIds) {
        ProvidedService providedService = providedServiceService.getProvidedServiceById(id);
        if (providedService != null) {
            providedServices.add(providedService);
            providedService.setBooking(booking); // Associate the provided service with the booking
        }
    }

    // Set the list of provided services for the booking
    booking.setProvidedServices(providedServices);

    // Check if the booking is active based on the current date
    LocalDate today = LocalDate.now();
    boolean isActive = today.isEqual(startDate) || (today.isAfter(startDate) && today.isBefore(endDate));
    booking.setIsActive(isActive);

    bookingService.addBooking(booking);
    return "redirect:/bookings";
    }
    
    @PostMapping("/bookings/delete")
    public String deleteBooking(@RequestParam("bookingId") Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return "redirect:/bookings";
    }

}
