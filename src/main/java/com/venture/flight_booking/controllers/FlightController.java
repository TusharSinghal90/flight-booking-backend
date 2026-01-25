package com.venture.flight_booking.controllers;

import com.venture.flight_booking.entities.Flight;
import com.venture.flight_booking.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight){
        return flightService.saveFlight(flight);
    }

    @GetMapping
    public List<Flight> fetchAllFlights(){
        return flightService.getAllFlights();

    }

    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam String source, @RequestParam String destination){
        return flightService.searchFlights(source, destination);

    }


}
