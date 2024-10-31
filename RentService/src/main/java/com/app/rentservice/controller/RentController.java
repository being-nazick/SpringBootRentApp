package com.app.rentservice.controller;

import com.app.rentservice.entity.Rent;
import com.app.rentservice.exception.RentRecordNotFoundException;
import com.app.rentservice.service.RentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentController {

    private RentService rentService;

    @Autowired
    public void setRentService(RentService rentService) {
        this.rentService = rentService;
    }


    @GetMapping("/hello")
    public String getHello(){
        return "Hello";
    }


    @PostMapping("/addRent")
    public ResponseEntity<Rent> addRent(@Valid @RequestBody Rent rent){
        Rent createdRent = rentService.addRent(rent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRent);
    }



    @GetMapping("/getRentbyApartment/{apartmentId}")
    public ResponseEntity<List<Rent>> getRentsByApartmentId(@PathVariable Long apartmentId){
        List<Rent> rentList=rentService.getRentsByApartmentId(apartmentId);
        return ResponseEntity.ok(rentList);
    }

    @GetMapping("/getAllRents")
    public ResponseEntity<List<Rent>> getAllRents(){
        List<Rent> allRent= rentService.getAllRents();
        return ResponseEntity.ok(allRent);
    }

    @GetMapping("/getRentbyId/{id}")
    public ResponseEntity<?> getRentById(@PathVariable long id){
        try {
            Rent rent= rentService.getRentById(id);
            return ResponseEntity.ok(rent);
        } catch (RentRecordNotFoundException e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteRentbyId/{id}")
    public ResponseEntity<String> deleteRent(@PathVariable long id){
        try{
            rentService.deleteRent(id);
            return ResponseEntity.ok("Rent with "+id+" is deleted");
        }catch (RentRecordNotFoundException ex){
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }
}
