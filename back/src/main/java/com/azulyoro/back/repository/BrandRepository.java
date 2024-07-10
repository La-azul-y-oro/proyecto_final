package com.azulyoro.back.repository;

import com.azulyoro.back.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Modifying
    @Query("update Brand b set b.isDeleted = true where b.id = ?1")
    void softDelete(Long id);
}
