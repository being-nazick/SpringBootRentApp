package com.app.repository;
import com.app.entities.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApartmentRepository  extends JpaRepository<Apartment,Long> {
}
