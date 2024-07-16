package com.azulyoro.back.repository;

import com.azulyoro.back.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository <Services, Long> {
    @Modifying
    @Query("update Services s set s.status = 'CANCELLED' where s.id = ?1")
    void softDelete(Long id);
}
