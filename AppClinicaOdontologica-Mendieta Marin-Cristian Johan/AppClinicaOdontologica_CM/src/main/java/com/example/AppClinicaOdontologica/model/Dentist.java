package com.example.AppClinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name ="Dentists")
@Getter
@Setter
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Dentist {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastname;
    private Integer enrollment;

    public Dentist() {

    }

    public Dentist(String name, String lastname, Integer enrollment) {
        this.name = name;
        this.lastname = lastname;
        this.enrollment = enrollment;
    }

    public Dentist(Long id, String name, String lastname, Integer enrollment) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.enrollment = enrollment;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dni=" + enrollment +
                '}';
    }
}
