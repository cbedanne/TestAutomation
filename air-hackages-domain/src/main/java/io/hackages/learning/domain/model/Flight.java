package io.hackages.learning.domain.model;

public class Flight {

    private String type;

    private String origin;

    private String destination;

    private String departureDate;

    private String arrivalDate;

    private Aircraft aircraft;

    public Flight() {}

    public Flight(String type, String origin, String destination, String departureDate, String arrivalDate, Aircraft aircraft) {
        this.type = type;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.aircraft = aircraft;
    }

    public String getType() {
        return type;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }
}
