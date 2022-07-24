package com.example.AppClinicaOdontologica.controller;

import com.example.AppClinicaOdontologica.service.ShiftService;
import com.example.AppClinicaOdontologica.model.ShiftDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("shifts")
public class ShiftController {

    @Autowired
    ShiftService shiftService;


    @PostMapping()
    public ResponseEntity<?> addSh(@RequestBody ShiftDTO shiftDTO){
        shiftService.addShift(shiftDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /*@GetMapping("/{id}")
    public ShiftDTO readSh(@PathVariable Long id) throws  Exception {
        return shiftService.listShift(id);
    }*/

    @PutMapping()
    public ResponseEntity<?> modifySh(@RequestBody ShiftDTO shiftDTO){
        shiftService.modifyShift(shiftDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSh(@PathVariable Long id){
        ResponseEntity<String> response = null;
        shiftService.deleteShift(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Turno eliminado");
        return response;
    }

    @GetMapping("/list")
    public Collection<ShiftDTO> listPat(){
        return shiftService.getAll();
    }

    @GetMapping("/getTurnoById")
    public Optional<ShiftDTO> getSh(@RequestParam Long id) {
        return shiftService.getShift(id);
    }
}
