package com.azulyoro.back.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(nullable = false)
    private String model;

    private Number mileage;

    @Column(nullable = false, unique = true)
    private String plate;

    private String observations;

    @OneToMany(mappedBy = "vehicle")
    private List<Service> services;
}
