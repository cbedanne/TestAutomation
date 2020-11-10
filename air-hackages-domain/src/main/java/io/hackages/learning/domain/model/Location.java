package io.hackages.learning.domain.model;

public enum Location {
    CDG("Paris"),
    AMS("Amsterdam");

    private final String airport;

    Location(String airport) {
        this.airport = airport;
    }

    public String getAirport() {
        return airport;
    }
}
