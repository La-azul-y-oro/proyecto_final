package com.azulyoro.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.azulyoro.back.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Modifying
    @Query("update Vehicle v set v.isDeleted = true where v.id = ?1")
    void softDelete(Long id);
}
