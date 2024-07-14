package com.azulyoro.back.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Employee extends Person{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Embedded
    private Address address;
    @Column(nullable = false)
    private String password;
    @ManyToMany(mappedBy = "employees")
    private List<Services> services;
}
