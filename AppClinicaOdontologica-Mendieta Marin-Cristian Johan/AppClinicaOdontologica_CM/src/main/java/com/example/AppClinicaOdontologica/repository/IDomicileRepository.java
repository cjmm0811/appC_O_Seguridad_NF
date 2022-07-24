package com.example.AppClinicaOdontologica.repository;

import com.example.AppClinicaOdontologica.model.Domicile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IDomicileRepository extends JpaRepository<Domicile, Long> {

    //@Query("from Domicile d where d.street like %:street%, d.number like %:number%, d.locality like %:locality%, d.province like %:province%")
    //Set<Domicile> getDom(@Param("street") String street, @Param("number") int number, @Param("locality") String locality, @Param("province") String province);

}
