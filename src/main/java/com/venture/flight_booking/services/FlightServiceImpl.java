package com.venture.flight_booking.services;


import com.venture.flight_booking.entities.Flight;
import com.venture.flight_booking.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{
    @Autowired
    private FlightRepository flightRepository;

    public Flight saveFlight(Flight flight){
       return flightRepository.save(flight);

    }

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();

    }

    public List<Flight> searchFlights(String source, String destination){
       return flightRepository.findBySourceAndDestination(source, destination);
    }


}
