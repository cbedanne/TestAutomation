package io.hackages.learning.manager.flight.spi;

import io.hackages.learning.model.Flight;

import java.util.List;
import java.util.Map;

public interface FlightServiceProvider {

    List<Flight> getFlight(Map<String, String> filterParameters);

    Flight getFlightByOrigin(String origin);
}
