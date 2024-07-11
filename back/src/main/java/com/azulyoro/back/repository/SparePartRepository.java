package com.azulyoro.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.azulyoro.back.model.SparePart;

@Repository
public interface SparePartRepository extends JpaRepository<SparePart, Long> {
    @Modifying
    @Query("update SparePart sp set sp.isDeleted = true where sp.id = ?1")
    void softDelete(Long id);
}
