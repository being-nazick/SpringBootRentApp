package com.app.service;

import com.app.entities.Apartment;
import com.app.exception.ApartmentNotFoundException;
import com.app.repository.ApartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApartmentService {

    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    private final ApartmentRepository apartmentRepository;

    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    public Apartment getApartmentById(Long id) throws ApartmentNotFoundException {
        return apartmentRepository.findById(id).orElseThrow(() -> new ApartmentNotFoundException("Apartment not found"));
    }

    public Apartment createApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    public void deleteApartment(Long id) throws ApartmentNotFoundException {
        if(!apartmentRepository.existsById(id)){
            throw new ApartmentNotFoundException("Apartment not found");
        }
        apartmentRepository.deleteById(id);
    }
}
