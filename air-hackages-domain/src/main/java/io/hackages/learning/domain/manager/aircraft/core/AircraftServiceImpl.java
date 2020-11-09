package io.hackages.learning.domain.manager.aircraft.core;

import io.hackages.learning.domain.exception.FunctionalException;
import io.hackages.learning.domain.exception.TechnicalException;
import io.hackages.learning.domain.manager.aircraft.api.AircraftService;
import io.hackages.learning.domain.manager.aircraft.spi.AircraftServiceProvider;
import io.hackages.learning.domain.model.Aircraft;

import java.io.IOException;
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

    @Override
    public Aircraft addAircraft(String code, String description) {
        if (code != null) {
            return provider.addAircraft(code, description);
        } else {
            throw new FunctionalException("Incorrect data");
        }
    }

    @Override
    public void deleteAircraft(String code) {
        try {
            provider.deleteAircraft(code);
        } catch (IOException e) {
            throw new TechnicalException("Connection error with the database");
        }
    }

    @Override
    public Aircraft changeDescription(String description) {
        return provider.changeDescription(description);
    }

    @Override
    public Aircraft getAircraftByCode(String code) {
        return provider.getAircraftByCode(code);
    }
}
