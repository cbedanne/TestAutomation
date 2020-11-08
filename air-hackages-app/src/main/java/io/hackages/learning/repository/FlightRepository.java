package io.hackages.learning.repository;

import io.hackages.learning.domain.manager.flight.spi.FlightServiceProvider;
import io.hackages.learning.domain.model.Aircraft;
import io.hackages.learning.domain.model.Flight;
import io.hackages.learning.domain.model.FlightType;
import io.hackages.learning.domain.model.Location;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class FlightRepository implements FlightServiceProvider {

    public FlightRepository() {
    }

    @Override
    public List<Flight> getFlight() {
        return dailyFlights();
    }

    @Override
    public List<Flight> getFlightByOrigin(String origin) {
        return dailyFlights().stream().filter(flight -> flight.getOrigin().equals(origin)).collect(Collectors.toList());
    }

    @Override
    public List<Flight> getFlightByDestination(String destination) {
        return dailyFlights().stream().filter(flight -> flight.getDestination().equals(destination)).collect(Collectors.toList());
    }

    private List<Flight> dailyFlights() {
        Aircraft aircraft = new Aircraft("AH123", "Airbus A380");
        List<Flight> flights = IntStream.range(0, 10).mapToObj(i -> i % 2 == 0 ?
                new Flight(
                        FlightType.MH.getType(),
                        Location.CDG.getAirport(),
                        Location.AMS.getAirport(),
                        LocalDateTime.now().plusHours(i).toString(),
                        LocalDateTime.now().plusHours(i + 1).toString(),
                        aircraft)
                :
                new Flight(
                        FlightType.MH.getType(),
                        Location.AMS.getAirport(),
                        Location.CDG.getAirport(),
                        LocalDateTime.now().plusHours(i).toString(),
                        LocalDateTime.now().plusHours(i + 1).toString(),
                        aircraft)

        ).collect(Collectors.toList());
        return flights;
    }
}
