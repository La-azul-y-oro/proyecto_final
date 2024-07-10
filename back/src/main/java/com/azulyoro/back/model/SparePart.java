package com.azulyoro.back.model;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Setter
public class SparePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private String madeIn;

    @ManyToMany
    private List<Service> services;
}
