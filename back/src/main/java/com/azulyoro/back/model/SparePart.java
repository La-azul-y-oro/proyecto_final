package com.azulyoro.back.model;

import jakarta.persistence.*;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @ManyToMany(mappedBy = "spareParts")
    private List<Services> services;
    @OneToMany(mappedBy = "sparePart")
    private List<Inventory> inventory;
    @Column(nullable = false)
    private boolean isDeleted;
}
