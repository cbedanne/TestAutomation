package io.hackages.learning.domain.manager.aircraft.spi;

import io.hackages.learning.domain.model.Aircraft;

import java.io.IOException;
import java.util.List;

public interface AircraftServiceProvider {

    List<Aircraft> getAircrafts();

    Aircraft addAircraft(String code, String description);

    void deleteAircraft(String code) throws IOException;

    Aircraft changeDescription(String description);

    Aircraft fetchAircraftByCode(String code);
}
