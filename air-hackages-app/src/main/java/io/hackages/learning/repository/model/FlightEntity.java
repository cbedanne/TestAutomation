package io.hackages.learning.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "FLIGHTS")
public class FlightEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String type;

    private String origin;

    private String destination;

    private String departureDate;

    private String arrivalDate;

    @OneToOne(targetEntity = AircraftEntity.class)
    private AircraftEntity aircraft;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public AircraftEntity getAircraft() {
        return aircraft;
    }

    public void setAircraft(AircraftEntity aircraft) {
        this.aircraft = aircraft;
    }

    @Override
    public String toString() {
        return "FlightEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", aircraft=" + aircraft +
                '}';
    }
}
