package io.hackages.learning.repository;

import io.hackages.learning.domain.manager.aircraft.spi.AircraftServiceProvider;
import io.hackages.learning.domain.model.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AircraftRepository implements AircraftServiceProvider {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class AircraftRowMapper implements RowMapper<Aircraft> {
        @Override
        public Aircraft mapRow(ResultSet rs, int rowNum) throws SQLException {
            Aircraft aircraft = new Aircraft(rs.getString("code"), rs.getString("description"));
            return aircraft;
        }

    }

    @Override
    public List<Aircraft> getAircrafts() {
        return jdbcTemplate.query("select * from AIRCRAFTS", new AircraftRowMapper());
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
        return null;
    }
}
