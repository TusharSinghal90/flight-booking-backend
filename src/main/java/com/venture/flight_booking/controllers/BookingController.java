package com.venture.flight_booking.controllers;

import com.venture.flight_booking.entities.Booking;
import com.venture.flight_booking.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/{flightId}")
    public Booking bookFlight(@PathVariable Long flightId, @RequestBody Booking booking){
       return bookingService.bookFlight(flightId, booking);
    }


}
