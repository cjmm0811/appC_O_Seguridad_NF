package com.example.AppClinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Patients")
@Getter
@Setter
@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
public class Patient {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastname;

    @OneToOne
    @JoinColumn(name = "domicile_id")

    private Domicile domicile;
    private int dni;
    private Date dischargeDate;

    public Patient() {
    }

    public Patient(String name, String lastname, Domicile domicile, int dni, Date dischargeDate) {
        this.name = name;
        this.lastname = lastname;
        this.domicile = domicile;
        this.dni = dni;
        this.dischargeDate = dischargeDate;
    }

    public Patient(Long id, String name, String lastname, Domicile domicile, int dni, Date dischargeDate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.domicile = domicile;
        this.dni = dni;
        this.dischargeDate = dischargeDate;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", domicile=" + domicile +
                ", dni=" + dni +
                ", dischargeDate=" + dischargeDate +
                '}';
    }
}
