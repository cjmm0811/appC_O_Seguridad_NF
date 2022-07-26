package com.example.AppClinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistDTO {
    private Long id;

    private String name;
    private String lastname;
    private Integer enrollment;
}
