package com.example.AppClinicaOdontologica;

import com.example.AppClinicaOdontologica.model.Dentist;
import com.example.AppClinicaOdontologica.model.DentistDTO;
import com.example.AppClinicaOdontologica.service.DentistService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@FixMethodOrder
@RunWith(SpringRunner.class)
@SpringBootTest
public class DentistTest {

    @Autowired
    DentistService dentistService;

    public void uploadDataSet()

    {
        Dentist dentist = new Dentist("Felipe", "Acevedo", 8524);
        Dentist dentist1 = new Dentist("Marcelo", "Gallardo", 7895);
        Dentist dentist2 = new Dentist("Panty", "Leon Pantolfa", 4567);
        Dentist dentist3 = new Dentist("Aquiles", "Castro", 1234);
        Dentist dentist4 = new Dentist("Cristian", "Mendieta", 4587);

    }
    @Test
    public void addAndGetDentistTest(){
        this.uploadDataSet();
        Dentist dentist = new Dentist("Aquiles", "Castro", 1234);
        Dentist dentist1 = new Dentist("Juan", "Esteban", 1478);

        Assert.assertNotNull(dentistService.getAll());
    }

    @Test
    public void deleteDentistTest() throws ConfigDataResourceNotFoundException {
        dentistService.deleteDentist(780L);
        Assert.assertTrue(dentistService.getAll().isEmpty());
    }

    @Test
    public void getEverything() {
        Collection<DentistDTO> dentistDTOS = dentistService.getAll();
        //Assert.assertTrue(!dentistDTOS.isEmpty());
        //Assert.assertTrue(dentistDTOS.size() == 2);
        System.out.println(dentistDTOS);
    }
}
