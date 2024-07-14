package com.azulyoro.back.repository;

import com.azulyoro.back.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
    @Query("SELECT COUNT(s) FROM Services s WHERE s.serviceType.id = :serviceTypeId AND (s.status = 'TO_DO' OR s.status = 'IN_PROGRESS')")
    long countActiveServices(@Param("serviceTypeId") Long serviceTypeId);
    
    @Modifying
    @Query("update ServiceType sp set sp.isDeleted = true where sp.id = ?1")
    void softDelete(Long id);
}