package com.example.AppClinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Domiciles")
@Getter
@Setter

@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Domicile {
    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private int number;
    private String locality;
    private String province;

    public Domicile() {

    }

    public Domicile(String street, int number, String locality, String province) {
        this.street = street;
        this.number = number;
        this.locality = locality;
        this.province = province;
    }

    public Domicile(Long id, String street, int number, String locality, String province) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.locality = locality;
        this.province = province;
    }

    @Override
    public String toString() {
        return "Domicile{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", locality='" + locality + '\'' +
                ", province='" + province + '\'' +
                //", pacients=" + patients +
                '}';
    }
}
