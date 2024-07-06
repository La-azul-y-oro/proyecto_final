package com.azulyoro.back.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Embedded
    private Address address;
    @Column(nullable = false, length = 50, unique = true)
    private String phoneNumber;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @OneToMany
    @JoinColumn(name = "supplier_id")
    private List<Inventory> inventory;
}
