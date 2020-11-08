package io.hackages.learning.domain.model;

public class Aircraft {

    private String code;

    private String description;

    public Aircraft() {
    }

    public Aircraft(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
