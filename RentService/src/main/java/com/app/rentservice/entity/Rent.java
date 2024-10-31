package com.app.rentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Rent {

    @Id
    private long id;
    @NotNull
    private double amount;
    private LocalDate date;
    private long apartmentId;


}
