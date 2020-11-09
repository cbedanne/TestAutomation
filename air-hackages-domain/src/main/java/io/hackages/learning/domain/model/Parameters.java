package io.hackages.learning.domain.model;

public enum Parameters {

    ORIGIN("origin"),
    DESTINATION("destination");

    private final String parameterType;

    Parameters(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getParameterType() {
        return parameterType;
    }
}
