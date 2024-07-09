package com.azulyoro.back.repository;

import com.azulyoro.back.model.PaymentType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
    @Modifying
    @Query("UPDATE PaymentType pt SET pt.isDeleted = true WHERE pt.id = :id")
    void softDelete(Long id);
}
