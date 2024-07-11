package com.azulyoro.back.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer amount;
    @ManyToOne 
    private Supplier supplier;
    @Column(nullable = false)
    private Double costPrice;
    @Column(nullable = false)
    private Double salePrice;
    @ManyToOne
    private SparePart sparePart;
}
