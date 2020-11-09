package io.hackages.learning.domain.model;

public enum Location {
    CDG("Paris Charles De Gaulle"),
    AMS("Amsterdam Schiphol");

    private final String airport;

    Location(String airport) {
        this.airport = airport;
    }

    public String getAirport() {
        return airport;
    }
}
