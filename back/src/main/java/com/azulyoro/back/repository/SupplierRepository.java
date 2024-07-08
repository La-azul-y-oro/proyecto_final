package com.azulyoro.back.repository;

import com.azulyoro.back.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Modifying
    @Query("update Supplier s set s.isDeleted = true where s.id = ?1")
    void softDelete(Long id);
}
