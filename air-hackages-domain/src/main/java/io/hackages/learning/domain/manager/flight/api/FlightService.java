package io.hackages.learning.domain.manager.flight.api;

import io.hackages.learning.domain.model.Flight;

import java.util.List;

public interface FlightService {

    List<Flight> getFlights();

    List<Flight> getFlightByOrigin(String origin);

    List<Flight> getFlightByDestination(String destination);
}
