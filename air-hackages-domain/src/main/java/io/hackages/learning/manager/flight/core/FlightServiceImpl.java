package io.hackages.learning.manager.flight.core;

import io.hackages.learning.manager.flight.api.FlightService;
import io.hackages.learning.manager.flight.spi.FlightServiceProvider;
import io.hackages.learning.model.Flight;

import java.util.List;
import java.util.Map;

public class FlightServiceImpl implements FlightService {

    private final FlightServiceProvider provider;

    public FlightServiceImpl(FlightServiceProvider provider) {
        this.provider = provider;
    }

    @Override
    public List<Flight> getFlights(Map<String, String> filterParameters) {
        return provider.getFlight(filterParameters);
    }

    @Override
    public Flight getFlightByOrigin(String origin) {
        return provider.getFlightByOrigin(origin);
    }
}
