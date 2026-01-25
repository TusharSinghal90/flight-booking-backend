package com.venture.flight_booking.services;

import com.venture.flight_booking.entities.Flight;

import java.util.List;

public interface FlightService {

    public Flight saveFlight(Flight flight);

    public List<Flight> getAllFlights();

    public List<Flight> searchFlights(String source, String destination);
}
