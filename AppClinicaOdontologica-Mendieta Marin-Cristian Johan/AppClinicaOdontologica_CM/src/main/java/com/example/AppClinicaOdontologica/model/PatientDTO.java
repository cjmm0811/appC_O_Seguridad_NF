package com.example.AppClinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PatientDTO {
    private Long id;


    private String name;
    private String lastname;
    private Domicile domicile;
    private int dni;
    private Date dischargeDate;
}
