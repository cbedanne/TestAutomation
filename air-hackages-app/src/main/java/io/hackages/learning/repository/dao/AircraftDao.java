package io.hackages.learning.repository.dao;

import io.hackages.learning.repository.model.AircraftEntity;
import org.springframework.data.repository.CrudRepository;

public interface AircraftDao extends CrudRepository<AircraftEntity, Long> {
    AircraftEntity findByCode(String code);
}
