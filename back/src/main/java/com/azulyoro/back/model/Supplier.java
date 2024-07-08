package com.azulyoro.back.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Embedded
    private Address address;
    @Column(nullable = false, length = 50, unique = true)
    private String phone;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @OneToMany(mappedBy = "supplier")
    private List<Inventory> inventory;
    private boolean isDeleted;
}
