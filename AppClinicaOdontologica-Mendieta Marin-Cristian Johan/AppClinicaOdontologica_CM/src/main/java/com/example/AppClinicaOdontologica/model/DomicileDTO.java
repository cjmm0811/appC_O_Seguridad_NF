package com.example.AppClinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomicileDTO {
    private Long id;


    private String street;
    private int number;
    private String locality;
    private String province;
}
