package com.example.AppClinicaOdontologica.repository;


import com.example.AppClinicaOdontologica.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
    //@Query("from Patient p where p.name like %:name%, p.lastname like %:lastname%, p.dni like %:dni%")
    //Set<Patient> getPatient(@Param("name") String name, @Param("lastname") String lastname, @Param("dni") int dni);
}
