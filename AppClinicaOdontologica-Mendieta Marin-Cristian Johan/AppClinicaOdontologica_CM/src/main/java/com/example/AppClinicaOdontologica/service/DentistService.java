package com.example.AppClinicaOdontologica.service;


import com.example.AppClinicaOdontologica.model.DentistDTO;


import java.util.Collection;


public interface DentistService {
    void addDentist(DentistDTO dentistDTO);
    DentistDTO listDentist(Long id) throws Exception;
    void modifyDentist(DentistDTO dentistDTO);
    void deleteDentist(Long id);

    Collection<DentistDTO> getAll();
}
