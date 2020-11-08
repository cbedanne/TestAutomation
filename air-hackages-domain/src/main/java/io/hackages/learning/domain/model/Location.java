package io.hackages.learning.domain.model;

public enum Location {
    CDG("Paris Charles De Gaule"),
    AMS("Amsterdam Schipol");

    private final String airport;

    Location(String airport) {
        this.airport = airport;
    }

    public String getAirport() {
        return airport;
    }
}
