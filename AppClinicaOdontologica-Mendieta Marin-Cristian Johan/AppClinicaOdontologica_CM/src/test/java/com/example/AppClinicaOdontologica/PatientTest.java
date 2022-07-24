package com.example.AppClinicaOdontologica;

import com.example.AppClinicaOdontologica.model.Domicile;
import com.example.AppClinicaOdontologica.model.Patient;
import com.example.AppClinicaOdontologica.model.PatientDTO;

import com.example.AppClinicaOdontologica.service.PatientService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Date;

@FixMethodOrder
@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientTest {
    @Autowired
    PatientService patientService;


    public void upDataSet() {
        Patient patient = new Patient("Ricardo", "Gomez", new Domicile("Manzanares", 78, "Medellin",
                "Antioquia"), 458769, new Date(String.valueOf(LocalDate.of(2021, Month.AUGUST, 15))));

        Patient patient1 = new Patient("Alfonso", "Lopez", new Domicile("EsquinaRoja", 87, "Cali",
                "Valle"), 45785, new Date(String.valueOf(LocalDate.of(2018, Month.APRIL, 10))));
    }
    @Test
    public void addAndGetPatientTest(){
        this.upDataSet();
        Patient patient = new Patient("Aquiles", "Castro", new Domicile("Principal", 58, "Bogota",
                "Cundinamarca"), 425413, new Date(String.valueOf(LocalDate.of(2015, Month.DECEMBER, 18))));

        Assert.assertNotNull(patientService.getAll());
    }

    @Test
    public void deleteDentistTest() throws ConfigDataResourceNotFoundException {
        patientService.deletePatient(782L);
        Assert.assertTrue(patientService.getAll().isEmpty());
    }

    @Test
    public void getEverything() {
        Collection<PatientDTO> patientDTOS = patientService.getAll();
        //Assert.assertTrue(!dentistDTOS.isEmpty());
        //Assert.assertTrue(dentistDTOS.size() == 2);
        System.out.println(patientDTOS);
    }





}
