package io.hackages.learning.api.controller;

import io.hackages.learning.repository.FlightRepository;
import io.hackages.learning.domain.manager.flight.core.FlightServiceImpl;
import io.hackages.learning.domain.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("flights")
public class FlightController {

    private FlightRepository flightRepository;

    @Bean
    private FlightServiceImpl getFlightService() {
        return new FlightServiceImpl(flightRepository);
    }

    @Autowired
    public FlightController(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Flight> getFlights() {
        return getFlightService().getFlights();
    }

    @GetMapping(value = "/origin/{origin}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Flight> getFirstFlightsByOrigin(@PathVariable String origin) {
        return getFlightService().getFlightByOrigin(origin);
    }

    @GetMapping(value = "/destination/{destination}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Flight> getFirstFlightsByDestination(@PathVariable String destination) {
        return getFlightService().getFlightByDestination(destination);
    }
}
