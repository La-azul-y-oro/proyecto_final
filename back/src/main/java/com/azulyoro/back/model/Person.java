package com.azulyoro.back.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    // para que java me guarde el enum en formato de texto
    private IdentificationType category;
    @Column(nullable = false, length = 50, unique = true)
    private Long identificationNumber;
    @Column(nullable = false, length = 50, unique = true)
    private String email;










}
