package com.example.AppClinicaOdontologica.service.impl;

import com.example.AppClinicaOdontologica.model.Domicile;
import com.example.AppClinicaOdontologica.model.DomicileDTO;

import com.example.AppClinicaOdontologica.repository.IDomicileRepository;

import com.example.AppClinicaOdontologica.service.DomicileService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DomicileServiceImpl implements DomicileService {

    @Autowired
    IDomicileRepository domicileRepository;

    @Autowired
    ObjectMapper mapper;

    private void saveDomicile(DomicileDTO domicileDTO){
        Domicile newDomicile = mapper.convertValue(domicileDTO, Domicile.class);
        domicileRepository.save(newDomicile);
    }

    @Override
    public void addDomicile(DomicileDTO domicileDTO) {
        saveDomicile(domicileDTO);
    }

    @Override
    public DomicileDTO listDomicile(Long id) throws Exception {
        Optional<Domicile> found = domicileRepository.findById(id);
        if (found.isPresent()){
            return mapper.convertValue(found, DomicileDTO.class);
        } else {
            throw new Exception("No se encuentra el domicilio");
        }
    }

    @Override
    public void modifyDomicile(DomicileDTO domicileDTO) {
     saveDomicile(domicileDTO);
    }

    @Override
    public void deleteDomicile(Long id) {
    domicileRepository.deleteById(id);
    }

    @Override
    public Collection<DomicileDTO> getAll() {
        List<Domicile> allDomiciles = domicileRepository.findAll();
        Set<DomicileDTO> allDomicilesDTO = new HashSet<DomicileDTO>();
        for (Domicile domicile:allDomiciles)
            allDomicilesDTO.add(mapper.convertValue(domicile, DomicileDTO.class));

        return allDomicilesDTO;
    }

    /*@Override
    public Set<DomicileDTO> getDomicile(String street, int number, String locality, String province) {
        Set<Domicile> allDomiciles = domicileRepository.getDom(street, number, locality, province);
        Set<DomicileDTO> allDomicilesDTO = new HashSet<DomicileDTO>();
        for (Domicile domicile: allDomiciles)
            allDomicilesDTO.add(mapper.convertValue(domicile, DomicileDTO.class));

        return allDomicilesDTO;
    }*/
}
