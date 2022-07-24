package com.example.AppClinicaOdontologica.service;

import com.example.AppClinicaOdontologica.model.PatientDTO;

import java.util.Collection;

public interface PatientService {
    void addPatient(PatientDTO patientDTO);
    PatientDTO listPatient(Long id) throws Exception;
    void modifyPatient(PatientDTO patientDTO);
    void deletePatient(Long id);

    Collection<PatientDTO> getAll();
}
