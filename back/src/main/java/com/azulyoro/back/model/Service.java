package com.azulyoro.back.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private  Client client;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToMany
    private List<SparePart> spareParts;

    @ManyToMany
    private List<Employee> employees;

    @ManyToOne
    private ServiceType serviceType;

    private Double price;

    private LocalDate startDate;

    private LocalDate finalDate;

    @Enumerated(value = EnumType.STRING)
    private ServiceStatus status;

    @ManyToOne
    private Pay pay;
}
