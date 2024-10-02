package com.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Apartment {

    @Id
    private Long id;
    private String name;
    private String address;
    private Double rentAmount;

    public Apartment(Long id, String name, String address, Double rentAmount) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rentAmount = rentAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(Double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public Apartment() {

    }
}
