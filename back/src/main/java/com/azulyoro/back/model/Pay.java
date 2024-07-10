package com.azulyoro.back.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate date;
    @ManyToOne
    private PaymentType paymentType;

    @OneToMany(mappedBy = "pay")
    private List<Services> services;
}
