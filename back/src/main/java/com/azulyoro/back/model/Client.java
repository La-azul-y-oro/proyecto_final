package com.azulyoro.back.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
public class Client extends Person{

    private String businessName;

    @OneToMany(mappedBy = "client")
    private List<Services> services;
}