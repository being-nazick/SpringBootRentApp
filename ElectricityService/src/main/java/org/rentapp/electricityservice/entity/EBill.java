package org.rentapp.electricityservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class EBill {

    @Id
    private long id;
    private long apartmentId;
    @Setter
    private double amount;
    private String month;
    private double costPerUnit;

    private double units;

    public double calculateBillAmount(){
        return units* costPerUnit;
    }

}
