package com.example.AppClinicaOdontologica.service;

import com.example.AppClinicaOdontologica.model.DomicileDTO;


import java.util.Collection;



public interface DomicileService {

    void addDomicile(DomicileDTO domicileDTO);
    DomicileDTO listDomicile(Long id) throws Exception;
    void modifyDomicile(DomicileDTO domicileDTO);
    void deleteDomicile(Long id);

    Collection<DomicileDTO> getAll();
    //Set<DomicileDTO> getDomicile(String street, int number, String locality, String province);
}
