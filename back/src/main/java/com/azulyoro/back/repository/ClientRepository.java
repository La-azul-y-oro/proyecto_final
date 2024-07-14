package com.azulyoro.back.repository;

import com.azulyoro.back.model.Client;
import com.azulyoro.back.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Modifying
    @Query("update Client c set c.isDeleted = true where c.id = ?1")
    void softDelete(Long id);

    @Query("SELECT c.services FROM Client c WHERE c.id = :clientId")
    List<Services> findServicesByClientId(@Param("clientId") Long clientId);
}
