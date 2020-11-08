package io.hackages.learning.domain.manager.aircraft.spi;

import io.hackages.learning.domain.model.Aircraft;

import java.util.List;

public interface AircraftServiceProvider {

    List<Aircraft> getAircrafts();
}
