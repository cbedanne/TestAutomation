package io.hackages.learning.repository.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "AIRCRAFTS")
@OnDelete(action = OnDeleteAction.CASCADE)
public class AircraftEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AircraftEntity(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public AircraftEntity(Long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public AircraftEntity() {
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
