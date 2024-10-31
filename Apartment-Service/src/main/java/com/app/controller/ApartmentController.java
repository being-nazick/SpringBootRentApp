package com.app.controller;

import com.app.exception.ApartmentNotFoundException;
import com.app.service.ApartmentService;
import com.app.entities.Apartment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apartment")
public class ApartmentController {

    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping("/getallapartments")
    public ResponseEntity<List<Apartment>> getAllApartments() {
        return ResponseEntity.ok(apartmentService.getAllApartments());
    }

    @GetMapping("getapartmentById/{id}")
    public ResponseEntity<Apartment> getApartmentById(@PathVariable Long id) throws ApartmentNotFoundException {
        return ResponseEntity.ok(apartmentService.getApartmentById(id));
    }

    @PostMapping("/addapartment")
    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment) {
        return new ResponseEntity<>(apartmentService.createApartment(apartment), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApartment(@PathVariable Long id) throws ApartmentNotFoundException {
       try{
        apartmentService.deleteApartment(id);
        return ResponseEntity.ok("Apartment with id "+id+" is deleted successfully");
    }catch (ApartmentNotFoundException e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
       }
    }
}
