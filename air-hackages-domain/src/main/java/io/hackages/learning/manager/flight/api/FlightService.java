package io.hackages.learning.manager.flight.api;

import io.hackages.learning.model.Flight;

import java.util.List;
import java.util.Map;

public interface FlightService {

    List<Flight> getFlights(Map<String, String> filterParameters);

    Flight getFlightByOrigin(String origin);
}
