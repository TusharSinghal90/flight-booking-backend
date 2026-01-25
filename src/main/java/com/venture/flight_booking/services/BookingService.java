package com.venture.flight_booking.services;

import com.venture.flight_booking.entities.Booking;

public interface BookingService {

    public Booking bookFlight(Long flightId, Booking booking);
}
