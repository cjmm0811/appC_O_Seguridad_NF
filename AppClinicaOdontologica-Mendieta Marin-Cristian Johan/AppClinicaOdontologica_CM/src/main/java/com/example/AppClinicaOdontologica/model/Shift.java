package com.example.AppClinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Shifts")
@Getter
@Setter
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Shift {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "dentist_id", referencedColumnName = "id")

    private Dentist dentist;
    private Date dischargeDate;

    public Shift() {
    }

    public Shift(Patient patient, Dentist dentist, Date dischargeDate) {
        this.patient = patient;
        this.dentist = dentist;
        this.dischargeDate = dischargeDate;
    }

    public Shift(Long id, Patient patient, Dentist dentist, Date dischargeDate) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.dischargeDate = dischargeDate;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "id=" + id +
                ", pacient=" + patient +
                ", dentist=" + dentist +
                ", dischargeDate=" + dischargeDate +
                '}';
    }
}
