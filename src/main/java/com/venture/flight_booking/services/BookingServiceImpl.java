package com.venture.flight_booking.services;

import com.venture.flight_booking.entities.Booking;
import com.venture.flight_booking.entities.Flight;
import com.venture.flight_booking.repositories.BookingRepository;
import com.venture.flight_booking.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    public Booking bookFlight(Long flightId, Booking booking){
        Flight flight = flightRepository.findById(flightId)
                                        .orElseThrow(() -> new RuntimeException("Flight not found"));

        if(flight.getSeatsAvailable()<=0)
            throw new RuntimeException("No seats available");

        flight.setSeatsAvailable(flight.getSeatsAvailable() -1);
        booking.setFlight(flight);
        booking.setBookingTime(LocalDateTime.now());

        flightRepository.save(flight);

        return bookingRepository.save(booking);



    }
}
