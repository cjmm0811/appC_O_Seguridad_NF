package com.example.AppClinicaOdontologica.service.impl;

import com.example.AppClinicaOdontologica.model.Dentist;
import com.example.AppClinicaOdontologica.model.Patient;
import com.example.AppClinicaOdontologica.model.Shift;
import com.example.AppClinicaOdontologica.model.ShiftDTO;

import com.example.AppClinicaOdontologica.repository.IDentistRepository;
import com.example.AppClinicaOdontologica.repository.IPatientRepository;
import com.example.AppClinicaOdontologica.repository.IShiftRepository;

import com.example.AppClinicaOdontologica.service.ShiftService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    IShiftRepository shiftRepository;

    @Autowired
    IDentistRepository dentistRepository;

    @Autowired
    IPatientRepository patientRepository;

    @Autowired
    ObjectMapper mapper;

    private void saveShift(ShiftDTO shiftDTO) {
        Optional<Dentist> dentistOptional = dentistRepository.findById(shiftDTO.getDentist().getId());
        Optional<Patient> patientOptional = patientRepository.findById(shiftDTO.getPatient().getId());
        Shift shift = mapper.convertValue(shiftDTO, Shift.class);
        patientOptional.ifPresent(shift::setPatient);
        dentistOptional.ifPresent(shift::setDentist);
        shiftRepository.save(shift);
    }


    @Override
    public void addShift(ShiftDTO shiftDTO) {
        saveShift(shiftDTO);
    }

    @Override
    public ShiftDTO listShift(Long id) throws Exception {
        Optional<Shift> found = shiftRepository.findById(id);
        if (found.isPresent())
            return mapper.convertValue(found, ShiftDTO.class);
        else
            throw new Exception("No se encuentra el turno");
    }

    @Override
    public void modifyShift(ShiftDTO shiftDTO) {
       saveShift(shiftDTO);
    }

    @Override
    public void deleteShift(Long id) {
      shiftRepository.deleteById(id);
    }

    @Override
    public Collection<ShiftDTO> getAll() {
        List<Shift> allShifts = shiftRepository.findAll();
        Set <ShiftDTO> allShiftsDTO = new HashSet<ShiftDTO>();
        for (Shift shift: allShifts)
            allShiftsDTO.add(mapper.convertValue(shift, ShiftDTO.class));
        return allShiftsDTO;
    }

    @Override
    public Optional<ShiftDTO> getShift(Long id) {
        Optional<Shift> shift = shiftRepository.findById(id);
        ShiftDTO shiftDTO = null;
        if (shift.isPresent()) {
            shiftDTO = mapper.convertValue(shift, ShiftDTO.class);
        }
        return Optional.ofNullable(shiftDTO);
    }
}
