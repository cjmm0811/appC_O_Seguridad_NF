package com.example.AppClinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ShiftDTO {
    private Long id;

    private Patient patient;
    private Dentist dentist;
    private Date dischargeDate;

}
