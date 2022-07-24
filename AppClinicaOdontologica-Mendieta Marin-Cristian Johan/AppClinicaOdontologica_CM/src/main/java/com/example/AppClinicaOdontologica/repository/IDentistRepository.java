package com.example.AppClinicaOdontologica.repository;

import com.example.AppClinicaOdontologica.model.Dentist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {
    //@Query("from Dentist de where de.name like %:name%, de.lastname like %:lastname%")
    //Set<Dentist> getDentist(@Param("name") String name, @Param("lastname") String lastname);
}
