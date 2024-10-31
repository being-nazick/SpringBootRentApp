package com.app.rentservice.repository;

import com.app.rentservice.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent,Long> {

    List<Rent> findByApartmentId(Long apartmentId);
}
