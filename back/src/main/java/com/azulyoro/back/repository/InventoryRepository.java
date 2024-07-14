package com.azulyoro.back.repository;

import com.azulyoro.back.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Modifying
    @Query("update Inventory i set i.isDeleted = true where i.id = ?1")
    void softDelete(Long id);
}
