package com.azulyoro.back.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private boolean isDeleted;
}
