package com.azulyoro.back.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    private Integer price;

    private Date startDate;

    private Date finalDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "pay_id")
    private Pay pay;
}
