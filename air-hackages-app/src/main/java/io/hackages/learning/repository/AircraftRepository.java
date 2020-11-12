package io.hackages.learning.repository;

import io.hackages.learning.domain.manager.aircraft.spi.AircraftServiceProvider;
import io.hackages.learning.domain.model.Aircraft;
import io.hackages.learning.repository.dao.AircraftDao;
import io.hackages.learning.repository.model.AircraftEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AircraftRepository implements AircraftServiceProvider {

    @Autowired
    AircraftDao aircraftDao;

    @Override
    public List<Aircraft> getAircrafts() {
        List<Aircraft> aircrafts = new ArrayList<>();
        for(AircraftEntity ae  : aircraftDao.findAll()) {
            aircrafts.add(this.aircraftEntityToAircraft(ae));
        }
        return aircrafts;
    }

    @Override
    public Aircraft addAircraft(String code, String description) {
        return null;
    }

    @Override
    public void deleteAircraft(String code) throws IOException {

    }

    @Override
    public Aircraft changeDescription(String description) {
        return null;
    }

    @Override
    public Aircraft fetchAircraftByCode(String code) {
        AircraftEntity aircraft = aircraftDao.findByCode(code);
        return new Aircraft(aircraft.getCode(), aircraft.getDescription());
    }

    private Aircraft aircraftEntityToAircraft(AircraftEntity aircraftEntity) {
        return new Aircraft(aircraftEntity.getCode(), aircraftEntity.getDescription());
    }
}
