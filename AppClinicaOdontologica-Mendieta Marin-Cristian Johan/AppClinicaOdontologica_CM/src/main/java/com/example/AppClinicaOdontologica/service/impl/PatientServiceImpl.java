package com.example.AppClinicaOdontologica.service.impl;



import com.example.AppClinicaOdontologica.model.Patient;
import com.example.AppClinicaOdontologica.model.PatientDTO;
import com.example.AppClinicaOdontologica.repository.IPatientRepository;
import com.example.AppClinicaOdontologica.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    IPatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;

    private void savePatient(PatientDTO patientDTO){
        Patient newPatient = mapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(newPatient);
    }


    @Override
    public void addPatient(PatientDTO patientDTO) {
        savePatient(patientDTO);
    }

    @Override
    public PatientDTO listPatient(Long id) throws Exception {
        Optional<Patient> found = patientRepository.findById(id);
        if (found.isPresent())
            return mapper.convertValue(found, PatientDTO.class);
        else
            throw new Exception("No se pudo encontrar al paciente");
    }

    @Override
    public void modifyPatient(PatientDTO patientDTO) {
      savePatient(patientDTO);
    }

    @Override
    public void deletePatient(Long id) {
    patientRepository.deleteById(id);
    }

    @Override
    public Collection<PatientDTO> getAll() {
        List<Patient> allPatients = patientRepository.findAll();
        Set<PatientDTO> allPatientsDTO = new HashSet<PatientDTO>();
        for (Patient patient: allPatients)
            allPatientsDTO.add(mapper.convertValue(patient, PatientDTO.class));

            return allPatientsDTO;
    }
}
