package com.example.AppClinicaOdontologica.repository;

import com.example.AppClinicaOdontologica.model.Shift;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IShiftRepository extends JpaRepository<Shift, Long> {
    //@Query("from Shift s where s.id")
    //Set<Shift> getShift(@Param("id") Long id);
}
