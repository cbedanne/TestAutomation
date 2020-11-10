package io.hackages.learning.api.controller;

import io.hackages.learning.domain.manager.aircraft.core.AircraftServiceImpl;
import io.hackages.learning.domain.model.Aircraft;
import io.hackages.learning.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("aircrafts")
public class AircraftController {

    private AircraftRepository aircraftRepository;

    @Bean
    private AircraftServiceImpl getAircraftService() {
        return new AircraftServiceImpl(aircraftRepository);
    }

    @Autowired
    public AircraftController(AircraftRepository aircraftRepository){
        this.aircraftRepository = aircraftRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Aircraft> getAircrafts() {
        return getAircraftService().getAircrafts();
    }
}
