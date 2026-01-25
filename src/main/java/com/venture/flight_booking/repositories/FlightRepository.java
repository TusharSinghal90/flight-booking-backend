package com.venture.flight_booking.repositories;

import com.venture.flight_booking.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    public List<Flight> findBySourceAndDestination(String source, String destination);

}
