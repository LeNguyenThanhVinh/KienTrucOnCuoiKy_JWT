package com.example.driverservice.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Drivers")
public class Driver {
    @Id
    @GeneratedValue
    private long driverId;
    private String name;
    private double price;
    private double km;
    private Long customerId;
}
