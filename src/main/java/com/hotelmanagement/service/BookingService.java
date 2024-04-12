// Provides services related to booking operations such as retrieving, adding, and deleting bookings.
package com.hotelmanagement.service;

import com.hotelmanagement.model.Booking;
import com.hotelmanagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

 // Retrieves all bookings from the database.
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

 // Retrieves a booking by its ID.
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

 // Adds a new booking to the database.
    public void addBooking(Booking booking) {
        bookingRepository.save(booking);
    }

 // Deletes a booking by its ID.
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

}