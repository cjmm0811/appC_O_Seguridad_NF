package com.example.AppClinicaOdontologica.controller;

import com.example.AppClinicaOdontologica.model.PatientDTO;
import com.example.AppClinicaOdontologica.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping()
    public ResponseEntity<?> addPat(@RequestBody PatientDTO patientDTO){
        patientService.addPatient(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PatientDTO readPatient(@PathVariable Long id) throws  Exception {
        return patientService.listPatient(id);
    }

    @PutMapping()
    public ResponseEntity<?> modifyPat(@RequestBody PatientDTO patientDTO){
        patientService.modifyPatient(patientDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePat(@PathVariable Long id){
        ResponseEntity<String> response = null;
        patientService.deletePatient(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @GetMapping("/list")
    public Collection<PatientDTO> listPat(){
        return patientService.getAll();
    }
}
