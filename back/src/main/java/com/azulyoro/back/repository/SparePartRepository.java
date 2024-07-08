package com.azulyoro.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azulyoro.back.model.SparePart;

@Repository
public interface SparePartRepository extends JpaRepository<SparePart, Long> {

}
