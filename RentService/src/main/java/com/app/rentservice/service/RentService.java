package com.app.rentservice.service;

import com.app.rentservice.entity.Rent;
import com.app.rentservice.exception.RentRecordNotFoundException;
import com.app.rentservice.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {


    @Autowired
    RentRepository rentRepo;

    public Rent addRent(Rent rent){
        return rentRepo.save(rent);
    }

    public List<Rent> getAllRents(){
        return rentRepo.findAll();
    }

    public List<Rent> getRentsByApartmentId(Long apartmentId){
        return rentRepo.findByApartmentId(apartmentId);
    }

    public Rent getRentById(Long id) throws RentRecordNotFoundException {
        return rentRepo.findById(id).orElseThrow(() -> new RentRecordNotFoundException("message"));
    }

    public void deleteRent(Long id) throws RentRecordNotFoundException{
        if(!rentRepo.existsById(id)){
            throw new RentRecordNotFoundException("message");
        }
        rentRepo.deleteById(id);
    }


}
