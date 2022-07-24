package com.example.AppClinicaOdontologica.service.impl;

import com.example.AppClinicaOdontologica.model.Dentist;
import com.example.AppClinicaOdontologica.model.DentistDTO;
import com.example.AppClinicaOdontologica.service.DentistService;
import com.example.AppClinicaOdontologica.repository.IDentistRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DentistServiceImpl implements DentistService {

    @Autowired
    IDentistRepository dentistRepository;

    @Autowired
    ObjectMapper mapper;

    private void saveDentist(DentistDTO dentistDTO){
        Dentist newDentist = mapper.convertValue(dentistDTO, Dentist.class);
        dentistRepository.save(newDentist);
    }


    @Override
    public void addDentist(DentistDTO dentistDTO) {
        saveDentist(dentistDTO);
    }

    @Override
    public DentistDTO listDentist(Long id) throws Exception {
        Optional<Dentist> found = dentistRepository.findById(id);
        if (found.isPresent()){
            return mapper.convertValue(found, DentistDTO.class);
        } else {
            throw new Exception("No se encuentra el dentista");
        }
    }

    @Override
    public void modifyDentist(DentistDTO dentistDTO) {
       saveDentist(dentistDTO);
    }

    @Override
    public void deleteDentist(Long id) {

        dentistRepository.deleteById(id);
    }

    @Override
    public Collection<DentistDTO> getAll() {
        List<Dentist> allDentists = dentistRepository.findAll();
        Set<DentistDTO> allDentistsDTO = new HashSet<DentistDTO>();
        for(Dentist dentist: allDentists)
            allDentistsDTO.add(mapper.convertValue(dentist,DentistDTO.class));

        return allDentistsDTO;
    }
}
