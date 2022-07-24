package com.example.AppClinicaOdontologica;

import com.example.AppClinicaOdontologica.model.*;
import com.example.AppClinicaOdontologica.service.ShiftService;
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
public class ShiftTest {
    @Autowired
    ShiftService shiftService;

    public void DataUpSet(){
        Shift shift = new Shift(new Patient("Ramiro", "Gonzalez", new Domicile("Benito Juarez", 45, "Bello", "Antioquia"),
                4587, new Date(String.valueOf(LocalDate.of(2015, Month.SEPTEMBER, 10)))), new Dentist("Gonzalo", "Martinez", 5824),
                new Date(String.valueOf(LocalDate.of(2016, Month.JANUARY, 15))));

    }

    @Test
    public void AddAndGetShift(){
        Shift shift = new Shift(new Patient("Ramiro", "Gonzalez", new Domicile("Benito Juarez", 45, "Bello", "Antioquia"),
                4587, new Date(String.valueOf(LocalDate.of(2015, Month.SEPTEMBER, 10)))), new Dentist("Gonzalo", "Martinez", 5824),
                new Date(String.valueOf(LocalDate.of(2016, Month.JANUARY, 15))));

        Assert.assertNotNull(shiftService.getAll());
    }

    @Test
    public void deleteShiftTest() throws ConfigDataResourceNotFoundException {
        shiftService.deleteShift(782L);
        Assert.assertTrue(shiftService.getAll().isEmpty());
    }

    @Test
    public void getEverything() {
        Collection<ShiftDTO> shiftDTOS = shiftService.getAll();
        //Assert.assertTrue(!shiftDTOS.isEmpty());
        //Assert.assertTrue(shiftDTO.size() == 2);
        System.out.println(shiftDTOS);
    }
}
