package com.example.AppClinicaOdontologica.service;

import com.example.AppClinicaOdontologica.model.ShiftDTO;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface ShiftService {
    void addShift(ShiftDTO shiftDTO);
    ShiftDTO listShift(Long id) throws Exception;
    void modifyShift(ShiftDTO shiftDTO);
    void deleteShift(Long id);

    Collection<ShiftDTO> getAll();
    Optional<ShiftDTO> getShift(Long id);
}
