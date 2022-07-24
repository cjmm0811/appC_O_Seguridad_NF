package com.example.AppClinicaOdontologica.controller;

import com.example.AppClinicaOdontologica.model.DentistDTO;
import com.example.AppClinicaOdontologica.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    @Autowired
    DentistService dentistService;

    @PostMapping()
    public ResponseEntity<?> addDentist(@RequestBody DentistDTO dentistDTO){
        dentistService.addDentist(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DentistDTO readDentist(@PathVariable Long id) throws  Exception {
        return dentistService.listDentist(id);
    }

    @PutMapping()
    public ResponseEntity<?> modifyDent(@RequestBody DentistDTO dentistDTO){
        dentistService.modifyDentist(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDent(@PathVariable Long id){
        ResponseEntity<String> response = null;
        dentistService.deleteDentist(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @GetMapping("/list")
    public Collection<DentistDTO> listDentist(){
        return dentistService.getAll();
    }
}
