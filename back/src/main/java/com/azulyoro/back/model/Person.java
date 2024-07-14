package com.azulyoro.back.model;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Getter
@Setter
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Enumerated(EnumType.STRING)
    private IdentificationType category;
    @Column(nullable = false, length = 50, unique = true)
    private Long identificationNumber;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    private boolean isDeleted;
}
