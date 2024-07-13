package com.azulyoro.back.repository;

import com.azulyoro.back.model.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepository extends JpaRepository <Pay, Long> {
    @Modifying
    @Query("update Pay p set p.isDeleted = true where p.id = ?1")
    void softDelete(Long id);
}
