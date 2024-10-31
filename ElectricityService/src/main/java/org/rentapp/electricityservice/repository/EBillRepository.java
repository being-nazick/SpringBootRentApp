package org.rentapp.electricityservice.repository;

import org.rentapp.electricityservice.entity.EBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EBillRepository extends JpaRepository<EBill,Long> {
    List<EBill> findByApartmentId(Long apartmentId);
}
