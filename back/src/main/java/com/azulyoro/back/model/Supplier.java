package com.azulyoro.back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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
}
