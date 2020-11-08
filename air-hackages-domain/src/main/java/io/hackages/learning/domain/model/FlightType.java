package io.hackages.learning.domain.model;

public enum FlightType {

    MH("Medium-Haul"),
    LH("Long-Haul");

    private final String type;

    FlightType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
