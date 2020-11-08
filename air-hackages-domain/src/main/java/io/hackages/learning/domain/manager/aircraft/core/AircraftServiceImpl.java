package io.hackages.learning.domain.manager.aircraft.core;

import io.hackages.learning.domain.manager.aircraft.api.AircraftService;
import io.hackages.learning.domain.manager.aircraft.spi.AircraftServiceProvider;
import io.hackages.learning.domain.model.Aircraft;

import java.util.List;

public class AircraftServiceImpl implements AircraftService {

    private final AircraftServiceProvider provider;

    public AircraftServiceImpl(AircraftServiceProvider provider) {
        this.provider = provider;
    }

    @Override
    public List<Aircraft> getAircrafts() {
        return provider.getAircrafts();
    }
}
