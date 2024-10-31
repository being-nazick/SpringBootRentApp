package org.rentapp.electricityservice.controller;

import jakarta.validation.Valid;
import org.rentapp.electricityservice.entity.EBill;
import org.rentapp.electricityservice.exception.EBillNotFoundException;
import org.rentapp.electricityservice.service.EBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/eb")
public class EBillController {

    @Autowired
    private EBillService ebillservice;

    @PostMapping("/addebill")
    public ResponseEntity<EBill> createEBill(@Valid @RequestBody EBill ebill) {
        EBill createdbill = ebillservice.addEBill(ebill);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdbill);
    }

    @GetMapping("/getebill/{id}")
    public ResponseEntity<?> getEBillById(@PathVariable long id) throws EBillNotFoundException {
        try {
            EBill ebill = ebillservice.getEBillById(id);
            return ResponseEntity.ok(ebill);
        } catch (EBillNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<EBill>> getAllEBills(){
        List<EBill> billList=ebillservice.getAllEBill();
        return ResponseEntity.ok(billList);
    }


    @GetMapping("/getByapartmentId/{id}")
    public ResponseEntity<List<EBill>> getEBillByApartmentId(@PathVariable long id){
        List<EBill> billbyApartmentId=ebillservice.getEBillsByApartementId(id);
        return ResponseEntity.ok(billbyApartmentId);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEbill(@PathVariable long id) throws EBillNotFoundException{
        try {
            ebillservice.deleteEBill(id);
            return ResponseEntity.ok("EBill with "+id+" is deleted");
        }catch (EBillNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

}