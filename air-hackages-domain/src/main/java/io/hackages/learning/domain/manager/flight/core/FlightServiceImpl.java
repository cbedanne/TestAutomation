package io.hackages.learning.domain.manager.flight.core;

import io.hackages.learning.domain.manager.flight.api.FlightService;
import io.hackages.learning.domain.manager.flight.spi.FlightServiceProvider;
import io.hackages.learning.domain.model.Flight;

import java.util.List;

public class FlightServiceImpl implements FlightService {

    private final FlightServiceProvider provider;

    public FlightServiceImpl(FlightServiceProvider provider) {
        this.provider = provider;
    }

    @Override
    public List<Flight> getFlights() {
        return provider.getFlight();
    }

    @Override
    public List<Flight> getFlightByOrigin(String origin) {
        return provider.getFlightByOrigin(origin);
    }

    @Override
    public List<Flight> getFlightByDestination(String destination) {
        return provider.getFlightByDestination(destination);
    }
}
