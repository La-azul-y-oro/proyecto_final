package com.azulyoro.back.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Client extends Person{

    private String bussinesName;

    @OneToMany
    private List<Service> services;
}